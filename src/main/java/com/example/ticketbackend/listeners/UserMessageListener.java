package com.example.ticketbackend.listeners;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ticketbackend.repository.SubscriptionDao;
import com.example.ticketbackend.service.ifs.MailService;

@Component
public class UserMessageListener {

	@Autowired
	SubscriptionDao subscriptiondao;
	@Autowired
	MailService mailService;
	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.日本")) //監聽隊列，如果該隊列不存在的話就建立
    public void listenJapan(String message) {
		String str = "日本";
		String[] mailArray = subscriptiondao.getSubscriberEmails(str);
		mailService.subscribeMail(mailArray, message);
    }
	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.韓國")) //監聽隊列，如果該隊列不存在的話就建立
    public void listenKorea(String message) {
		String str = "韓國";
		String[] mailArray = subscriptiondao.getSubscriberEmails(str);
		mailService.subscribeMail(mailArray, message);
    }
	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.台灣")) //監聽隊列，如果該隊列不存在的話就建立
    public void listenTaiwan(String message) {
		String str = "台灣";
		String[] mailArray = subscriptiondao.getSubscriberEmails(str);
		mailService.subscribeMail(mailArray, message);
    }
	
	
	
}
