package com.example.ticketbackend.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Buy;
import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.entity.User;
import com.example.ticketbackend.repository.BuyDao;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.repository.UserDao;
import com.example.ticketbackend.service.ifs.BuyService;
import com.example.ticketbackend.service.ifs.MailService;
import com.example.ticketbackend.vo.BuyDataVo;
import com.example.ticketbackend.vo.CreateTicketVo;
import com.example.ticketbackend.vo.GetOrderListRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.TicketJoinVo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;


@EnableScheduling
@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	SeatDao seatDao;
	@Autowired
	BuyDao buyDao;
	
	@Autowired
	UserDao userDao;

	@Autowired
	private MailService mailService;
	
	@Override
	public RtnCodeRes buy(int sessionsNum, String buyAccount, String area, int buyPieces) {
		if (sessionsNum <= 0 || !StringUtils.hasText(buyAccount) || !StringUtils.hasText(area) || buyPieces <= 0) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if (buyPieces > 4) {
			return new RtnCodeRes(RtnCode.EXCEED_THE_UPPER_LIMIT);
		}
//		Pageable pageable = PageRequest.of(0, buyPieces);
//		List<Seat> data = seatDao.findAllTopNByNumAndAreaAndBuyNumIsNull(sessionsNum, area, pageable);
		List<TicketJoinVo> data = seatDao.getTickets(sessionsNum, area, PageRequest.of(0, buyPieces));	
		System.out.println(data.size());
		if (data.size() < buyPieces) {
			return new RtnCodeRes(RtnCode.NOT_ENOUGH_TICKETS);
		}
		if(LocalDateTime.now().isBefore(data.get(0).getStartSellDateTime()) || LocalDateTime.now().isAfter(data.get(0).getEndSellDateTime())) {
			return new RtnCodeRes(RtnCode.NOT_SELLING_DATE);
		}
		UUID uuidCreate = UUID.randomUUID();
		String uuid = Long.toString(uuidCreate.getMostSignificantBits()).substring(1, 10)
				+ RandomStringUtils.randomNumeric(3);
		int totalPrice = 0;
		List<Seat> saveData = new ArrayList<Seat>();
		for (int i = 0; i < data.size(); i++) {
//			data.get(i).setBuyNum(uuid);
			totalPrice += data.get(i).getPrice();
			Seat s = new Seat();
			s.setNum(data.get(i).getNum());
			s.setArea(data.get(i).getArea());
			s.setSeatNum(data.get(i).getSeatNum());
			s.setPrice(data.get(i).getPrice());
			s.setBuyNum(uuid);
			s.setVersion(data.get(i).getVersion());
			saveData.add(s);
		}
		try {
			seatDao.saveAll(saveData);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("�x�s����");
			return new RtnCodeRes(RtnCode.ORDER_ERROR);
		}
		LocalDateTime deadLine = LocalDateTime.now().plusDays(3);
		deadLine = LocalDateTime.of(deadLine.toLocalDate(), LocalTime.of(23, 59,59));
		Buy newOrder = new Buy(uuid, sessionsNum, buyAccount, LocalDateTime.now(), totalPrice, deadLine);
		try {
			buyDao.save(newOrder);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.ORDER_ERROR);
		}
		System.out.println(uuid);
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes payment(String buyNum, String account) {
		if (!StringUtils.hasText(buyNum) || !StringUtils.hasText(account)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Buy payReady = buyDao.findByBuyNum(buyNum);
		if(payReady == null) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		if(!account.equals(payReady.getBuyAccount())) {
			return new RtnCodeRes(RtnCode.BUYER_ERROR);
		}
		if(LocalDateTime.now().isAfter(payReady.getPayFinalDate())) {
			return new RtnCodeRes(RtnCode.PAYMENT_DEADLINE_EXCEEDED);
		}
		payReady.setPayment(true);
		try {
			buyDao.save(payReady);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.PAYMENT_ERROR);
		}
		User userData = userDao.findByAccountAndAdminFalse(account);
		if(userData == null) {
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		List<ByteArrayResource> ticket = createTicket(payReady.getBuyNum()); 
		mailService.ticketSend(userData.getEmail(), userData.getUsername(), buyNum, ticket);
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetOrderListRes getOrderList(String account) {
		if (!StringUtils.hasText(account)) {
			return new GetOrderListRes(RtnCode.PARAM_ERROR,null);
		}
		List<BuyDataVo> data = buyDao.getOrderList(account);
		if(data.size()<=0) {
			return new GetOrderListRes(RtnCode.SUCCESSFUL,null);
		}
		for(int i =0;i<data.size();i++) {
			List<Seat> seatData = seatDao.findByBuyNumOrderBySeatNum(data.get(i).getBuyNum());
			data.get(i).setSeatData(seatData);
		}
		return new GetOrderListRes(RtnCode.SUCCESSFUL,data);
	}
	
	//����QR�X
	public List<ByteArrayResource> createTicket(String buyNum) {
		List<CreateTicketVo> data = buyDao.getCreateTicketData(buyNum);
		if(data.size()<=0) {
			return null;
		}
		List<ByteArrayResource> ticketList =  new ArrayList<ByteArrayResource>(); //�����i�঳�h�i�A�ҥH�إߤ@��List�˲�����ByteArrayResource
		for (CreateTicketVo item : data) {
			JSONObject ticketData = new JSONObject();  //�Ы�QR�X���e�A�榡��JSON
			ticketData.put("�q��s��", buyNum);
			ticketData.put("�m�W", item.getRealName());
			ticketData.put("�y��", item.getArea()+ "-" +item.getSeatNum());
			Map<EncodeHintType, Object> hints = new HashMap<>();
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); //�]�w�s�X�覡�A����ýX
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  //�إߤ@�Ӧr�`�]Byte�^�}�C��X�y
	        try {
	        	//�z�LZxing Library ����k�ͦ�QR�X�A								//���QR�X���x�}(QR�X�����e�B���w�ͦ�QR�X�B�e�סB���סB�]�w�B�~���t�m�ﶵ)        //�Ϥ��榡  //�NQR�X�g�i�o�ӿ�X�y
	            MatrixToImageWriter.writeToStream(new QRCodeWriter().encode(ticketData.toString(), BarcodeFormat.QR_CODE, 300, 300, hints), "png", outputStream); 
	        } catch (IOException |WriterException  e) { //QRCodeWriter().encode...�|��WriterException�AMatrixToImageWriter.writeToStream...�|��IOException�A�ҥH�n�o�˼g�άO�g���try...catch...
	        	  e.printStackTrace();
	        	  continue;
			}
	        byte[] qcBytes = outputStream.toByteArray(); //�N�ثe��X�y���ƾ��ഫ��byte[]�A�o�氵���H��qcBytes�̭��񪺬Oqe�X���G�i��
	        ByteArrayResource qrCodeResource = new ByteArrayResource(qcBytes); //�z�LByteArrayResource class �নSpring��K�ϥΪ��榡�A�Ҧp�ഫ�^�Ϥ��B���
	        ticketList.add(qrCodeResource);
		}
		return ticketList;
	}
	

}
