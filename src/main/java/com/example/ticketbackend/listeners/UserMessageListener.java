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
	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.�饻")) //��ť���C�A�p�G�Ӷ��C���s�b���ܴN�إ�
    public void listenJapan(String message) {
		String str = "�饻";
		String[] mailArray = subscriptiondao.getSubscriberEmails(str);
		mailService.subscribeMail(mailArray, message);
    }
	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.����")) //��ť���C�A�p�G�Ӷ��C���s�b���ܴN�إ�
    public void listenKorea(String message) {
		String str = "����";
		String[] mailArray = subscriptiondao.getSubscriberEmails(str);
		mailService.subscribeMail(mailArray, message);
    }
	
	@RabbitListener(queuesToDeclare = @Queue(name = "commodityType.�x�W")) //��ť���C�A�p�G�Ӷ��C���s�b���ܴN�إ�
    public void listenTaiwan(String message) {
		String str = "�x�W";
		String[] mailArray = subscriptiondao.getSubscriberEmails(str);
		mailService.subscribeMail(mailArray, message);
    }
	
	
	
}
