package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.RabbitmqService;
import com.example.ticketbackend.vo.GetAllQueueRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SendSubscribeMsg;

@CrossOrigin
@RestController
public class RabbitmqController {
	
	@Autowired
	RabbitmqService rabbitmqService;
	
	@GetMapping(value = "api/getAllSubscribe")
	public GetAllQueueRes getAllQueue() {
		GetAllQueueRes res = rabbitmqService.getAllQueue();
		return res;
	}
	
	@PostMapping(value = "api/SendSubscribeMsg")
	public RtnCodeRes SendSubscribeMsg(@RequestBody SendSubscribeMsg req,HttpSession session) {
		String attr = (String) session.getAttribute("isAdmin");
		if (!StringUtils.hasText(attr) || attr != "true") {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
		}
		RtnCodeRes res = rabbitmqService.sendMsg(req.getSubscribe(), req.getMessage());
		return res;
	}
	
	
	

}
