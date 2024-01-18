package com.example.ticketbackend.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;
import com.example.ticketbackend.repository.CommodityDao;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.repository.SessionsDao;
import com.example.ticketbackend.service.ifs.CommodityService;
import com.example.ticketbackend.vo.GetAllCommodity;
import com.example.ticketbackend.vo.GetCommodityAndSessionsVo;
import com.example.ticketbackend.vo.GetCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SearchCommodityDataRes;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private SeatDao seatDao;
	@Autowired
	private SessionsDao sessionsDao;

	@Override
	public RtnCodeRes commodityDataCheck(String codename, String name, String introduction, Boolean entity,
			LocalDate startDate, LocalDate endDate, String place, String organizer) {
		Optional<LocalDate> startDateOP = Optional.ofNullable(startDate);
		Optional<LocalDate> endDateOP = Optional.ofNullable(endDate);
		if (!StringUtils.hasText(codename) || !StringUtils.hasText(name) || !StringUtils.hasText(introduction)
				|| entity == null || !startDateOP.isPresent() || !endDateOP.isPresent() || !StringUtils.hasText(place)
				|| !StringUtils.hasText(organizer)) {
			return new RtnCodeRes(RtnCode.DATA_CHECK_ERROR);
		}
		return new RtnCodeRes(RtnCode.DATA_CHECK_SUCCESSFUL);
	}

	@Override
	public RtnCodeRes addCommodity(String codename, String name, String introduction, Boolean entity,
			LocalDate startDate, LocalDate endDate, String place, String keyvisualImg, String introduceImg1,
			String introduceImg2, String organizer) {
		Optional<LocalDate> startDateOP = Optional.ofNullable(startDate);
		Optional<LocalDate> endDateOP = Optional.ofNullable(endDate);
		if (!StringUtils.hasText(codename) || !StringUtils.hasText(name) || !StringUtils.hasText(introduction)
				|| entity == null || !startDateOP.isPresent() || !endDateOP.isPresent() || !StringUtils.hasText(place)
				|| !StringUtils.hasText(organizer)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if (startDate.isAfter(endDate)) {
			return new RtnCodeRes(RtnCode.DATE_FORMAT_ERROR);
		}
		if (commodityDao.existsByCodename(codename)) {
			return new RtnCodeRes(RtnCode.CODENAME_EXISTED);
		}
		try {
			commodityDao.save(new Commodity(codename, name, introduction, entity, startDate, endDate, place,
					keyvisualImg, introduceImg1, introduceImg2, organizer));
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.COMMODITY_ADD_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetCommodityDataRes getCommodityDate(String codename) {
		if (!StringUtils.hasText(codename)) {
			return new GetCommodityDataRes(RtnCode.PARAM_ERROR, null);
		}
		Commodity commodity = commodityDao.findByCodename(codename);
		if (commodity == null) {
			return new GetCommodityDataRes(RtnCode.DATA_NOT_FOUND, null);
		}

		return new GetCommodityDataRes(RtnCode.SUCCESSFUL, commodity);
	}

	@Override
	public RtnCodeRes updateCommodity(String codename, String name, String introduction, Boolean entity,
			 String place, String keyvisualImg, String introduceImg1,
			String introduceImg2, String organizer) {
		if (!StringUtils.hasText(codename) || !StringUtils.hasText(name) || !StringUtils.hasText(introduction)
				|| !StringUtils.hasText(place) || !StringUtils.hasText(organizer) || entity == null) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Commodity commodity = commodityDao.findByCodename(codename);
		if (commodity == null) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		if(!name.equals(commodity.getName())) {
			commodity.setName(name);
		}
		if(!introduction.equals(commodity.getIntroduction())) {
			commodity.setIntroduction(introduction);
		}
		if(entity != commodity.isEntity()) {
			commodity.setEntity(entity);
		}
		if(!place.equals(commodity.getPlace())) {
			commodity.setPlace(place);
		}
		if(keyvisualImg != null && !keyvisualImg.equals(commodity.getKeyvisualImg())) {
			commodity.setKeyvisualImg(keyvisualImg);
		}
		if(introduceImg1 != null && !introduceImg1.equals(commodity.getIntroduceImg1())) {
			commodity.setIntroduceImg1(introduceImg1);
		}
		if(introduceImg2 != null && !introduceImg2.equals(commodity.getIntroduceImg2())) {
			commodity.setIntroduceImg2(introduceImg2);
		}
		if(!organizer.equals(commodity.getOrganizer())) {
			commodity.setOrganizer(organizer);
		}
		try {
			commodityDao.save(commodity);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.COMMODITY_UPDATE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}


	@Override
	public SearchCommodityDataRes searchCommodity(String name) {
		return new SearchCommodityDataRes(RtnCode.SUCCESSFUL, commodityDao.searchCommodity(name));
	}

	@Override
	public RtnCodeRes checkCodeName(String codename) {
		if (!StringUtils.hasText(codename)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if (commodityDao.existsByCodename(codename)) {
			return new RtnCodeRes(RtnCode.CODENAME_EXISTED);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes deleteCommodity(String codename) {
		if (!StringUtils.hasText(codename)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		List<GetCommodityAndSessionsVo> cAndSData = commodityDao.getCommodityAndSessions(codename);
		if(cAndSData.size()<=0) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		if(LocalDateTime.now().isAfter(cAndSData.get(0).getStartSellDatetime())) {
			return new RtnCodeRes(RtnCode.SESSIONS_ALREADY_SELLED);
		}
		for(int i = 0; i<cAndSData.size();i++) {
			try {
				seatDao.deleteSeatByNum(cAndSData.get(i).getNum());
				sessionsDao.deleteSessionsByNum(cAndSData.get(i).getNum());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			commodityDao.deleteById(cAndSData.get(0).getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetAllCommodity getAllCommodity() {
		List<Commodity> data = commodityDao.getAllCommodity();
		return new GetAllCommodity(RtnCode.SUCCESSFUL,data);
	}

}
