package com.example.ticketbackend.service.ifs;

import java.util.List;

import com.example.ticketbackend.vo.GetAllQueueRes;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface RabbitmqService {
	
	//���o�Ҧ����C
	public GetAllQueueRes getAllQueue();
	//���o�Ҧ��`�ؼs���洫���W��
	public RtnCodeRes getAllTypeExchange();
	//���o�Y�洫�����U�Ҧ��j�w�����C
	public List<String> getAllQueueByExchange(String exchangeName);
	//�o�e�����춤�C
	public RtnCodeRes sendMsg(String subscribe,String message);
}
