package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;

public class GetRemainingTicketsRes extends RtnCodeRes{

	private List<GetRemainingTicketsVo> data;

	public GetRemainingTicketsRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetRemainingTicketsRes(RtnCode rtncode,List<GetRemainingTicketsVo> data) {
		super(rtncode);
		this.data = data;
	}

	public List<GetRemainingTicketsVo> getData() {
		return data;
	}

	public void setData(List<GetRemainingTicketsVo> data) {
		this.data = data;
	}

	
	
	
}
