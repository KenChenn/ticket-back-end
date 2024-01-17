package com.example.ticketbackend.vo;

import java.time.LocalDate;

public class GetTrackingList {

	private int id;
	
	private String tracker;
	
	private String commodityCodename;
	
	private String name;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String place;
	
	private String keyvisualImg;
	
	private String organizer;

	public GetTrackingList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetTrackingList(int id, String tracker, String commodityCodename, String name, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String organizer) {
		super();
		this.id = id;
		this.tracker = tracker;
		this.commodityCodename = commodityCodename;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.keyvisualImg = keyvisualImg;
		this.organizer = organizer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTracker() {
		return tracker;
	}

	public void setTracker(String tracker) {
		this.tracker = tracker;
	}

	public String getCommodityCodename() {
		return commodityCodename;
	}

	public void setCommodityCodename(String commodityCodename) {
		this.commodityCodename = commodityCodename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	

}
