package com.example.ticketbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.service.ifs.RabbitmqService;
import com.example.ticketbackend.vo.GetAllQueueRes;

@CrossOrigin
@RestController
public class RabbitmqController {
	
	@Autowired
	RabbitmqService rabbitmqService;
	
	@GetMapping(value = "api/getAllSubscribe")
	public GetAllQueueRes getAllQueue() {
		GetAllQueueRes res = rabbitmqService.getAllQueue();
		return res;
	}

}
