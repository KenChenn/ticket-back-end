package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;

public class GetCommodityDataRes extends RtnCodeRes{

//	private Commodity commodity;
	
	private Commodity commodityList;

	public GetCommodityDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public GetCommodityDataRes(RtnCode rtncode,Commodity commodityList) {
		super(rtncode);
		this.commodityList = commodityList;
	}



	public Commodity getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(Commodity commodityList) {
		this.commodityList = commodityList;
	}








	


	
}
