package com.example.ticketbackend.entity;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commodity")
public class Commodity {

	@Id
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
	
	@Column(name = "image")
	private Blob image;
	
	@Column(name = "organizer")
	private String organizer;

	public Commodity() {
		super();
	}

	public Commodity(String codename, String name, String introduction, boolean entity, LocalDate startDate,
			LocalDate endDate, Blob image, String organizer) {
		super();
		this.codename = codename;
		this.name = name;
		this.introduction = introduction;
		this.entity = entity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.image = image;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	
	
}
