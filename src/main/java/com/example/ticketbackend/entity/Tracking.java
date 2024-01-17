package com.example.ticketbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracking")
public class Tracking {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "tracker")
	private String tracker;
	
	@Column(name = "commodity_codename")
	private String commodityCodename;

	public Tracking() {
		super();
	}

	public Tracking(int id, String tracker, String commodityCodename) {
		super();
		this.id = id;
		this.tracker = tracker;
		this.commodityCodename = commodityCodename;
	}
	
	public Tracking(String tracker, String commodityCodename) {
		super();
		this.tracker = tracker;
		this.commodityCodename = commodityCodename;
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
	
	
	

}
