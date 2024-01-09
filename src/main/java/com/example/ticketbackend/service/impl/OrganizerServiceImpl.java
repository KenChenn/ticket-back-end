package com.example.ticketbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Organizer;
import com.example.ticketbackend.repository.OrganizerDao;
import com.example.ticketbackend.service.ifs.OrganizerService;
import com.example.ticketbackend.vo.GetOrganizerDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;

@Service
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerDao organizerDao;

	@Override
	public RtnCodeRes addOrganizer(String name, String email, String phone, String address, String url, String sns) {

		if (!StringUtils.hasText(name) || !StringUtils.hasText(email) || !StringUtils.hasText(phone)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		if (organizerDao.existsByName(name)) {
			return new RtnCodeRes(RtnCode.ORGANIZER_EXISTED);
		}
		try {
			organizerDao.save(new Organizer(name, email, phone, address, url, sns));
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.ORGANIZER_ADD_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes updateOrganizer(int id, String name, String email, String phone, String address, String url,
			String sns) {
		if (id <= 0 || !StringUtils.hasText(name) || !StringUtils.hasText(email) || !StringUtils.hasText(phone)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Optional<Organizer> op = organizerDao.findById(id);
		if (op.isEmpty()) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		Organizer organizer = op.get();
		if (!organizer.getName().equals(name) && organizerDao.existsByName(name)) {
			return new RtnCodeRes(RtnCode.ORGANIZER_EXISTED);
		}
		organizer.setName(name);
		organizer.setEmail(email);
		organizer.setPhone(phone);
		organizer.setAddress(address);
		organizer.setUrl(url);
		organizer.setSns(sns);
		try {
			organizerDao.save(organizer);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.ORGANIZER_UPDATE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes deleteOrganizer(int id) {
		if (id <= 0) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Optional<Organizer> op = organizerDao.findById(id);
		if (op.isEmpty()) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		try {
			organizerDao.delete(op.get());
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.ORGANIZER_DELETE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetOrganizerDataRes getOrganizerData() {
		List<Organizer> data = organizerDao.findAll();
		return new GetOrganizerDataRes(RtnCode.SUCCESSFUL,data);
	}

}
