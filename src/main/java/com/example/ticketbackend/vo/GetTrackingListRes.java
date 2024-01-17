package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Tracking;

public class GetTrackingListRes extends RtnCodeRes{

	
	private List<GetTrackingList> data;

	public GetTrackingListRes() {
		super();
	}

	public GetTrackingListRes(RtnCode rtncode,List<GetTrackingList> data) {
		super(rtncode);
		this.data = data;
	}

	public List<GetTrackingList> getData() {
		return data;
	}

	public void setData(List<GetTrackingList> data) {
		this.data = data;
	}


	
	
}
