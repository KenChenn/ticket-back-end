package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Forum;

public class GetComments extends RtnCodeRes{
	
	private List<Forum> forumData;

	public GetComments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetComments(RtnCode rtncode,List<Forum> forumData) {
		super(rtncode);
		this.forumData = forumData;
	}

	public List<Forum> getForumData() {
		return forumData;
	}

	public void setForumData(List<Forum> forumData) {
		this.forumData = forumData;
	}


	
	

}
