package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;

public class GetAllQueueRes extends RtnCodeRes{

	List<String> typeList;

	public GetAllQueueRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllQueueRes(RtnCode rtncode,List<String> typeList) {
		super(rtncode);
		this.typeList = typeList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}


	
	
}
