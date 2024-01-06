package com.example.ticketbackend.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignUpReq {
	
	private String account;
	
	@JsonProperty("password")
	private String pwd;
	
	private String realname;
	
	private String username;
	
	private String email;
	
	@JsonProperty("born_date")
	private LocalDate bornDate;
	
	private String phone;

	public UserSignUpReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSignUpReq(String account, String pwd, String realname, String username, String email, LocalDate bornDate,
			String phone) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.realname = realname;
		this.username = username;
		this.email = email;
		this.bornDate = bornDate;
		this.phone = phone;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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
