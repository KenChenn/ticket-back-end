package com.example.ticketbackend.vo;

public class UpdateOrganizerReq extends AddOrganizerReq{

	private int id;

	public UpdateOrganizerReq() {
		super();
	}

	public UpdateOrganizerReq(int id,String name, String email, String phone, String address, String url, String sns) {
		super(name, email, phone, address, url, sns);
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	
}
