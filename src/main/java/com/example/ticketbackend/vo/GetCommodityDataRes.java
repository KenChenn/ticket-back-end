package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;

public class GetCommodityDataRes extends RtnCodeRes{

//	private Commodity commodity;
	
	private List<Commodity> commodityList;

	public GetCommodityDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetCommodityDataRes(RtnCode rtncode,List<Commodity> commodityList) {
		super(rtncode);
		this.commodityList = commodityList;

	}

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}






	


	
}
