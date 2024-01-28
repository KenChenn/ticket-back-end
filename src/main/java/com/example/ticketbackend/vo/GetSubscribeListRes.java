package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Subscription;

public class GetSubscribeListRes extends RtnCodeRes{

	List<Subscription> SubscribeList;

	public GetSubscribeListRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetSubscribeListRes(RtnCode rtncode,List<Subscription> subscribeList) {
		super(rtncode);
		SubscribeList = subscribeList;
	}

	public List<Subscription> getSubscribeList() {
		return SubscribeList;
	}

	public void setSubscribeList(List<Subscription> subscribeList) {
		SubscribeList = subscribeList;
	}


	
	
}
