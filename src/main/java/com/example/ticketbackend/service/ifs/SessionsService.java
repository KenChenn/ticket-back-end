package com.example.ticketbackend.service.ifs;

import java.util.List;

import com.example.ticketbackend.service.impl.GetSessionsDataRes;
import com.example.ticketbackend.vo.GetUpdateCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SessionReq;
import com.example.ticketbackend.vo.UpdateSessionReq;

public interface SessionsService {
	//�ˬd��ƥ�
	public RtnCodeRes sessionAndSeatDataCheck(String codeName,List<SessionReq> data);
	public RtnCodeRes updateSessionAndSeatDataCheck(String codeName,List<UpdateSessionReq> data);
	//�sSession
	public RtnCodeRes addSessions(String codeName,List<SessionReq> data);
	
	
	public GetUpdateCommodityDataRes getUpdateCommodityData(String codeName);
	
	public GetSessionsDataRes getSessionsData(String codeName);
	
	public RtnCodeRes udpateCommodityAndSeat(String codeName,List<UpdateSessionReq> data);
}
