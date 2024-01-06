package com.example.ticketbackend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sessions")
public class Sessions {

	@Id
	@Column(name = "num")
	private int num;
	
	@Column(name = "commodity_codename")
	private String commodityCodename;
	
	@Column(name = "show_date")
	private LocalDate showDate;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "start_selldate")
	private LocalDate startSelldate;
	
	@Column(name = "end_selldate")
	private LocalDate endSelldate;

	public Sessions() {
		super();
	}

	public Sessions(int num, String commodityCodename, LocalDate showDate, String place, LocalDate startSelldate,
			LocalDate endSelldate) {
		super();
		this.num = num;
		this.commodityCodename = commodityCodename;
		this.showDate = showDate;
		this.place = place;
		this.startSelldate = startSelldate;
		this.endSelldate = endSelldate;
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

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getStartSelldate() {
		return startSelldate;
	}

	public void setStartSelldate(LocalDate startSelldate) {
		this.startSelldate = startSelldate;
	}

	public LocalDate getEndSelldate() {
		return endSelldate;
	}

	public void setEndSelldate(LocalDate endSelldate) {
		this.endSelldate = endSelldate;
	}
	
	
	
}
