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
		UserLoginRes res = userService.login("A04", "123");
		System.out.println("RtnCode:"  + res.getRtncode());
	}
	
	@Test
	public void signUpTest() {
		UserLoginRes res = userService.signUp("A04", "123", "¤ý¤p©ú", "XiaoMin", "test@gmail.com",LocalDate.now(), "0912345678");
	}

}
