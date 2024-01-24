package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;

public class GetUpdateCommodityDataRes extends RtnCodeRes{

	private UpdateCommodityReq data;

	public GetUpdateCommodityDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetUpdateCommodityDataRes(RtnCode rtncode,UpdateCommodityReq data) {
		super(rtncode);
		this.data = data;

	}

	public UpdateCommodityReq getData() {
		return data;
	}

	public void setData(UpdateCommodityReq data) {
		this.data = data;
	}

	
	
	




}
