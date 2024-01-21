package com.example.ticketbackend;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;

import com.example.ticketbackend.service.ifs.MailService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@SpringBootTest
public class MailServiceTest {

	@Autowired
	private MailService mailService;
	
	@Test
	public void sendTest() {
		String data="hello world";
		String filePath="qrcode.png";
		int width=300;
		int height=300;
		String format = "png";
		Map<EncodeHintType,Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			try {
				BitMatrix bitMatrix =new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hints);
				Path path = FileSystems.getDefault().getPath(filePath);
				MatrixToImageWriter.writeToPath(bitMatrix, format, path);
				byte[] qcBytes = Files.readAllBytes(path);
				ByteArrayResource qrCodeResource = new ByteArrayResource(qcBytes);
//				mailService.ticketSend("¶l¥ó¦a§}","Ken",123,qrCodeResource);
			} catch (WriterException | IOException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void sendTest1() {
	}
}
