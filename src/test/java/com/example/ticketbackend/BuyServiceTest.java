package com.example.ticketbackend;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.service.ifs.BuyService;

@SpringBootTest
public class BuyServiceTest {

	@Autowired BuyService buyService;
	
	@Autowired SeatDao seatDao;
	
	@Test
	public void uuidTest() {

		int num =15;
		for (int i =0; i<=100000000;i++) {
			UUID uuid = UUID.randomUUID();
			String uu = Long.toString(uuid.getMostSignificantBits()).substring(1, 10)+ RandomStringUtils.randomNumeric(3);
			System.out.println(uu.substring(1, 10)  + RandomStringUtils.randomNumeric(3));
//			String str = uu.substring(0, 14);
//			String regEx="[^0-9]";
//			Pattern p = Pattern.compile(regEx);
//			Matcher m = p.matcher(str);
//			String mStr = m.replaceAll("").trim().toString();
//			System.out.println(num + mStr + RandomStringUtils.randomNumeric(12-mStr.length()));

		}
	}
	
	@Test
	public void getTickets() {
		buyService.buy(18, "A05", "1F", 4);
//		Seat test = new Seat();
//		test.setNum(18);
//		test.setArea("1F");
//		test.setNum(18);
//		test.setPrice(3500);
//		try {
//			seatDao.save(test);
//
//		} catch (Exception e) {
//			System.out.println("³QÂê©w¤F");
//		}
	}
}
