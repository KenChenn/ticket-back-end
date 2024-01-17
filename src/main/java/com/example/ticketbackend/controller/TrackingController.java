package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.service.ifs.TrackingService;
import com.example.ticketbackend.vo.GetTrackingListRes;
import com.example.ticketbackend.vo.TrackReq;
import com.example.ticketbackend.vo.TrackRes;

@CrossOrigin
@RestController
public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;

	@PostMapping(value = "api/track")
	public TrackRes track(@RequestBody TrackReq req, HttpSession session) {
		TrackRes res = trackingService.track(req.getTracker(), req.getCommodityCodename());
		return res;
	}
	
	@PostMapping(value = "api/untrack")
	public TrackRes untrack(@RequestBody TrackReq req, HttpSession session) {
		TrackRes res = trackingService.untrack(req.getTracker(), req.getCommodityCodename());
		return res;
	}
	
	@PostMapping(value = "api/checktrack")
	public TrackRes checktrack(@RequestBody TrackReq req, HttpSession session) {
		TrackRes res = trackingService.checktrack(req.getTracker(), req.getCommodityCodename());
		return res;
	}
	
	@PostMapping(value = "api/getTrackingList")
	public GetTrackingListRes getTrackingList(@RequestBody TrackReq req, HttpSession session) {
		GetTrackingListRes res = trackingService.getTrackingList(req.getTracker());
		return res;
	}
	
}
