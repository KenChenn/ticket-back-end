package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Tracking;

public class GetTrackingListRes extends RtnCodeRes{

	
	private List<Tracking> data;

	public GetTrackingListRes() {
		super();
	}

	public GetTrackingListRes(RtnCode rtncode,List<Tracking> data) {
		super(rtncode);
		this.data = data;
	}

	public List<Tracking> getData() {
		return data;
	}

	public void setData(List<Tracking> data) {
		this.data = data;
	}


	
	
}
