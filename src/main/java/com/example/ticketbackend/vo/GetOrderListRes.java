package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;

public class GetOrderListRes extends RtnCodeRes{
	
	private List<BuyDataVo> data;

	public GetOrderListRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetOrderListRes(RtnCode rtncode,List<BuyDataVo> data) {
		super(rtncode);
		this.data = data;
	}


	public List<BuyDataVo> getData() {
		return data;
	}

	public void setData(List<BuyDataVo> data) {
		this.data = data;
	}
	
	

}
