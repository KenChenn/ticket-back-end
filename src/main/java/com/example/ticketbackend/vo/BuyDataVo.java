package com.example.ticketbackend.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ticketbackend.entity.Seat;

public class BuyDataVo {
	
//	-----buy table-----
	
	private String buyNum;
	
	private int sessionsNum;
		
	private LocalDateTime payFinalDate;
	
	private boolean payment;
	
	
//	-----sessions table-----
	
	private String commodityCodename;
	
	private LocalDateTime showDateTime;
	
	private LocalDateTime endSellDateTime;
	
//	-----commodity table-----
	
	private String name;
	
	private String place;
	
	private String keyvisualImg;
	
	private List<Seat> seatData;

	public BuyDataVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public BuyDataVo(String buyNum, int sessionsNum, LocalDateTime payFinalDate, boolean payment,
			String commodityCodename, LocalDateTime showDateTime, LocalDateTime endSellDateTime, String name,
			String place, String keyvisualImg, List<Seat> seatData) {
		super();
		this.buyNum = buyNum;
		this.sessionsNum = sessionsNum;
		this.payFinalDate = payFinalDate;
		this.payment = payment;
		this.commodityCodename = commodityCodename;
		this.showDateTime = showDateTime;
		this.endSellDateTime = endSellDateTime;
		this.name = name;
		this.place = place;
		this.keyvisualImg = keyvisualImg;
		this.seatData = seatData;
	}



	public BuyDataVo(String buyNum, int sessionsNum, LocalDateTime payFinalDate, boolean payment,
			String commodityCodename, LocalDateTime showDateTime, LocalDateTime endSellDateTime, String name,
			String place, String keyvisualImg) {
		super();
		this.buyNum = buyNum;
		this.sessionsNum = sessionsNum;
		this.payFinalDate = payFinalDate;
		this.payment = payment;
		this.commodityCodename = commodityCodename;
		this.showDateTime = showDateTime;
		this.endSellDateTime = endSellDateTime;
		this.name = name;
		this.place = place;
		this.keyvisualImg = keyvisualImg;
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

	public String getCommodityCodename() {
		return commodityCodename;
	}

	public void setCommodityCodename(String commodityCodename) {
		this.commodityCodename = commodityCodename;
	}

	public LocalDateTime getShowDateTime() {
		return showDateTime;
	}

	public void setShowDateTime(LocalDateTime showDateTime) {
		this.showDateTime = showDateTime;
	}

	public LocalDateTime getEndSellDateTime() {
		return endSellDateTime;
	}

	public void setEndSellDateTime(LocalDateTime endSellDateTime) {
		this.endSellDateTime = endSellDateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getKeyvisualImg() {
		return keyvisualImg;
	}

	public void setKeyvisualImg(String keyvisualImg) {
		this.keyvisualImg = keyvisualImg;
	}

	public List<Seat> getSeatData() {
		return seatData;
	}

	public void setSeatData(List<Seat> seatData) {
		this.seatData = seatData;
	}

	

	
	
	

}
