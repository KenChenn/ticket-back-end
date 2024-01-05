package com.example.ticketbackend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@:annotation
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "realname")
	private String realname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "born_date")
	private LocalDate bornDate;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "creditcard_number")
	private String creditcardNumber;
	
	@Column(name = "is_admin")
	private boolean admin;

	public User() {
		super();
	}

	public User(String account, String pwd, String realname, String username, String email, LocalDate bornDate,
			String phone, String creditcardNumber, boolean admin) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.realname = realname;
		this.username = username;
		this.email = email;
		this.bornDate = bornDate;
		this.phone = phone;
		this.creditcardNumber = creditcardNumber;
		this.admin = admin;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	
}
