package com.example.ticketbackend.vo;

import java.time.LocalDateTime;

public class GetSessionsDateVo2 {

	private int num;
	
	private String commodityCodename;
	
	private LocalDateTime showDateTime;
	
	private LocalDateTime startSellDateTime;

	private LocalDateTime endSellDateTime;

	private String area;
	
	private int remainingTicket;
	
	private int price;

	public GetSessionsDateVo2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetSessionsDateVo2(int num, String commodityCodename, LocalDateTime showDateTime,
			LocalDateTime startSellDateTime, LocalDateTime endSellDateTime, String area, int remainingTicket,
			int price) {
		super();
		this.num = num;
		this.commodityCodename = commodityCodename;
		this.showDateTime = showDateTime;
		this.startSellDateTime = startSellDateTime;
		this.endSellDateTime = endSellDateTime;
		this.area = area;
		this.remainingTicket = remainingTicket;
		this.price = price;
	}

	public GetSessionsDateVo2(int num, String commodityCodename, LocalDateTime showDateTime,
			LocalDateTime startSellDateTime, LocalDateTime endSellDateTime, String area, Long remainingTicket,
			int price) {
		super();
		this.num = num;
		this.commodityCodename = commodityCodename;
		this.showDateTime = showDateTime;
		this.startSellDateTime = startSellDateTime;
		this.endSellDateTime = endSellDateTime;
		this.area = area;
		this.remainingTicket = remainingTicket.intValue();
		this.price = price;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRemainingTicket() {
		return remainingTicket;
	}

	public void setRemainingTicket(int remainingTicket) {
		this.remainingTicket = remainingTicket;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
