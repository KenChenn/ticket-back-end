package com.example.ticketbackend.service.ifs;

import java.time.LocalDate;

import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.UserBasicDateRes;

public interface UserService {
	//使用者登入
	public RtnCodeRes login(String account, String pwd);
	//使用者註冊
	public RtnCodeRes signUp(String account, String pwd, String realname, String username, String email,
			LocalDate bornDate,String phone);
	//管理者登入
	public RtnCodeRes adminLogin(String account, String pwd);
	
	//使用者基本資料修改
	public RtnCodeRes userDataUpdate(String account,String username,String email,String phone);
	
	//獲取使用者基本資料
	public UserBasicDateRes userBasicDate(String account);
 
}
