package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.RtnCodeRes;

public interface OrganizerService {

	//�s�W�D����
	public RtnCodeRes addOrganizer(String name,String email, String phone,String address,String url);
		
}