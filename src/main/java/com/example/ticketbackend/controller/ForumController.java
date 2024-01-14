package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.ForumService;
import com.example.ticketbackend.vo.ForumReq;
import com.example.ticketbackend.vo.RtnCodeRes;

@CrossOrigin
@RestController
public class ForumController {
	
	@Autowired 
	private ForumService forumService;

	@PostMapping(value = "api/comment")
	public RtnCodeRes comment(@RequestBody ForumReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_FIRST);
		}
		forumService.comment(attr, req.getCodename(), req.getComments());
		return new RtnCodeRes(RtnCode.SUCCESSFUL);	
		}
	
	@PostMapping(value = "api/delete_comment")
	public RtnCodeRes deleteComment(@RequestBody ForumReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		if (!StringUtils.hasText(attr)) {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_FIRST);
		}
		RtnCodeRes res = forumService.deleteComment(req.getId(),attr);
		return res;	
		}
	
	@PostMapping(value = "api/get_comments")
	public RtnCodeRes getComments(@RequestBody ForumReq req) {
		RtnCodeRes res = forumService.getComments(req.getCodename());
		return res;	
		}

}
