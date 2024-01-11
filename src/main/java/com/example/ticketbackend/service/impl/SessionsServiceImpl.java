package com.example.ticketbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Sessions;
import com.example.ticketbackend.repository.SessionsDao;
import com.example.ticketbackend.service.ifs.SeatService;
import com.example.ticketbackend.service.ifs.SessionsService;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SessionReq;

@Service
public class SessionsServiceImpl implements SessionsService {

	@Autowired
	private SessionsDao sessionsDao;

	@Autowired
	private SeatService seatService;

	@Override
	public RtnCodeRes sessionAndSeatDataCheck(String codeName, List<SessionReq> sessionData) { // 檢查場次及座位資料
		if (sessionData.size() <= 0) {
			return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
		}
		for (SessionReq session : sessionData) {
			if (!StringUtils.hasText(codeName) || !StringUtils.hasText(session.getCommodity_codename())
					|| session.getShowDateTime() == null || session.getStartSellDateTime() == null
					|| session.getEndSellDateTime() == null) {
				return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
			}
			if (!session.getCommodity_codename().equals(codeName)) {
				return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
			}
			if (session.getStartSellDateTime().isAfter(session.getEndSellDateTime())
					|| session.getEndSellDateTime().isAfter(session.getShowDateTime())) {
				return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
			}
			RtnCodeRes seatDataCheck = seatService.seatDataCheck(session.getSeatData());
			if (seatDataCheck.getRtncode().getCode() != 200) {
				return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
			}

		}
		return new RtnCodeRes(RtnCode.DATA_CHECK_SUCCESSFUL);
	}

	@Override
	public RtnCodeRes addSessions(String codeName, List<SessionReq> sessionData) {
		if (sessionData.size() <= 0) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		List<Sessions> saveData = new ArrayList<>();
		for (SessionReq item : sessionData) {
			if (!item.getCommodity_codename().equals(codeName)) {
				return new RtnCodeRes(RtnCode.SESSION_CODENAME_NOT_MATCH_COMMODITY_CODENAME);
			}
			Sessions session = new Sessions();
			session.setCommodityCodename(item.getCommodity_codename());
			session.setShowDateTime(item.getShowDateTime());
			session.setStartSellDateTime(item.getStartSellDateTime());
			session.setEndSellDateTime(item.getEndSellDateTime());
			saveData.add(session);
		}
		if (saveData.size() <= 0) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		sessionsDao.saveAll(saveData);
		for (SessionReq item : sessionData) {
			RtnCodeRes addSeat = seatService.insertSeat(item.getCommodity_codename(), item.getShowDateTime(),item.getSeatData());
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

}
