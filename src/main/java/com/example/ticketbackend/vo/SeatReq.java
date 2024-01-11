package com.example.ticketbackend.vo;

import javax.persistence.Column;
import javax.persistence.Id;

public class SeatReq {

	
	private int num;
	
	private String area;
	
	private int maxSeatNum;
	
	private int price;

	public SeatReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeatReq(int num, String area, int maxSeatNum, int price) {
		super();
		this.num = num;
		this.area = area;
		this.maxSeatNum = maxSeatNum;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getMaxSeatNum() {
		return maxSeatNum;
	}

	public void setMaxSeatNum(int maxSeatNum) {
		this.maxSeatNum = maxSeatNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	


	
	
}
