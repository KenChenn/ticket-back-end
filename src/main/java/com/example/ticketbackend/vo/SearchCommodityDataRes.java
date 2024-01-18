package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;

public class SearchCommodityDataRes extends RtnCodeRes{

	private List<Commodity> commodityList;

	public SearchCommodityDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchCommodityDataRes(RtnCode rtncode,List<Commodity> commodityList) {
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
