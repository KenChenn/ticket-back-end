package com.example.ticketbackend.service.ifs;

import java.util.List;

import com.example.ticketbackend.vo.GetAllQueueRes;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface RabbitmqService {
	
	//取得所有隊列
	public GetAllQueueRes getAllQueue();
	//取得所有節目廣播交換器名稱
	public RtnCodeRes getAllTypeExchange();
	//取得某交換器底下所有綁定的隊列
	public List<String> getAllQueueByExchange(String exchangeName);
	//發送消息到隊列
	public RtnCodeRes sendMsg(String subscribe,String message);
}
