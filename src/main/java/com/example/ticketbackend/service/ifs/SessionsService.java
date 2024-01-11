package com.example.ticketbackend.service.ifs;

import java.util.List;

import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SessionReq;

public interface SessionsService {
	//檢查資料用
	public RtnCodeRes sessionAndSeatDataCheck(String codeName,List<SessionReq> data);
	//存Session
	public RtnCodeRes addSessions(String codeName,List<SessionReq> data);

	
}
