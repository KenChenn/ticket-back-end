package com.example.ticketbackend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.SeatService;
import com.example.ticketbackend.vo.PaymenyReq;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SeatReq;

@CrossOrigin
@RestController
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	@PostMapping(value="api/insert_seat")
	public RtnCodeRes insertSeat(@RequestBody List<SeatReq> req) {
//		seatService.insertSeat(req);
		return null;
	}
	
	@PostMapping(value="api/cancelOrder")
	public RtnCodeRes cancelOrder(@RequestBody PaymenyReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_FIRST);
		}
		RtnCodeRes res = seatService.cancelOrder(attr,req.getBuyNum());
		return res;
	}
	

}
