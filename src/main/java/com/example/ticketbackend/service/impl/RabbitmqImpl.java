package com.example.ticketbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.RabbitmqService;
import com.example.ticketbackend.vo.GetAllQueueRes;
import com.example.ticketbackend.vo.RtnCodeRes;


@Service
public class RabbitmqImpl implements RabbitmqService{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
    private AmqpAdmin amqpAdmin;

	@Value("${spring.rabbitmq.host}")
	 private String rabbitMqHost;
	@Value("${spring.rabbitmq.port}")
	 private String rabbitMqPort;
	@Value("${rabbitmq.apiurl}")
	 private String rabbitApiUrl;
	@Value("${spring.rabbitmq.username}")
	 private String rabbitUserName;
	@Value("${spring.rabbitmq.password}")
	 private String rabbitPassword;
	
	@Override
	public GetAllQueueRes getAllQueue() {
		String apiUrl = rabbitApiUrl + "/queues";
		RestTemplate restTemplate = new RestTemplate();
		 restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(rabbitUserName, rabbitPassword));
		 ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		 JSONArray jsonArray = new JSONArray(response.getBody());
		 List<String> strList = new ArrayList<String>();
		 for (int i =0;i<jsonArray.length();i++) {
			 JSONObject jsonObject = jsonArray.getJSONObject(i);
			 if(jsonObject.getString("name").startsWith("commodityType")) {
				 strList.add(jsonObject.getString("name"));
			 }
		}
		return new GetAllQueueRes(RtnCode.SUCCESSFUL,strList);
	}
	
	@Override
	public RtnCodeRes getAllTypeExchange() {
		String apiUrl = rabbitApiUrl + "/exchanges";
		RestTemplate restTemplate = new RestTemplate();
		 restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(rabbitUserName, rabbitPassword));
		 ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		 System.out.println(response.getStatusCodeValue());
		 System.out.println(response);
		 JSONArray jsonArray = new JSONArray(response.getBody());
		 List<String> strList = new ArrayList<String>();
		 for (int i =0;i<jsonArray.length();i++) {
			 JSONObject jsonObject = jsonArray.getJSONObject(i);
			 if(jsonObject.getString("name").startsWith("commodityType")) {
				 strList.add(jsonObject.getString("name"));
			 }
		}
		 System.out.println(strList);
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}




	@Override
	public List<String> getAllQueueByExchange(String exchangeName) {
		if(!StringUtils.hasText(exchangeName)) {
			return null;
		}
		String apiUrl = rabbitApiUrl + "/bindings";
		System.out.println(apiUrl);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(rabbitUserName, rabbitPassword));
		 ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		 System.out.println(response);
		 JSONArray jsonArray = new JSONArray(response.getBody());
		 System.out.println(jsonArray);
		 List<String> strList = new ArrayList<String>();
		 System.out.println(jsonArray.length());
		 for (int i =0;i<jsonArray.length();i++) {
			 JSONObject jsonObject = jsonArray.getJSONObject(i);
			 if(jsonObject.getString("source").equals(exchangeName)) {
				 strList.add(jsonObject.getString("destination"));
			 } 
		}
		 System.out.println(strList);
		return null;
	}

	@Override
	public RtnCodeRes sendMsg(String subscribe, String message) {
		if(!StringUtils.hasText(subscribe)||!StringUtils.hasText(message)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		try {
			rabbitTemplate.convertAndSend(subscribe, message);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.SEND_SUBSCRIBE_MESSAGE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}





	
	

	
	
}
