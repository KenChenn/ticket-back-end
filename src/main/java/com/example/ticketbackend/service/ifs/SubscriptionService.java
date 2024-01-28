package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.GetSubscribeListRes;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface SubscriptionService {
	
	public GetSubscribeListRes getSubscribeList(String account);
	
	public RtnCodeRes subscribe(String account,String subscribe);
	
	public RtnCodeRes cancelSubscribe(String account,String subscribe);
	

}
