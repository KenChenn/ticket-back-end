package com.example.ticketbackend.service.ifs;

import com.example.ticketbackend.vo.GetTrackingListRes;
import com.example.ticketbackend.vo.TrackRes;

public interface TrackingService {
	
	public TrackRes track(String tracker,String commodityCodeName);
	
	public TrackRes untrack(String tracker, String commodityCodeName);
	
	public TrackRes checktrack(String tracker, String commodityCodeName);

	public GetTrackingListRes getTrackingList(String tracker);
}
