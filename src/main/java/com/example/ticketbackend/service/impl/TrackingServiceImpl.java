package com.example.ticketbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Tracking;
import com.example.ticketbackend.repository.TrackingDao;
import com.example.ticketbackend.service.ifs.TrackingService;
import com.example.ticketbackend.vo.GetTrackingList;
import com.example.ticketbackend.vo.GetTrackingListRes;
import com.example.ticketbackend.vo.TrackRes;

@Service
public class TrackingServiceImpl implements TrackingService {

	@Autowired
	private TrackingDao trackingDao;

	@Override
	public TrackRes track(String tracker, String commodityCodeName) {
		if (!StringUtils.hasText(tracker) || !StringUtils.hasText(commodityCodeName)) {
			return new TrackRes(RtnCode.PARAM_ERROR, null);
		}
		Tracking data = trackingDao.isTracking(tracker, commodityCodeName);
		if (data != null) {
			return new TrackRes(RtnCode.ALREADY_TRACKED, true);
		}
		trackingDao.save(new Tracking(tracker, commodityCodeName));
		return new TrackRes(RtnCode.SUCCESSFUL, true);
	}

	@Override
	public TrackRes untrack(String tracker, String commodityCodeName) {
		if (!StringUtils.hasText(tracker) || !StringUtils.hasText(commodityCodeName)) {
			return new TrackRes(RtnCode.PARAM_ERROR, null);
		}
		Tracking data = trackingDao.isTracking(tracker, commodityCodeName);
		if (data == null) {
			return new TrackRes(RtnCode.NOT_TRACKGIN, false);
		}
		int readyToDeleteId = data.getId();
		try {
			trackingDao.deleteById(readyToDeleteId);
		} catch (Exception e) {
			return new TrackRes(RtnCode.UNTRACK_ERROR, null);
		}
		return new TrackRes(RtnCode.SUCCESSFUL, false);
	}

	@Override
	public TrackRes checktrack(String tracker, String commodityCodeName) {
		if (!StringUtils.hasText(tracker) || !StringUtils.hasText(commodityCodeName)) {
			return new TrackRes(RtnCode.PARAM_ERROR, null);
		}
		Tracking data = trackingDao.isTracking(tracker, commodityCodeName);
		return new TrackRes(RtnCode.SUCCESSFUL, (data != null ? true : false));
	}
	
	@Override
	public GetTrackingListRes getTrackingList(String tracker) {
		if (!StringUtils.hasText(tracker)) {
			return new GetTrackingListRes(RtnCode.PARAM_ERROR, null);
		}
	   List<GetTrackingList> data = trackingDao.getTrackingList(tracker);
		return new GetTrackingListRes(RtnCode.SUCCESSFUL, data);
	}

}
