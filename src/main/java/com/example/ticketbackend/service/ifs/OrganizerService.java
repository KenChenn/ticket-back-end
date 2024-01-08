package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.RtnCodeRes;

public interface OrganizerService {

	//新增主辦單位
	public RtnCodeRes addOrganizer(String name,String email, String phone,String address,String url,String sns);
	
	//編輯主辦單位
	public RtnCodeRes updateOrganizer(int id,String name,String email, String phone,String address,String url,String sns);

		
}
