package com.example.ticketbackend.service.ifs;

import java.time.LocalDate;

import com.example.ticketbackend.vo.UserLoginRes;

public interface UserService {
	//�ϥΪ̵n�J
	public UserLoginRes login(String account, String pwd);
	//�ϥΪ̵��U
	public UserLoginRes signUp(String account, String pwd, String realname, String username, String email,
			LocalDate bornDate,String phone);

}
