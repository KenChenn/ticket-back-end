package com.example.ticketbackend.controller;

import java.util.Map;

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
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.UserBasicDateRes;
import com.example.ticketbackend.vo.UserLoginReq;
import com.example.ticketbackend.vo.UserSignUpReq;

@CrossOrigin
@RestController
public class UserServiceController {

	@Autowired
	private UserService userService;

	// �ϥΪ̵n�J
	@PostMapping(value = "api/user_login")
	public RtnCodeRes login(@RequestBody UserLoginReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		// �P�_session�O�_�w�s�b�B�P�ШD���b���@�P
		if (StringUtils.hasText(attr) && attr.equals(req.getAccount())) {
			System.out.println(session.getAttribute("account") + "�b�����Ƶn�J");
			return new RtnCodeRes(RtnCode.SUCCESSFUL);
		}
		RtnCodeRes res = userService.login(req.getAccount(), req.getPwd());
		if (res.getRtncode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			// �Nsession���Įɶ��]�w��3600��A�Y1�p��
			session.setMaxInactiveInterval(3600);
			System.out.println(session.getAttribute("account") + "�n�J�F");
		}
		return res;

	}

	// �n�X
	@GetMapping(value = "api/logout")
	public RtnCodeRes logout(HttpSession session) {
		System.out.println(session.getAttribute("account") + "�n�X�F");
		// ��session����
		session.invalidate();
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	// �ϥΪ̵��U
	@PostMapping(value = "api/user_signup")
	public RtnCodeRes signUp(@RequestBody UserSignUpReq req) {
		RtnCodeRes res = userService.signUp(req.getAccount(), req.getPwd(), req.getRealname(), req.getUsername(),
				req.getEmail(), req.getBornDate(), req.getPhone());
		return res;
	}

	// �ϥΪ̭ӤH��T�ק�
	@PostMapping(value = "api/user_data_update")
	public RtnCodeRes userDataUpdate(@RequestBody UserSignUpReq req) {
		RtnCodeRes res = userService.userDataUpdate(req.getAccount(), req.getUsername(), req.getEmail(),
				req.getPhone());
		return res;
	}

	// �ϥΪ̱K�X�ק�
	@PostMapping(value = "api/user_pwd_change")
	public RtnCodeRes userPwdChange(@RequestBody Map<String, String> data) {
		if (data.get("account") == null || data.get("oldPwd") == null || data.get("newPwd") == null) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		RtnCodeRes res = userService.userPwdChange(data.get("account"), data.get("oldPwd"), data.get("newPwd"));
		return res;
	}

	// ����ϥΪ̰򥻸��
	@PostMapping(value = "api/get_user_basic_data")
	public UserBasicDateRes userBasicData(@RequestBody UserSignUpReq req) {
		UserBasicDateRes res = userService.userBasicData(req.getAccount());
		return res;
	}

	// �޲z�̵n�J
	@PostMapping(value = "admin/login")
	public RtnCodeRes adminLogin(@RequestBody UserLoginReq req, HttpSession session) {
		String attr = (String) session.getAttribute("account");
		// �P�_session�O�_�w�s�b�B�P�ШD���b���@�P
		if (StringUtils.hasText(attr) && attr.equals(req.getAccount())) {
			System.out.println(session.getAttribute("account") + "�b�����Ƶn�J");
			return new RtnCodeRes(RtnCode.SUCCESSFUL);
		}
		RtnCodeRes res = userService.adminLogin(req.getAccount(), req.getPwd());
		if (res.getRtncode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			// �Nsession���Įɶ��]�w��3600��A�Y1�p��
			session.setMaxInactiveInterval(3600);
			System.out.println(session.getAttribute("account") + "�n�J�F");
		}
		return res;
	}
}
