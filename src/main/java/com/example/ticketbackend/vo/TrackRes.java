package com.example.ticketbackend.vo;

import com.example.ticketbackend.constants.RtnCode;

public class TrackRes extends RtnCodeRes{

	
	private Boolean is_Track;

	public TrackRes() {
		super();
	}

	public TrackRes(RtnCode rtncode,Boolean is_Track) {
		super(rtncode);
		this.is_Track = is_Track;
	}



	public Boolean getIs_Track() {
		return is_Track;
	}

	public void setIs_Track(Boolean is_Track) {
		this.is_Track = is_Track;
	}





	
	
}
