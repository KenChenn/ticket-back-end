package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Commodity;

public class GetAllCommodity extends RtnCodeRes{

	private List<Commodity> data;

	public GetAllCommodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllCommodity(RtnCode rtncode,List<Commodity> data) {
		super(rtncode);
		this.data = data;
	}

	public List<Commodity> getData() {
		return data;
	}

	public void setData(List<Commodity> data) {
		this.data = data;
	}

	
	
}
