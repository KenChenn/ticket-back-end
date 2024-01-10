package com.example.ticketbackend;

import java.sql.Blob;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.service.ifs.CommodityService;

@SpringBootTest
public class CommodityServiceTest {

	@Autowired
	private CommodityService commodityService;
	
	@Test
	public void blobTest() {
//		String a = "Hello";
//		String test = Base64.getEncoder().encodeToString(a.getBytes());
//		
//		Blob s = null;
//		String a = s.toString();
//		System.out.println();
	}
}
