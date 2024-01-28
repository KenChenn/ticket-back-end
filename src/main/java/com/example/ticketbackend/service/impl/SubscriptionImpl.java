package com.example.ticketbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Subscription;
import com.example.ticketbackend.repository.SubscriptionDao;
import com.example.ticketbackend.service.ifs.SubscriptionService;
import com.example.ticketbackend.vo.GetSubscribeListRes;
import com.example.ticketbackend.vo.RtnCodeRes;

@Service
public class SubscriptionImpl implements SubscriptionService{

	@Autowired
	SubscriptionDao subscriptionDao;
	
	@Override
	public GetSubscribeListRes getSubscribeList(String account) {
		if (!StringUtils.hasText(account)) {
			return new GetSubscribeListRes(RtnCode.PARAM_ERROR,null);
		}
		List<Subscription> list = subscriptionDao.getSubscribeList(account);
		return new GetSubscribeListRes(RtnCode.SUCCESSFUL,list);
	}

	@Override
	public RtnCodeRes subscribe(String account, String subscribe) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(subscribe)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if(subscriptionDao.existsByAccountAndSubscribe(account, subscribe)) {
			return new RtnCodeRes(RtnCode.ALREADY_SUBSCRIBE);
		}
		Subscription data = new Subscription();
		data.setAccount(account);
		data.setSubscribe(subscribe);
		try {
			subscriptionDao.save(data);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.SUBSCRIBE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes cancelSubscribe(String account, String subscribe) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(subscribe)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if(!subscriptionDao.existsByAccountAndSubscribe(account, subscribe)) {
			return new RtnCodeRes(RtnCode.NOT_SUBSCRIBED_NOW);
		}
		try {
			subscriptionDao.delete(account,subscribe);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.CANCEL_SUBSCRIBE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

}
