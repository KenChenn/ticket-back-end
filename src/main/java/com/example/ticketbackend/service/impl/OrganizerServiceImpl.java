package com.example.ticketbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Organizer;
import com.example.ticketbackend.repository.OrganizerDao;
import com.example.ticketbackend.service.ifs.OrganizerService;
import com.example.ticketbackend.vo.RtnCodeRes;

@Service
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerDao organizerDao;

	@Override
	public RtnCodeRes addOrganizer(String name, String email, String phone, String address, String url) {

		if (!StringUtils.hasText(name) || !StringUtils.hasText(email) || !StringUtils.hasText(phone)
				|| !StringUtils.hasText(address) || !StringUtils.hasText(url)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if(organizerDao.existsByName(name)) {
			return new RtnCodeRes(RtnCode.ORGANIZER_EXISTED);
		}
		try {
			organizerDao.save(new Organizer(name,email,phone,address,url));
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.ORGANIZER_ADD_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

}
