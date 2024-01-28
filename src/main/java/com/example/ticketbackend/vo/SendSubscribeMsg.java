package com.example.ticketbackend.vo;

public class SendSubscribeMsg {

	private String subscribe;
	
	private String message;

	public SendSubscribeMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendSubscribeMsg(String subscribe, String message) {
		super();
		this.subscribe = subscribe;
		this.message = message;
	}

	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
