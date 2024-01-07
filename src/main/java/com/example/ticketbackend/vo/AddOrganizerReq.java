package com.example.ticketbackend.vo;

public class AddOrganizerReq {

	private String name;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String url;

	public AddOrganizerReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public AddOrganizerReq(String name, String email, String phone, String address, String url) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.url = url;
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
	
	
} 