package com.example.ticketbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.service.ifs.OrganizerService;
import com.example.ticketbackend.vo.RtnCodeRes;


@SpringBootTest
public class OrganizerServiceTests {

	@Autowired
	private OrganizerService organizerService;
	
	@Test
	public void addOrganizer() {
		RtnCodeRes res = organizerService.addOrganizer("API11211", "test", "0800123123", null,null,null);
		System.out.println(res.getRtncode());
	}
	
	
	@Test
	public void updateOrganizer() {
		RtnCodeRes res = organizerService.updateOrganizer(13, "´ú¸Õ§ó·s", "update@test.com", "0800-111-222", null, null, null);
		System.out.println(res.getRtncode());

	}
}
