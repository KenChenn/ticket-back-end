package com.example.ticketbackend.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Buy;
import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.repository.BuyDao;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.service.ifs.BuyService;
import com.example.ticketbackend.vo.RtnCodeRes;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	SeatDao seatDao;
	@Autowired
	BuyDao buyDao;

	@Override
	public RtnCodeRes buy(int sessionsNum, String buyAccount, String area, int buyPieces) {
		if (sessionsNum <= 0 || !StringUtils.hasText(buyAccount) || !StringUtils.hasText(area) || buyPieces <= 0) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if (buyPieces > 4) {
			return new RtnCodeRes(RtnCode.EXCEED_THE_UPPER_LIMIT);
		}
		Pageable pageable = PageRequest.of(0, buyPieces);
		List<Seat> data = seatDao.findAllTopNByNumAndAreaAndBuyNumIsNull(sessionsNum, area, pageable);
		if (data.size() < buyPieces) {
			return new RtnCodeRes(RtnCode.NOT_ENOUGH_TICKETS);
		}
		UUID uuidCreate = UUID.randomUUID();
		String uuid = Long.toString(uuidCreate.getMostSignificantBits()).substring(1, 10)
				+ RandomStringUtils.randomNumeric(3);
		int totalPrice = 0;
		for (int i = 0; i < data.size(); i++) {
			data.get(i).setBuyNum(uuid);
			totalPrice += data.get(i).getPrice();
		}
		try {
			seatDao.saveAll(data);
		} catch (Exception e) {
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
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

}
