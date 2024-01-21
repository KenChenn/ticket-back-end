package com.example.ticketbackend.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
		String mailAddress = System.getProperty("SMTP_USERNAME");
		String mailName = "樂狗購票網<" + mailAddress + ">";
		message.setFrom(mailName);
		message.setTo(receivers);
		message.setSubject("註冊成功");
		message.setText(username +"會員，您好:\n"
				+ "歡迎註冊使用樂狗購票網");
		mailSender.send(message);
		
	}

	
	@Override
	public void ticketSend(String receivers, String username,String orderNum, List<ByteArrayResource>  ticketList) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		String mailAddress = System.getProperty("SMTP_USERNAME");
		String mailName = "樂狗購票網<" + mailAddress + ">";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			mimeMessage.setFrom(mailName);
			helper.setTo(receivers);
			helper.setSubject("訂單編號:" + orderNum + "，入場門票已送達");
			helper.setText("親愛的" + username + "會員，您好:\n "
					+ " 您本次購買的門票已送達，謝謝您的支持"
					+ " 歡迎再次使用樂狗購票網");
			for (int i =0; i<ticketList.size();i++) {
				int j = i+1;
				helper.addAttachment("Ticket_" + orderNum+"_" + j +".png", ticketList.get(i));
			}
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
