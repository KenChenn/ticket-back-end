package com.example.ticketbackend.entity;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commodity")
public class Commodity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "codename")
	private String codename;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "introduction")
	private String introduction;

	@Column(name = "is_entity")
	private boolean entity;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "keyvisual_img")
	private String keyvisualImg;
	
	@Column(name = "introduce_img1")
	private String introduceImg1;
	
	@Column(name = "introduce_img2")
	private String introduceImg2;
	
	@Column(name = "organizer")
	private String organizer;

	public Commodity() {
		super();
	}
	
	

	public Commodity(int id, String codename, String name, String introduction, boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer) {
		super();
		this.id = id;
		this.codename = codename;
		this.name = name;
		this.introduction = introduction;
		this.entity = entity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.keyvisualImg = keyvisualImg;
		this.introduceImg1 = introduceImg1;
		this.introduceImg2 = introduceImg2;
		this.organizer = organizer;
	}


	public Commodity(String codename, String name, String introduction, boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer) {
		super();
		this.codename = codename;
		this.name = name;
		this.introduction = introduction;
		this.entity = entity;
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
