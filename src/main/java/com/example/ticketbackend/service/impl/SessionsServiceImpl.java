package com.example.ticketbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;
import com.example.ticketbackend.entity.Sessions;
import com.example.ticketbackend.repository.CommodityDao;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.repository.SessionsDao;
import com.example.ticketbackend.service.ifs.SeatService;
import com.example.ticketbackend.service.ifs.SessionsService;
import com.example.ticketbackend.vo.AddCommodityReq;
import com.example.ticketbackend.vo.GetSessionsDateVo;
import com.example.ticketbackend.vo.GetUpdateCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SeatReq;
import com.example.ticketbackend.vo.SessionReq;
import com.example.ticketbackend.vo.UpdateSessionReq;

@Service
public class SessionsServiceImpl implements SessionsService {

	@Autowired
	private SessionsDao sessionsDao;
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private CommodityDao commodityDao;

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
	public RtnCodeRes updateSessionAndSeatDataCheck(String codeName, List<UpdateSessionReq> data) {
		
		
		
		
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

	@Override
	public GetUpdateCommodityDataRes getUpdateCommodityData(String codeName) {
		if(!StringUtils.hasText(codeName)) {
			return new GetUpdateCommodityDataRes(RtnCode.PARAM_ERROR,null);
		}
		Commodity commodity = commodityDao.findByCodename(codeName);
		if(commodity == null) {
			return new GetUpdateCommodityDataRes(RtnCode.DATA_NOT_FOUND,null);
		}
		AddCommodityReq sendData = new AddCommodityReq();
		sendData.setCodeName(commodity.getCodename());
		sendData.setName(commodity.getName());
		sendData.setIntroduction(commodity.getIntroduction());
		sendData.setEntity(commodity.isEntity());
		sendData.setStartDate(commodity.getStartDate());
		sendData.setEndDate(commodity.getEndDate());
		sendData.setPlace(commodity.getPlace());
		sendData.setKeyvisual_img(commodity.getKeyvisualImg());
		sendData.setIntroduce_img1(commodity.getIntroduceImg1());
		sendData.setIntroduce_img2(commodity.getIntroduceImg2());
		sendData.setOrganizer(commodity.getOrganizer());
		List<Sessions> sessionsData = sessionsDao.findByCommodityCodenameOrderByShowDateTime(codeName);
		if(sessionsData.size()<=0) {
			return new GetUpdateCommodityDataRes(RtnCode.DATA_NOT_FOUND,null);
		}
		List<SessionReq> sessionReqs = new ArrayList<SessionReq>();
		for(int i=0;i<sessionsData.size();i++) {
			SessionReq s = new SessionReq();
			s.setCommodity_codename(sessionsData.get(i).getCommodityCodename());
			s.setShowDateTime(sessionsData.get(i).getShowDateTime());
			s.setStartSellDateTime(sessionsData.get(i).getStartSellDateTime());
			s.setEndSellDateTime(sessionsData.get(i).getEndSellDateTime());
			List<SeatReq> seatReqs = seatDao.gettotalSeatDataByNum(sessionsData.get(i).getNum());
			if(seatReqs.size() <= 0) {
				return new GetUpdateCommodityDataRes(RtnCode.DATA_NOT_FOUND,null);
			}
			s.setSeatData(seatReqs);
			sessionReqs.add(s);
		}
		sendData.setSessionData(sessionReqs);
		return new GetUpdateCommodityDataRes(RtnCode.SUCCESSFUL,sendData);
	}

	@Override
	public GetSessionsDataRes getSessionsData(String codeName) {
		if(!StringUtils.hasText(codeName)) {
			return new GetSessionsDataRes(RtnCode.PARAM_ERROR,null);
		}
		List<Sessions> data = sessionsDao.findByCommodityCodenameOrderByShowDateTime(codeName);
		return new GetSessionsDataRes(RtnCode.SUCCESSFUL,data);
	}


	@Override
	public RtnCodeRes udpateCommodityAndSeat(String codeName, List<UpdateSessionReq> data) {
		// TODO Auto-generated method stub
		return null;
	}

}
