package com.example.ticketbackend.service.impl;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Sessions;
import com.example.ticketbackend.vo.RtnCodeRes;

public class GetSessionsDataRes extends RtnCodeRes{

public List<Sessions> data;

public GetSessionsDataRes() {
	super();
	// TODO Auto-generated constructor stub
}



public GetSessionsDataRes(RtnCode rtncode,List<Sessions> data) {
	super(rtncode);
	this.data = data;
}



public List<Sessions> getData() {
	return data;
}



public void setData(List<Sessions> data) {
	this.data = data;
}








}
