package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.RtnCodeRes;

public interface ForumService {

	public RtnCodeRes comment(String commodityCodename,String commenter,String comments); 
	
	public RtnCodeRes deleteComment(int id,String commenter); 

	public RtnCodeRes getComments(String commodityCodename); 
}
