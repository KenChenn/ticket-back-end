package com.example.ticketbackend.entity;

import java.io.Serializable;

@SuppressWarnings("serial") //©¿²¤serial
public class SeatId implements Serializable{
	
	private int num;
	private String area;
	private int seatNum;
	
	public SeatId() {
		super();
	}

	public SeatId(int num, String area, int seatNum) {
		super();
		this.num = num;
		this.area = area;
		this.seatNum = seatNum;
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

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	
}
