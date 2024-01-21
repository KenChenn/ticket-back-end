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
		String mailName = "�֪��ʲ���<" + mailAddress + ">";
		message.setFrom(mailName);
		message.setTo(receivers);
		message.setSubject("���U���\");
		message.setText(username +"�|���A�z�n:\n"
				+ "�w����U�ϥμ֪��ʲ���");
		mailSender.send(message);
		
	}

	
	@Override
	public void ticketSend(String receivers, String username,String orderNum, List<ByteArrayResource>  ticketList) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		String mailAddress = System.getProperty("SMTP_USERNAME");
		String mailName = "�֪��ʲ���<" + mailAddress + ">";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			mimeMessage.setFrom(mailName);
			helper.setTo(receivers);
			helper.setSubject("�q��s��:" + orderNum + "�A�J�������w�e�F");
			helper.setText("�˷R��" + username + "�|���A�z�n:\n "
					+ " �z�����ʶR�������w�e�F�A���±z�����"
					+ " �w��A���ϥμ֪��ʲ���");
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
