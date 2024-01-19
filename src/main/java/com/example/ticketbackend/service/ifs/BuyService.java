package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.GetOrderListRes;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface BuyService {
	
	public RtnCodeRes buy(int sessionsNum,String buyAccount, String area,int buyPieces);

	public RtnCodeRes payment(String buyNum,String account);
	
	public GetOrderListRes getOrderList(String account);
		

}
