package com.example.ticketbackend.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.ticketbackend.service.ifs.MailService;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;

//	@Override
//	public void sendMail(Collection<String> receivers, String subject, String content) {
//		if(receivers.size()<=0) {
//			
//		}
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(receivers.toArray(new String[0]));
//		message.setSubject(subject);
//		message.setText(content);
//		mailSender.send(message);
//	}

	@Override
	public void singUpMail(String receivers, String username) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(receivers);
		message.setSubject("註冊成功");
		message.setText(username +"會員，您好:\n"
				+ "歡迎註冊使用樂狗購票網");
		mailSender.send(message);
		
	}


	
	
	
}
