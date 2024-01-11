package com.example.ticketbackend.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;
import com.example.ticketbackend.repository.CommodityDao;
import com.example.ticketbackend.service.ifs.CommodityService;
import com.example.ticketbackend.vo.CommodityRes;
import com.example.ticketbackend.vo.GetCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;

	@Override
	public RtnCodeRes addCommodity(String codename, String name, String introduction, Boolean entity,
			LocalDate startDate, LocalDate endDate, String place, String keyvisualImg, String introduceImg1,
			String introduceImg2, String organizer) {
		Optional<LocalDate> startDateOP = Optional.ofNullable(startDate);
		Optional<LocalDate> endDateOP = Optional.ofNullable(endDate);
		if (!StringUtils.hasText(codename) || !StringUtils.hasText(name) || !StringUtils.hasText(introduction) || entity == null || !startDateOP.isPresent()
				|| !endDateOP.isPresent() || !StringUtils.hasText(place) || !StringUtils.hasText(organizer)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if (startDate.isAfter(endDate)) {
			return new RtnCodeRes(RtnCode.DATE_FORMAT_ERROR);
		}
		if(commodityDao.existsById(codename)) {
			return new RtnCodeRes(RtnCode.CODENAME_EXISTED);
		}
		try {
			commodityDao.save(new Commodity(codename,name,introduction,entity,startDate,endDate,place,keyvisualImg,introduceImg1,introduceImg2,organizer));
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.COMMODITY_ADD_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetCommodityDataRes getCommodityDate(String codename) {
		if (!StringUtils.hasText(codename)) {
			return new GetCommodityDataRes(RtnCode.PARAM_ERROR,null);
		}
		List<Commodity> commodityList = commodityDao.findByCodename(codename);
		if (commodityList.size()<=0) {
			return new GetCommodityDataRes(RtnCode.DATA_NOT_FOUND,null);
		}
//		Commodity commodity = op.get();

		return new GetCommodityDataRes(RtnCode.SUCCESSFUL,commodityList);
	}

	@Override
	public RtnCodeRes updateCommodity(String codename, String name, String introduction, Boolean entity,
			LocalDate startDate, LocalDate endDate, String place, String keyvisualImg, String introduceImg1,
			String introduceImg2, String organizer) {
		Optional<LocalDate> startDateOP = Optional.ofNullable(startDate);
		Optional<LocalDate> endDateOP = Optional.ofNullable(endDate);
//		if (!StringUtils.hasText(codename) || !StringUtils.hasText(name) || !StringUtils.hasText(introduction) || entity == null || !startDateOP.isPresent()
//				|| !endDateOP.isPresent() || !StringUtils.hasText(place) || !StringUtils.hasText(organizer)) {
//			return new RtnCodeRes(RtnCode.PARAM_ERROR);
//		}
		if (!StringUtils.hasText(codename)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Optional<Commodity> op = commodityDao.findById(codename);
		if (op.isEmpty()) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		if (startDate.isAfter(endDate)) {
			return new RtnCodeRes(RtnCode.DATE_FORMAT_ERROR);
		}
		Commodity commodity = op.get();
		if(StringUtils.hasText(name)) {
			commodity.setName(name);
		}
		if(StringUtils.hasText(introduction)) {
			commodity.setIntroduction(introduction);
		}
		if(entity != null ) {
			commodity.setEntity(entity);
		}
		if(startDateOP.isPresent()) {
			commodity.setStartDate(startDate);
		}
		if(endDateOP.isPresent()) {
			commodity.setEndDate(endDate);
		}
		if(StringUtils.hasText(place)) {
			commodity.setPlace(place);
		}
		if(StringUtils.hasText(keyvisualImg)) {
			commodity.setKeyvisualImg(keyvisualImg);
		}
		if(StringUtils.hasText(introduceImg1)) {
			commodity.setIntroduceImg1(introduceImg1);
		}
		if(StringUtils.hasText(introduceImg2)) {
			commodity.setIntroduceImg2(introduceImg2);
		}
		if(StringUtils.hasText(organizer)) {
			commodity.setOrganizer(organizer);
		}	
		try {
			commodityDao.save(commodity);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.ORGANIZER_UPDATE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetCommodityDataRes searchCommodity(String name) {
		return new GetCommodityDataRes(RtnCode.SUCCESSFUL,commodityDao.searchCommodity(name));
	}

	
	

}
