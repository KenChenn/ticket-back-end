package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.UserService;
import com.example.ticketbackend.vo.UserLoginReq;
import com.example.ticketbackend.vo.UserLoginRes;
import com.example.ticketbackend.vo.UserSignUpReq;

@CrossOrigin
@RestController
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "api/user_login")
	public UserLoginRes login(@RequestBody UserLoginReq req, HttpSession session) {
		String attr = (String)session.getAttribute("account");
		//�P�_session�O�_�w�s�b�B�P�ШD���b���@�P
		if(StringUtils.hasText(attr) && attr.equals(req.getAccount())) {
			System.out.println(session.getAttribute("account") + "�b�����Ƶn�J");
			return new UserLoginRes(RtnCode.SUCCESSFUL);
		}
		UserLoginRes res = userService.login(req.getAccount(),req.getPwd());
		if(res.getRtncode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			//�Nsession���Įɶ��]�w��3600��A�Y1�p��
			session.setMaxInactiveInterval(3600);
			System.out.println(session.getAttribute("account") + "�n�J�F");
		}
		return res;
		
	}
	
	@GetMapping(value = "api/logout")
	public UserLoginRes logout(HttpSession session) {
		System.out.println(session.getAttribute("account") + "�n�X�F");
		//��session����
		session.invalidate();
		return new UserLoginRes(RtnCode.SUCCESSFUL);
	}
	
	@PostMapping(value = "api/user_signup")
	public UserLoginRes signUp(@RequestBody UserSignUpReq req) {
		UserLoginRes res = userService.signUp(req.getAccount(), req.getPwd(), req.getRealname(), req.getUsername(), req.getEmail(), req.getBornDate(), req.getPhone());
		return res;
	}
	
	@PostMapping(value = "admin/login")
	public UserLoginRes adminLogin(@RequestBody UserLoginReq req, HttpSession session) {
		String attr = (String)session.getAttribute("account");
		//�P�_session�O�_�w�s�b�B�P�ШD���b���@�P
		if(StringUtils.hasText(attr) && attr.equals(req.getAccount())) {
			System.out.println(session.getAttribute("account") + "�b�����Ƶn�J");
			return new UserLoginRes(RtnCode.SUCCESSFUL);
		}
		UserLoginRes res = userService.adminLogin(req.getAccount(), req.getPwd());
		if(res.getRtncode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			//�Nsession���Įɶ��]�w��3600��A�Y1�p��
			session.setMaxInactiveInterval(3600);
			System.out.println(session.getAttribute("account") + "�n�J�F");
		}
		return res;
	}
}
