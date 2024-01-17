package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.CommodityService;
import com.example.ticketbackend.service.ifs.SessionsService;
import com.example.ticketbackend.vo.AddCommodityReq;
import com.example.ticketbackend.vo.CommodityReq1;
import com.example.ticketbackend.vo.GetCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SessionReq;

@CrossOrigin
@RestController
public class CommodityController {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private SessionsService sessionsService;

	@PostMapping(value = "api/add_commodity")
	public RtnCodeRes addCommodity(@RequestBody CommodityReq1 req, HttpSession session) {
		String attr = (String) session.getAttribute("isAdmin");
		if (!StringUtils.hasText(attr) || attr != "true") {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
		}
		RtnCodeRes res = commodityService.addCommodity(req.getCodename(), req.getName(), req.getIntroduction(),
				req.isEnity(), req.getStartDate(), req.getEndDate(), req.getPlace(), req.getKeyvisualImg(), req.getIntroduceImg1(),
				req.getIntroduceImg2(), req.getOrganizer());
		return res;
	}

	@PostMapping(value = "api/update_commodity")
	public RtnCodeRes updateCommodity(@RequestBody CommodityReq1 req, HttpSession session) {
		String attr = (String) session.getAttribute("isAdmin");
		if (!StringUtils.hasText(attr) || attr != "true") {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
		}
		RtnCodeRes res = commodityService.updateCommodity(req.getCodename(), req.getName(), req.getIntroduction(),
				req.isEnity(), req.getStartDate(), req.getEndDate(), req.getPlace(), req.getKeyvisualImg(), req.getIntroduceImg1(),
				req.getIntroduceImg2(), req.getOrganizer());
		return res;
	}

	@PostMapping(value = "api/delete_commodity")
	public RtnCodeRes deleteCommodity() {

		return null;
	}
	
	@PostMapping(value = "api/get_commodity")
	public GetCommodityDataRes getCommodity(@RequestBody CommodityReq1 req) {
		
		return commodityService.getCommodityDate(req.getCodename());
	}

	@PostMapping(value = "api/search_commodity")
	public GetCommodityDataRes searchCommodity(@RequestBody CommodityReq1 req) {
		return commodityService.searchCommodity(req.getName());
	}
	
	@PostMapping(value = "api/check_codename")
	public RtnCodeRes checkCodeName(@RequestBody CommodityReq1 req) {
		return commodityService.checkCodeName(req.getCodename());
	}
	
	@PostMapping(value = "api/add_commodity_and_session")
	public RtnCodeRes addCommodityAndSession(@RequestBody AddCommodityReq req, HttpSession session) {
		String attr = (String) session.getAttribute("isAdmin");
		if (!StringUtils.hasText(attr) || attr != "true") {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
		}
		RtnCodeRes commodityDataCheck = commodityService.commodityDataCheck(req.getCodeName(), req.getName(), req.getIntroduction(), req.isEntity(), req.getStartDate(), req.getEndDate(), req.getPlace(), req.getOrganizer());
		RtnCodeRes sessionsAndSeatDataCheck = sessionsService.sessionAndSeatDataCheck(req.getCodeName(),req.getSessionData());
		if(commodityDataCheck.getRtncode().getCode() !=200 || sessionsAndSeatDataCheck.getRtncode().getCode() !=200) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		RtnCodeRes creatCommodity = commodityService.addCommodity(req.getCodeName(), req.getName(), req.getIntroduction(), req.isEntity(), req.getStartDate(), req.getEndDate(), req.getPlace(), req.getKeyvisual_img(), req.getIntroduce_img1(), req.getIntroduce_img2(), req.getOrganizer());
		if(creatCommodity.getRtncode().getCode() != 200) {
			return new RtnCodeRes(creatCommodity.getRtncode());
		}
		RtnCodeRes creatSessions = sessionsService.addSessions(req.getCodeName(),req.getSessionData());
		if(creatSessions.getRtncode().getCode() != 200) {
			return new RtnCodeRes(creatSessions.getRtncode());
		}

		return new RtnCodeRes(RtnCode.SUCCESSFUL);	
		}
	

}
