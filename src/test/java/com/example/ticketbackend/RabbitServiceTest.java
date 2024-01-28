package com.example.ticketbackend;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.service.ifs.RabbitmqService;

@SpringBootTest
public class RabbitServiceTest {

	
	@Autowired
	private RabbitmqService rabbitmaService;
	@Autowired
	private RabbitAdmin rabbitAdmin;
	
	@Test
	public void getAllQueueTest() {
		rabbitmaService.getAllQueue();
	}
	@Test
	public void getAllTypeExchangeTest() {
		rabbitmaService.getAllTypeExchange();
	}
	@Test
	public void getAllQueueByExchangeTest() {
		rabbitmaService.getAllQueueByExchange("commodityType.日本");
	}
	@Test
	public void sendMsg() {
		rabbitmaService.sendMsg("commodityType.韓國","您訂閱XXX訊息");
	}
	
	
	
}
