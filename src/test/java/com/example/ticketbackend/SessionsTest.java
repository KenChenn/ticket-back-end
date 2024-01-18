package com.example.ticketbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.service.ifs.SessionsService;

@SpringBootTest
public class SessionsTest {

	@Autowired
	SessionsService sessionsService;
	
	@Test
	public void test() {
		
	}
}
