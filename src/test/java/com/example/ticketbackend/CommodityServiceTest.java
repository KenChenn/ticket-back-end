package com.example.ticketbackend;

import java.sql.Blob;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.repository.CommodityDao;
import com.example.ticketbackend.service.ifs.CommodityService;
import com.example.ticketbackend.vo.GetCommodityAndSessionsVo;

@SpringBootTest
public class CommodityServiceTest {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Test
	public void test() {
		List<GetCommodityAndSessionsVo> s = commodityDao.getCommodityAndSessions("24_YOASOBI");
//		System.out.println(s.size());
		for (int i = 0 ; i<s.size();i++) {
			System.out.println(s.get(i).getNum());
		}
	}
}
