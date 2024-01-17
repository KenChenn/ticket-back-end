package com.example.ticketbackend.vo;

public class ForumReq {
	
	private int id;
	
	private String  codename;
	
	private String comments;

	public ForumReq() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ForumReq(int id, String codename, String comments) {
		super();
		this.id = id;
		this.codename = codename;
		this.comments = comments;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

	

	

	
}
