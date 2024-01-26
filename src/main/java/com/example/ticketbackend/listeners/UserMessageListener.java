package com.example.ticketbackend.listeners;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserMessageListener {

	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.�饻")) //��ť���C�A�p�G�Ӷ��C���s�b���ܴN�إ�
    public void sendMessage(String message) {
        // �B�z�����쪺����
        System.out.println("Received message: " + message);
    }
	
}
