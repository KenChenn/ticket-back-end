package com.example.ticketbackend.vo;

import java.time.LocalDateTime;

public class GetSeatDataVo {

	private int num;
	
	private String area;
	
	private int seatNum;
	
	private int price;
	
	private String buyNum;
	
	private int version;
		
	private String buyAccount;
	
	private LocalDateTime payFinalDate;
	
	private boolean payment;
	
	private LocalDateTime startSellDateTime;
	
	private LocalDateTime endSellDateTime;
	
	
	

	public GetSeatDataVo() {
		super();
		// TODO Auto-generated constructor stub
	}




	public GetSeatDataVo(int num, String area, int seatNum, int price, String buyNum, int version, String buyAccount,
			LocalDateTime payFinalDate, boolean payment, LocalDateTime startSellDateTime,
			LocalDateTime endSellDateTime) {
		super();
		this.num = num;
		this.area = area;
		this.seatNum = seatNum;
		this.price = price;
		this.buyNum = buyNum;
		this.version = version;
		this.buyAccount = buyAccount;
		this.payFinalDate = payFinalDate;
		this.payment = payment;
		this.startSellDateTime = startSellDateTime;
		this.endSellDateTime = endSellDateTime;
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




	public String getBuyNum() {
		return buyNum;
	}




	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}




	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}




	public String getBuyAccount() {
		return buyAccount;
	}




	public void setBuyAccount(String buyAccount) {
		this.buyAccount = buyAccount;
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




	public LocalDateTime getStartSellDateTime() {
		return startSellDateTime;
	}




	public void setStartSellDateTime(LocalDateTime startSellDateTime) {
		this.startSellDateTime = startSellDateTime;
	}




	public LocalDateTime getEndSellDateTime() {
		return endSellDateTime;
	}




	public void setEndSellDateTime(LocalDateTime endSellDateTime) {
		this.endSellDateTime = endSellDateTime;
	}



	
	

	
	
}
