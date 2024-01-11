package com.example.ticketbackend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column(name="order_num")
	private int orderNum;
	
	@Column(name="commodity_num")
	private int commodityNum;
	
	@Column(name="buy_account")
	private String buyAccount;
	
	@Column(name="buy_date_time")
	private LocalDateTime buyDateTime;
	
	@Column(name="total_price")
	private int totalPrice;
	
	@Column(name="payfinal_date")
	private LocalDate payFinalDate;
	
	@Column(name="is_payment")
	private boolean payment;

	public Order() {
		super();
	}

	public Order(int orderNum, int commodityNum, String buyAccount, LocalDateTime buyDateTime, int totalPrice,
			LocalDate payFinalDate, boolean payment) {
		super();
		this.orderNum = orderNum;
		this.commodityNum = commodityNum;
		this.buyAccount = buyAccount;
		this.buyDateTime = buyDateTime;
		this.totalPrice = totalPrice;
		this.payFinalDate = payFinalDate;
		this.payment = payment;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getCommodityNum() {
		return commodityNum;
	}

	public void setCommodityNum(int commodityNum) {
		this.commodityNum = commodityNum;
	}

	public String getBuyAccount() {
		return buyAccount;
	}

	public void setBuyAccount(String buyAccount) {
		this.buyAccount = buyAccount;
	}

	public LocalDateTime getBuyDateTime() {
		return buyDateTime;
	}

	public void setBuyDateTime(LocalDateTime buyDateTime) {
		this.buyDateTime = buyDateTime;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getPayFinalDate() {
		return payFinalDate;
	}

	public void setPayFinalDate(LocalDate payFinalDate) {
		this.payFinalDate = payFinalDate;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	
	

	
	
}
