package com.example.ticketbackend.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.util.VerifyUtil;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.VerifyReq;


@RestController
@SuppressWarnings("unchecked")
public class VerifyController {
	
    @Autowired
    RedisTemplate redisTemplate;

	@GetMapping(value = "/verify/getcode")
    public void getCode(HttpSession session,HttpServletResponse response) {
    	String id = session.getId();
    	
    	Object[] objs = VerifyUtil.newBuilder().build().createImage();
    	
    	session.setAttribute("SESSION_VERIFY_CODE_" + id, objs[0]);
    	System.out.println(id);
    	System.out.println(objs[0]);
    	redisTemplate.setKeySerializer(new StringRedisSerializer());
    	redisTemplate.setValueSerializer(new StringRedisSerializer());
    	redisTemplate.opsForValue().set(("VERIFY_CODE_" + id),"3",5*60,TimeUnit.SECONDS);
    	
    	BufferedImage image = (BufferedImage)objs[1];
    	response.setContentType("image/png");
    	try {
    		OutputStream os =response.getOutputStream();
			ImageIO.write(image, "png", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@PostMapping(value = "/verify/checkcode")
	public RtnCodeRes checkCode(@RequestBody VerifyReq req,HttpSession session) {
		String id = session.getId();
		
		String verifyCodeKey = "VERIFY_CODE_" + id;
		long num = redisTemplate.opsForValue().decrement(verifyCodeKey);
		
		if(num <0) {
			return new RtnCodeRes(RtnCode.VERIFICATION_CODE_INVALID);
		}
		String serverCode = (String) session.getAttribute("SESSION_" + verifyCodeKey);
		if(serverCode == null || !StringUtils.hasText(req.getCode()) || !serverCode.equals(req.getCode())) {
			return new RtnCodeRes(RtnCode.VERIFICATION_CODE_EXPIRED);
		}

		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}
}
