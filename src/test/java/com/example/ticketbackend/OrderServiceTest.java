package com.example.ticketbackend;

import java.util.Iterator;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

	
	@Test
	public void uuidTest() {

		int num =15;
		for (int i =0; i<=100000000;i++) {
			UUID uuid = UUID.randomUUID();
			String uu = Long.toString(uuid.getMostSignificantBits());
			System.out.println(uu.substring(1, 10)  + RandomStringUtils.randomNumeric(3));
//			String str = uu.substring(0, 14);
//			String regEx="[^0-9]";
//			Pattern p = Pattern.compile(regEx);
//			Matcher m = p.matcher(str);
//			String mStr = m.replaceAll("").trim().toString();
//			System.out.println(num + mStr + RandomStringUtils.randomNumeric(12-mStr.length()));

		}
	}
}
