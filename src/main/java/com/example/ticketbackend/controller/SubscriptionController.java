package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Subscription;
import com.example.ticketbackend.service.ifs.SubscriptionService;
import com.example.ticketbackend.vo.GetSubscribeListRes;
import com.example.ticketbackend.vo.RtnCodeRes;

@CrossOrigin
@RestController
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping(value = "api/getSubscribeList")
	public GetSubscribeListRes getSubscribeList(HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new GetSubscribeListRes(RtnCode.PLEASE_LOGIN_FIRST,null);
		}
		GetSubscribeListRes res = subscriptionService.getSubscribeList(attr);
		return res;
	}
	
	@PostMapping(value = "api/subscribe")
	public RtnCodeRes subscribe(@RequestBody Subscription req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new GetSubscribeListRes(RtnCode.PLEASE_LOGIN_FIRST,null);
		}
		RtnCodeRes res = subscriptionService.subscribe(attr, req.getSubscribe());
		return res;
	}
	
	@PostMapping(value = "api/cancelSubscribe")
	public RtnCodeRes cancelSubscribe(@RequestBody Subscription req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new GetSubscribeListRes(RtnCode.PLEASE_LOGIN_FIRST,null);
		}
		RtnCodeRes res = subscriptionService.cancelSubscribe(attr, req.getSubscribe());
		return res;
	}
}
