package com.example.ticketbackend.service.ifs;

import java.util.List;

import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SessionReq;

public interface SessionsService {
	//�ˬd��ƥ�
	public RtnCodeRes sessionAndSeatDataCheck(String codeName,List<SessionReq> data);
	//�sSession
	public RtnCodeRes addSessions(String codeName,List<SessionReq> data);

	
}
