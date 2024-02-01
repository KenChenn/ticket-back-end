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
	
	private String mailAddress = System.getProperty("SMTP_USERNAME");
	private String mailName = "票亮視界<" + mailAddress + ">";
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
//		String mailAddress = System.getProperty("SMTP_USERNAME");
//		String mailName = "票亮視界<" + mailAddress + ">";
		message.setFrom(mailName);
		message.setTo(receivers);
		message.setSubject("註冊成功");
		message.setText(username +"會員，您好:\n"
				+ " 歡迎註冊使用票亮視界");
		mailSender.send(message);
		
	}
	
	@Override
	public void cancelOrderMail(String receivers, String username, String buyNum) {
		SimpleMailMessage email = new SimpleMailMessage();
//		String mailAddress = System.getProperty("SMTP_USERNAME");
//		String mailName = "票亮視界<" + mailAddress + ">";
		email.setFrom(mailName);
		email.setTo(receivers);
		email.setSubject("訂單編號:" + buyNum + "，已取消訂單");
		email.setText("親愛的" + username + "會員，您好:\n"
				+ "已為您取消，訂單編號:" + buyNum + "之訂單\n"
				+ "如您已完成付款，請到網站填寫相關退款申請書\n"
				+ "期待您再次使用票亮視界");
		mailSender.send(email);
	
	}

	
	@Override
	public void ticketSend(String receivers, String username,String orderNum, List<ByteArrayResource>  ticketList) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
//		String mailAddress = System.getProperty("SMTP_USERNAME");
//		String mailName = "票亮視界<" + mailAddress + ">";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			mimeMessage.setFrom(mailName);
			helper.setTo(receivers);
			helper.setSubject("訂單編號:" + orderNum + "，入場門票已送達");
			helper.setText("親愛的" + username + "會員，您好:\n "
					+ " 您本次購買的門票已送達，謝謝您的支持\n"
					+ " 歡迎再次使用票亮視界");
			for (int i =0; i<ticketList.size();i++) {
				int j = i+1;
				helper.addAttachment("Ticket_" + orderNum+"_" + j +".png", ticketList.get(i));
			}
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void subscribeMail(String[] mailArray, String message) {
		SimpleMailMessage email = new SimpleMailMessage();
//		String mailAddress = System.getProperty("SMTP_USERNAME");
//		String mailName = "票亮視界<" + mailAddress + ">";
		email.setFrom(mailName);
		email.setTo(mailArray);
		email.setSubject("您訂閱的消息");
		email.setText(message);
		try {
			mailSender.send(email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	
	
	
}
