package com.example.ticketbackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "forum")
public class Forum {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "commodity_codename")
	private String commodityCodename;
	
	@Column(name = "commenter")
	private String commenter;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "comment_datetime")
	private LocalDateTime commentDateTime;

	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forum(int id, String commodityCodename, String commenter, String comments, LocalDateTime commentDateTime) {
		super();
		this.id = id;
		this.commodityCodename = commodityCodename;
		this.commenter = commenter;
		this.comments = comments;
		this.commentDateTime = commentDateTime;
	}
	
	public Forum(String commodityCodename, String commenter, String comments, LocalDateTime commentDateTime) {
		super();
		this.commodityCodename = commodityCodename;
		this.commenter = commenter;
		this.comments = comments;
		this.commentDateTime = commentDateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommodityCodename() {
		return commodityCodename;
	}

	public void setCommodityCodename(String commodityCodename) {
		this.commodityCodename = commodityCodename;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDateTime getCommentDateTime() {
		return commentDateTime;
	}

	public void setCommentDateTime(LocalDateTime commentDateTime) {
		this.commentDateTime = commentDateTime;
	}

	

	

	
	
	
}
