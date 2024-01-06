package com.example.ticketbackend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "forum")
public class Forum {

	@Id
	@Column(name = "commodity_codename")
	private String commodityCodename;
	
	@Column(name = "commenter")
	private String commenter;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "comment_date")
	private LocalDate commentDate;

	public Forum() {
		super();
	}

	public Forum(String commodityCodename, String commenter, String comments, LocalDate commentDate) {
		super();
		this.commodityCodename = commodityCodename;
		this.commenter = commenter;
		this.comments = comments;
		this.commentDate = commentDate;
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

	public LocalDate getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDate commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
