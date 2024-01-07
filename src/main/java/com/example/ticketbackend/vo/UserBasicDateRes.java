package com.example.ticketbackend.vo;

import java.time.LocalDate;

import com.example.ticketbackend.constants.RtnCode;

public class UserBasicDateRes extends RtnCodeRes{
	
	private String username;
	
	private String email;
	
	private LocalDate bornDate;
	
	private String phone;
	
	public UserBasicDateRes() {
		super();
	}

	public UserBasicDateRes(RtnCode rtncode,String username, String email, LocalDate bornDate, String phone) {
		super(rtncode);
		this.username = username;
		this.email = email;
		this.bornDate = bornDate;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
