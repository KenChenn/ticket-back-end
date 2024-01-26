package com.example.ticketbackend.listeners;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserMessageListener {

	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.日本")) //監聽隊列，如果該隊列不存在的話就建立
    public void sendMessage(String message) {
        // 處理接收到的消息
        System.out.println("Received message: " + message);
    }
	
}
