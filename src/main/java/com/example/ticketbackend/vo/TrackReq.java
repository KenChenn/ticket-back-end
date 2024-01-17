package com.example.ticketbackend.vo;

public class TrackReq {

	private String tracker;
	
	private String commodityCodename;

	public TrackReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrackReq(String tracker, String commodityCodename) {
		super();
		this.tracker = tracker;
		this.commodityCodename = commodityCodename;
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
	
	
	
}
