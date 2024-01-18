package com.example.ticketbackend.vo;

import java.time.LocalDateTime;

public class GetCommodityAndSessionsVo {

	private int id;
	
	private String codeName;
	
	private int num;
	
	private LocalDateTime showDateTime;
	
	private LocalDateTime startSellDatetime;
	
	private LocalDateTime endSellDatetime;

	public GetCommodityAndSessionsVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetCommodityAndSessionsVo(int id, String codeName, int num, LocalDateTime showDateTime,
			LocalDateTime startSellDatetime, LocalDateTime endSellDatetime) {
		super();
		this.id = id;
		this.codeName = codeName;
		this.num = num;
		this.showDateTime = showDateTime;
		this.startSellDatetime = startSellDatetime;
		this.endSellDatetime = endSellDatetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public LocalDateTime getShowDateTime() {
		return showDateTime;
	}

	public void setShowDateTime(LocalDateTime showDateTime) {
		this.showDateTime = showDateTime;
	}

	public LocalDateTime getStartSellDatetime() {
		return startSellDatetime;
	}

	public void setStartSellDatetime(LocalDateTime startSellDatetime) {
		this.startSellDatetime = startSellDatetime;
	}

	public LocalDateTime getEndSellDatetime() {
		return endSellDatetime;
	}

	public void setEndSellDatetime(LocalDateTime endSellDatetime) {
		this.endSellDatetime = endSellDatetime;
	}

	
	
}
