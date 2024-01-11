package com.example.ticketbackend.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.util.Base64;

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
import com.example.ticketbackend.vo.CommodityReq;
import com.example.ticketbackend.vo.GetCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.TestReq;

@CrossOrigin
@RestController
public class CommodityController {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CommodityService commodityService;

	@PostMapping(value = "api/add_commodity")
	public RtnCodeRes addCommodity(@RequestBody CommodityReq req, HttpSession session) {
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
	public RtnCodeRes updateCommodity(@RequestBody CommodityReq req, HttpSession session) {
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
	public GetCommodityDataRes getCommodity(@RequestBody CommodityReq req) {
		
		return commodityService.getCommodityDate(req.getCodename());
	}

	@PostMapping(value = "api/search_commodity")
	public GetCommodityDataRes searchCommodity(@RequestBody CommodityReq req) {
		return commodityService.searchCommodity(req.getName());
	}
	
	
//	@PostMapping(value = "api/test")
//	public void test(@RequestBody TestReq req) {
//
//		byte[] decodeBytes = Base64.getDecoder().decode(req.getData().get("visionPicture"));
//		try {
//			Connection conn = dataSource.getConnection();
//			Blob blob = conn.createBlob();
//			blob.setBytes(1, decodeBytes);
//			String s = convert64(blob);
//			System.out.println(s);
//		} catch (Exception e) {
//			
//		}
//
//	}



}
