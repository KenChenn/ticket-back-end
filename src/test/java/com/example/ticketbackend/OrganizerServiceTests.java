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
		RtnCodeRes res = organizerService.addOrganizer("API12", "test", "0800123123", "高雄三民區", "google.com");
		System.out.println(res.getRtncode());
	}
}
