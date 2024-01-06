package com.example.ticketbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
@IdClass(value = Seat.class)
public class Seat {

	@Id
	@Column(name = "num")
	private int num;

	@Id
	@Column(name = "area")
	private String area;

	@Id
	@Column(name = "seat_num")
	private int seatNum;

	@Column(name = "price")
	private int price;

	@Column(name = "order_num")
	private int orderNum;

	public Seat() {
		super();
	}

	public Seat(int num, String area, int seatNum, int price, int orderNum) {
		super();
		this.num = num;
		this.area = area;
		this.seatNum = seatNum;
		this.price = price;
		this.orderNum = orderNum;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

}
