package com.example.ticketbackend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.repository.SubscriptionDao;
import com.example.ticketbackend.service.ifs.SubscriptionService;
import com.example.ticketbackend.vo.RtnCodeRes;

@SpringBootTest
public class SubscriptionTest {

	@Autowired
	SubscriptionDao subscriptionDao;
	@Autowired
	SubscriptionService subscriptionService;
	
	@Test
	public void test() {
		boolean s =subscriptionDao.existsByAccountAndSubscribe("A01", "韓國");
		System.out.println(s);
		
	}
	
	@Test
	public void test1() {
		String[] s = subscriptionDao.getSubscriberEmails("日本");
		System.out.println(s[1]);
		
	}
	
	@Test
	public void test2() {
		RtnCodeRes s = subscriptionService.subscribe("A01", "韓國");
		System.out.println(s.getRtncode());
	}
}
