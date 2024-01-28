package com.example.ticketbackend.service.ifs;

import java.util.List;

import javax.activation.DataSource;

import org.springframework.core.io.ByteArrayResource;

public interface MailService {

	
//	public void sendMail(Collection<String> receivers,String subject,String content);
	
	public void singUpMail(String receivers,String account);
	
	public void ticketSend(String receivers, String username,String orderNum, List<ByteArrayResource>  ticketList);

	public void subscribeMail(String[] mailArray,String message);
}
