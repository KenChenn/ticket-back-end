package com.example.ticketbackend;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.service.ifs.UserService;
import com.example.ticketbackend.vo.UserLoginRes;

@SpringBootTest
public class UserServiveTests {

	@Autowired
	private UserService userService;

	@Test
	public void loginTest() {
		UserLoginRes res = userService.login("A04", "1223");
		System.out.println("RtnCode:"  + res.getRtncode());
	}
	
	@Test
	public void signUpTest() {
		UserLoginRes a = userService.signUp("A05", "123", "王小明", "XiaoMin", "test@gmail.com",null, "0912345678");
		System.out.println("少了出生日參數:" + a.getRtncode());
	}
	
	@Test
	public void adminTest() {
		UserLoginRes s = userService.adminLogin("admin", "admin");
		System.out.println(s.getRtncode());
	}

}
