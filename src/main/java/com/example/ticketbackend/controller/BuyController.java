package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.BuyService;
import com.example.ticketbackend.vo.BuyReq;
import com.example.ticketbackend.vo.PaymenyReq;
import com.example.ticketbackend.vo.RtnCodeRes;

@CrossOrigin
@RestController
public class BuyController {

	@Autowired BuyService buyService;
	
	@PostMapping(value = "api/buy")
	public RtnCodeRes buy(@RequestBody BuyReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_FIRST);
		}
		RtnCodeRes res = buyService.buy(req.getSessionNum(), attr, req.getArea(), req.getBuyPieces());
		return res;	
		}
	
	@PostMapping(value = "api/payment")
	public RtnCodeRes payment(@RequestBody PaymenyReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_FIRST);
		}
		RtnCodeRes res = buyService.payment(req.getBuyNum(), attr);
		return res;	
		}

}
