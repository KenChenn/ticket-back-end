package com.example.ticketbackend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buy")
public class Buy {
	
	@Id
	@Column(name="buy_num")
	private String buyNum;
	
	@Column(name="sessions_num")
	private int sessionsNum;
	
	@Column(name="buy_account")
	private String buyAccount;
	
	@Column(name="buy_date_time")
	private LocalDateTime buyDateTime;
	
	@Column(name="total_price")
	private int totalPrice;
	
	@Column(name="payfinal_date")
	private LocalDateTime payFinalDate;
	
	@Column(name="is_payment")
	private boolean payment;

	public Buy() {
		super();
	}

	public Buy(String buyNum, int sessionsNum, String buyAccount, LocalDateTime buyDateTime, int totalPrice,
			LocalDateTime payFinalDate) {
		super();
		this.buyNum = buyNum;
		this.sessionsNum = sessionsNum;
		this.buyAccount = buyAccount;
		this.buyDateTime = buyDateTime;
		this.totalPrice = totalPrice;
		this.payFinalDate = payFinalDate;
		this.payment = payment;
	}

	public String getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}

	public int getSessionsNum() {
		return sessionsNum;
	}

	public void setSessionsNum(int sessionsNum) {
		this.sessionsNum = sessionsNum;
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

	public LocalDateTime getPayFinalDate() {
		return payFinalDate;
	}

	public void setPayFinalDate(LocalDateTime payFinalDate) {
		this.payFinalDate = payFinalDate;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	
	
	
	

	
	
}
