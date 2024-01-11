package com.example.ticketbackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sessions")
public class Sessions {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "num")
	private int num;
	
	@Column(name = "commodity_codename")
	private String commodityCodename;
	
	@Column(name = "show_datetime")
	private LocalDateTime showDateTime;
	
	
	@Column(name = "start_sell_datetime")
	private LocalDateTime startSellDateTime;
	
	@Column(name = "end_sell_datetime")
	private LocalDateTime endSellDateTime;

	public Sessions() {
		super();
	}

	public Sessions(int num, String commodityCodename, LocalDateTime showDateTime, LocalDateTime startSellDateTime,
			LocalDateTime endSellDateTime) {
		super();
		this.num = num;
		this.commodityCodename = commodityCodename;
		this.showDateTime = showDateTime;
		this.startSellDateTime = startSellDateTime;
		this.endSellDateTime = endSellDateTime;
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

	
	
	
	
	
}
