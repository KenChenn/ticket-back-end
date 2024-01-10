package com.example.ticketbackend.vo;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Column;

public class CommodityReq {

	
	private String codename;
	
	private String name;
	
	private String introduction;
	
	private boolean enity;
	
	private LocalDate startDate;
	
	private LocalDate endDate;

	private String place;

	private String keyvisualImg;
	
	private String introduceImg1;
	
	private String introduceImg2;

	private String organizer;

	public CommodityReq() {
		super();
	}

	public CommodityReq(String codename, String name, String introduction, boolean enity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer) {
		super();
		this.codename = codename;
		this.name = name;
		this.introduction = introduction;
		this.enity = enity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.keyvisualImg = keyvisualImg;
		this.introduceImg1 = introduceImg1;
		this.introduceImg2 = introduceImg2;
		this.organizer = organizer;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean isEnity() {
		return enity;
	}

	public void setEnity(boolean enity) {
		this.enity = enity;
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

	public String getIntroduceImg1() {
		return introduceImg1;
	}

	public void setIntroduceImg1(String introduceImg1) {
		this.introduceImg1 = introduceImg1;
	}

	public String getIntroduceImg2() {
		return introduceImg2;
	}

	public void setIntroduceImg2(String introduceImg2) {
		this.introduceImg2 = introduceImg2;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	
	

	
	
}
