package com.example.ticketbackend.vo;

import java.time.LocalDate;
import java.util.List;

public class AddCommodityReq {

	private String codeName;
	
	private String name;
	
	private String introduction;
	
	private boolean entity;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String place;
	
	private String keyvisual_img;
	
	private String introduce_img1;
	
	private String introduce_img2;
	
	private String organizer;
	
	private List<SessionReq> SessionData;

	public AddCommodityReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCommodityReq(String codeName, String name, String introduction, boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisual_img, String introduce_img1, String introduce_img2,
			String organizer, List<SessionReq> sessionData) {
		super();
		this.codeName = codeName;
		this.name = name;
		this.introduction = introduction;
		this.entity = entity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.keyvisual_img = keyvisual_img;
		this.introduce_img1 = introduce_img1;
		this.introduce_img2 = introduce_img2;
		this.organizer = organizer;
		SessionData = sessionData;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
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

	public String getKeyvisual_img() {
		return keyvisual_img;
	}

	public void setKeyvisual_img(String keyvisual_img) {
		this.keyvisual_img = keyvisual_img;
	}

	public String getIntroduce_img1() {
		return introduce_img1;
	}

	public void setIntroduce_img1(String introduce_img1) {
		this.introduce_img1 = introduce_img1;
	}

	public String getIntroduce_img2() {
		return introduce_img2;
	}

	public void setIntroduce_img2(String introduce_img2) {
		this.introduce_img2 = introduce_img2;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public List<SessionReq> getSessionData() {
		return SessionData;
	}

	public void setSessionData(List<SessionReq> sessionData) {
		SessionData = sessionData;
	}

	
	
	
}
