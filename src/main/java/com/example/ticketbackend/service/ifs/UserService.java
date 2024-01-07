package com.example.ticketbackend.service.ifs;

import java.time.LocalDate;

import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.UserBasicDateRes;

public interface UserService {
	//�ϥΪ̵n�J
	public RtnCodeRes login(String account, String pwd);
	//�ϥΪ̵��U
	public RtnCodeRes signUp(String account, String pwd, String realname, String username, String email,
			LocalDate bornDate,String phone);
	//�޲z�̵n�J
	public RtnCodeRes adminLogin(String account, String pwd);
	
	//�ϥΪ̰򥻸�ƭק�
	public RtnCodeRes userDataUpdate(String account,String username,String email,String phone);
	
	//����ϥΪ̰򥻸��
	public UserBasicDateRes userBasicDate(String account);
 
}
