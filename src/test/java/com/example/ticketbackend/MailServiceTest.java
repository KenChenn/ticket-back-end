package com.example.ticketbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.service.ifs.MailService;
import com.google.zxing.qrcode.QRCodeWriter;

@SpringBootTest
public class MailServiceTest {

	@Autowired
	private MailService mailService;
	
	@Test
	public void sendTest() {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
	}
}
