package com.example.ticketbackend.vo;

import java.util.List;
import java.util.Map;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.User;

public class UserBasicDateRes extends RtnCodeRes{
		
//	private String username;
//	
//	private String email;
//	
//	private LocalDate bornDate;
//	
	private Map<String,Object> data;

	public UserBasicDateRes() {
		super();
	}

	public UserBasicDateRes(RtnCode rtncode,Map<String, Object> data) {
		super(rtncode);
		this.data = data;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}


}
