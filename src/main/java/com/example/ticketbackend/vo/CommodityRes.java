package com.example.ticketbackend.vo;

import java.time.LocalDate;

public class CommodityRes {

private String codename;
	
	private String name;
	
	private String introduction;
	
	private boolean entity;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String place;
	
	private String visionPicture_Base64;
	
	private String introducePicture1_Base64;
	
	private String introducePicture2_Base64;
	
	private String organizer;

	public CommodityRes() {
		super();
	}

	public CommodityRes(String codename, String name, String introduction, boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String visionPicture_Base64, String introducePicture1_Base64,
			String introducePicture2_Base64, String organizer) {
		super();
		this.codename = codename;
		this.name = name;
		this.introduction = introduction;
		this.entity = entity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.visionPicture_Base64 = visionPicture_Base64;
		this.introducePicture1_Base64 = introducePicture1_Base64;
		this.introducePicture2_Base64 = introducePicture2_Base64;
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

	public boolean isEntity() {
		return entity;
	}

	public void setEntity(boolean entity) {
		this.entity = entity;
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

	public String getVisionPicture_Base64() {
		return visionPicture_Base64;
	}

	public void setVisionPicture_Base64(String visionPicture_Base64) {
		this.visionPicture_Base64 = visionPicture_Base64;
	}

	public String getIntroducePicture1_Base64() {
		return introducePicture1_Base64;
	}

	public void setIntroducePicture1_Base64(String introducePicture1_Base64) {
		this.introducePicture1_Base64 = introducePicture1_Base64;
	}

	public String getIntroducePicture2_Base64() {
		return introducePicture2_Base64;
	}

	public void setIntroducePicture2_Base64(String introducePicture2_Base64) {
		this.introducePicture2_Base64 = introducePicture2_Base64;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	
}
