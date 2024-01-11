package com.example.ticketbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.service.ifs.OrganizerService;
import com.example.ticketbackend.vo.AddOrganizerReq;
import com.example.ticketbackend.vo.GetOrganizerDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.UpdateOrganizerReq;

@CrossOrigin
@RestController
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;

	// 新建主辦單位
	@PostMapping(value = "api/add_organizer")
	public RtnCodeRes addOrganizer(@RequestBody AddOrganizerReq req,HttpSession session) {
		String attr = (String) session.getAttribute("isAdmin");
		if (!StringUtils.hasText(attr) || attr != "true") {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
		}
		RtnCodeRes res = organizerService.addOrganizer(req.getName(), req.getEmail(), req.getPhone(), req.getAddress(),
				req.getUrl(),req.getSns());
		return res;

	}
	
	// 修改主辦單位
	@PostMapping(value = "api/update_organizer")
	public RtnCodeRes updateOrganizer(@RequestBody UpdateOrganizerReq req,HttpSession session) {
		String attr = (String) session.getAttribute("isAdmin");
		if (!StringUtils.hasText(attr) || attr != "true") {
			return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
		}
		RtnCodeRes res = organizerService.updateOrganizer(req.getId(), req.getName(), req.getEmail(), req.getPhone(), req.getAddress(), req.getUrl(), req.getSns());
		return res;

	}
	
	// 刪除主辦單位
		@PostMapping(value = "api/delete_organizer")
		public RtnCodeRes deleteOrganizer(@RequestBody UpdateOrganizerReq req,HttpSession session) {
			String attr = (String) session.getAttribute("isAdmin");
			if (!StringUtils.hasText(attr) || attr != "true") {
				return new RtnCodeRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST);
			}
			RtnCodeRes res = organizerService.deleteOrganizer(req.getId());
			return res;

		}
		
		// 獲取所有主辦單位資料
				@GetMapping(value = "api/get_organizer_data")
				public GetOrganizerDataRes getOrganizerData(HttpSession session) {
					String attr = (String) session.getAttribute("isAdmin");
					if (!StringUtils.hasText(attr) || attr != "true") {
						return new GetOrganizerDataRes(RtnCode.PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST,null);
					}
					return organizerService.getOrganizerData();
				}

}
