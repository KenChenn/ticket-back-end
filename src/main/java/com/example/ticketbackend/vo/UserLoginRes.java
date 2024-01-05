package com.example.ticketbackend.vo;

import com.example.ticketbackend.constants.RtnCode;

public class UserLoginRes {
	
	private RtnCode rtncode;

	public UserLoginRes() {
		super();
	}

	public UserLoginRes(RtnCode rtncode) {
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
