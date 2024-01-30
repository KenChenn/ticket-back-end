package com.example.ticketbackend;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.entity.Sessions;
import com.example.ticketbackend.repository.SessionsDao;
import com.example.ticketbackend.service.ifs.SessionsService;

@SpringBootTest
public class SessionsTest {

	@Autowired
	SessionsService sessionsService;
	@Autowired
	SessionsDao sessionsDao;
	
	@Test
	public void test() {
		List<Sessions> sessionsDataInDb = sessionsDao.findByCommodityCodenameOrderByShowDateTime("hololive_4th_fanchant_taipei");
		Map<Integer, Sessions> sessionsMap = sessionsDataInDb.stream().collect(Collectors.toMap(Sessions::getNum, Function.identity()));
	}
}
