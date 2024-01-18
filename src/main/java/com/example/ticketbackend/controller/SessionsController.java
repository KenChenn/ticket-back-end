package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.SessionsService;
import com.example.ticketbackend.service.impl.GetSessionsDataRes;
import com.example.ticketbackend.vo.CommodityReq1;
import com.example.ticketbackend.vo.GetUpdateCommodityDataRes;

@CrossOrigin
@RestController
public class SessionsController {
	
	@Autowired
	SessionsService sessionsService;

	@PostMapping(value="api/get_update_commmodity_data")
	public GetUpdateCommodityDataRes getSessionsData(@RequestBody CommodityReq1 req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new GetUpdateCommodityDataRes(RtnCode.PLEASE_LOGIN_FIRST,null);
		}
		GetUpdateCommodityDataRes res = sessionsService.getUpdateCommodityData(req.getCodename());
		return res;
	}
	
	@PostMapping(value="api/get_Sessions")
	public GetSessionsDataRes getSessions(@RequestBody CommodityReq1 req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new GetSessionsDataRes(RtnCode.PLEASE_LOGIN_FIRST,null);
		}
		return sessionsService.getSessionsData(req.getCodename());
	}

}
