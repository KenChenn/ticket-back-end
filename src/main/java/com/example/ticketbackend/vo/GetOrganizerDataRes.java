package com.example.ticketbackend.vo;

import java.util.List;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Organizer;

public class GetOrganizerDataRes extends RtnCodeRes{

	private List<Organizer> organizer;

	public GetOrganizerDataRes() {
		super();
	}

	public GetOrganizerDataRes(RtnCode rtncode,List<Organizer> organizer) {
		super(rtncode);
		this.organizer = organizer;

	}

	public List<Organizer> getOrganizer() {
		return organizer;
	}

	public void setOrganizer(List<Organizer> organizer) {
		this.organizer = organizer;
	}

	
}
