package com.example.ticketbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.entity.Tracking;
import com.example.ticketbackend.repository.TrackingDao;
import com.example.ticketbackend.service.ifs.TrackingService;
import com.example.ticketbackend.vo.TrackRes;

@SpringBootTest
public class TrackingServiceTest {

	@Autowired
	private TrackingDao trackingDao;
	
	@Autowired
	private TrackingService trackingService;
	
	@Test
	public void test() {
//		Tracking t = trackingDao.isTracking("Strng", "String");
		TrackRes s = trackingService.untrack("1235", "24_TES5T");
		System.out.println(s.getRtncode());
	}
}
