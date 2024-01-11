package com.example.ticketbackend.vo;

public class AddOrganizerReq {

	private String name;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String url;

	private String sns;

	public AddOrganizerReq() {
		super();
	}

	public AddOrganizerReq(String name, String email, String phone, String address, String url, String sns) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.url = url;
		this.sns = sns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}


	
	
	
} 
