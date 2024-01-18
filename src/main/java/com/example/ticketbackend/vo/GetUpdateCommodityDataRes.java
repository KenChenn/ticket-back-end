package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;

public class GetUpdateCommodityDataRes extends RtnCodeRes{

	private AddCommodityReq data;

	public GetUpdateCommodityDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetUpdateCommodityDataRes(RtnCode rtncode,AddCommodityReq data) {
		super(rtncode);
		this.data = data;

	}

	public AddCommodityReq getData() {
		return data;
	}

	public void setData(AddCommodityReq data) {
		this.data = data;
	}

	
	
	




}
