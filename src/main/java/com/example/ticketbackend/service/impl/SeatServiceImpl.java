package com.example.ticketbackend.service.impl;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.repository.SessionsDao;
import com.example.ticketbackend.service.ifs.SeatService;
import com.example.ticketbackend.vo.GetRemainingTicketsRes;
import com.example.ticketbackend.vo.GetRemainingTicketsVo;
import com.example.ticketbackend.vo.GetSeatDataVo;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SeatReq;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatDao seatDao;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SessionsDao sessionsDao;

	@Override
	public RtnCodeRes insertSeat(String commodityCodename, LocalDateTime showDateTime, List<SeatReq> data) {
		int sessionNum = sessionsDao.getSessionNum(commodityCodename, showDateTime);
		if (sessionNum <= 0) {
			return new RtnCodeRes(RtnCode.SEAT_ADD_ERROR);
		}
		List<Seat> seatData = new ArrayList<Seat>();
		for (SeatReq item : data) {
			for (int i = 1; i <= item.getMaxSeatNum(); i++) {
				// 節目編號、區域名稱、座位號碼、區域價錢
				seatData.add(new Seat(sessionNum, item.getArea(), i, item.getPrice()));
			}
		}
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			seatDao.insertSeat(connection, seatData);
		} catch (Exception e) {

		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes seatDataCheck(List<SeatReq> seatData) { // 檢查座位資料
		if (seatData.size() <= 0) {
			return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
		}
		for (SeatReq seat : seatData) {
			if (!StringUtils.hasText(seat.getArea()) || seat.getMaxSeatNum() <= 0 || seat.getPrice() < 0) {
				return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
			}
		}
		return new RtnCodeRes(RtnCode.DATA_CHECK_SUCCESSFUL);
	}


	@Override
	public RtnCodeRes cancelOrder(String account, String buyNum) {
		if (!StringUtils.hasText(account)|| !StringUtils.hasText(buyNum)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		List<GetSeatDataVo> data = seatDao.getSeatDataByBuyNum(buyNum);
		if(data.size() <= 0) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		if(!data.get(0).getBuyAccount().equals(account)) {
			return new RtnCodeRes(RtnCode.BUYER_ERROR);
		}
		if(LocalDateTime.now().isAfter(data.get(0).getPayFinalDate())) {
			return new RtnCodeRes(RtnCode.ORDER_EXPIRED);
		}
		
		if(LocalDateTime.now().isBefore(data.get(0).getStartSellDateTime()) || LocalDateTime.now().isAfter(data.get(0).getEndSellDateTime())) {
			return new RtnCodeRes(RtnCode.NOT_CANCEL_DATE);
		}
		List<Seat> saveData = new ArrayList<Seat>();
		for (int i = 0; i < data.size(); i++) {
			Seat s = new Seat();
			s.setNum(data.get(i).getNum());
			s.setArea(data.get(i).getArea());
			s.setSeatNum(data.get(i).getSeatNum());
			s.setPrice(data.get(i).getPrice());
			s.setBuyNum(null);
			s.setVersion(data.get(i).getVersion());
			saveData.add(s);
		}
		try {
			seatDao.saveAll(saveData);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.CANCEL_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetRemainingTicketsRes getRemainingTickets(int num) {
		if (num <= 0) {
			return new GetRemainingTicketsRes(RtnCode.PARAM_ERROR,null);
		}
		List<GetRemainingTicketsVo> data = seatDao.getRemainingTickets(num);
		
		return new GetRemainingTicketsRes(RtnCode.SUCCESSFUL,data);
	}
	
	@Scheduled(cron="0 0/3 * * * ?")
//	@Scheduled(cron = "* * * * * *")
	public void checkPayment() {
		System.out.println(LocalDateTime.now().toString()+"_排程啟動，檢查是否繳費");
		seatDao.checkPayment();
	}
}
