package com.example.ticketbackend.service.ifs;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.vo.SeatReq;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface SeatService {

	//檢查資料用
	public RtnCodeRes seatDataCheck(List<SeatReq> data);

	public RtnCodeRes insertSeat(String commodityCodename,LocalDateTime showDateTime,List<SeatReq> data);

	public RtnCodeRes cancelOrder(String account,String buyNum);
}
