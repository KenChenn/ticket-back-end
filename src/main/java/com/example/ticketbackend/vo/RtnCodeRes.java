package com.example.ticketbackend.vo;

import com.example.ticketbackend.constants.RtnCode;

public class RtnCodeRes {
	
	private RtnCode rtncode;

	public RtnCodeRes() {
		super();
	}

	public RtnCodeRes(RtnCode rtncode) {
		super();
		this.rtncode = rtncode;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}
	
	
	

}
