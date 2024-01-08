package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.GetOrganizerDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface OrganizerService {

	// �s�W�D����
	public RtnCodeRes addOrganizer(String name, String email, String phone, String address, String url, String sns);

	// �s��D����
	public RtnCodeRes updateOrganizer(int id, String name, String email, String phone, String address, String url,
			String sns);

	// �R���D����
	public RtnCodeRes deleteOrganizer(int id);

	// ����Ҧ��D������
	public GetOrganizerDataRes getOrganizerData();

}
