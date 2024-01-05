package com.example.ticketbackend.service.ifs;

import java.time.LocalDate;

import com.example.ticketbackend.vo.UserLoginRes;

public interface UserService {
	//使用者登入
	public UserLoginRes login(String account, String pwd);
	//使用者註冊
	public UserLoginRes signUp(String account, String pwd, String realname, String username, String email,
			LocalDate bornDate,String phone);

}
