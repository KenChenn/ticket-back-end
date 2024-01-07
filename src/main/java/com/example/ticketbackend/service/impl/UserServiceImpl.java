package com.example.ticketbackend.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.User;
import com.example.ticketbackend.repository.UserDao;
import com.example.ticketbackend.service.ifs.UserService;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.UserBasicDateRes;

@Service
public class UserServiceImpl implements UserService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private UserDao userDao;

	// �ϥΪ̵n�J
	@Override
	public RtnCodeRes login(String account, String pwd) {
		// �ˬd�b����K�X�O�_����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Optional<User> op = userDao.findById(account);
		// �ˬd�b���O�_�s�b
		if (op.isEmpty()) {
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		;
		User user = op.get();
		// �ˬd�K�X�O�_���T
		if (!encoder.matches(pwd, user.getPwd())) { // �p�G�K�X���~���ܴN�^�ǧ䤣��b��
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	// �ϥΪ̵��U
	@Override
	public RtnCodeRes signUp(String account, String pwd, String realname, String username, String email,
			LocalDate bornDate, String phone) {
		Optional<LocalDate> bornDateOP = Optional.ofNullable(bornDate);
		// �ˬd�b����K�X�O�_����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || !StringUtils.hasText(realname)
				|| !StringUtils.hasText(username) || !StringUtils.hasText(email) || !bornDateOP.isPresent()
				|| !StringUtils.hasText(phone)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		// �ˬd�b���O�_�w�s�b
		if (userDao.existsById(account)) {
			return new RtnCodeRes(RtnCode.ACCOUNT_EXISTED);
		}
		if (userDao.existsByUsername(username)) {
			return new RtnCodeRes(RtnCode.USERNAME_ALREADY_IN_USE);
		}
		userDao.save(new User(account, encoder.encode(pwd), realname, username, email, bornDate, phone, null, false));
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	// �޲z�̵n�J
	@Override
	public RtnCodeRes adminLogin(String account, String pwd) {
		// �ˬd�b����K�X�O�_����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		User admin = userDao.findByAccountAndAdminTrue(account);
		if (admin == null || !encoder.matches(pwd, admin.getPwd())) {
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	//�ק�ӤH��T
	@Override
	public RtnCodeRes userDataUpdate(String account, String username, String email, String phone) {
		if (!StringUtils.hasText(username) || !StringUtils.hasText(email) || !StringUtils.hasText(phone)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		User user = userDao.findByAccountAndAdminFalse(account);
		if (user == null) {
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		if (userDao.existsByUsername(username)) {
			return new RtnCodeRes(RtnCode.USERNAME_ALREADY_IN_USE);
		}
		user.setUsername(username);
		user.setEmail(email);
		user.setPhone(phone);
		try {
			userDao.save(user);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.USER_DATA_UPDATE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public UserBasicDateRes userBasicData(String account) {
		if (!StringUtils.hasText(account)) {
			return new UserBasicDateRes(RtnCode.PARAM_ERROR, null);
		}
		User user = userDao.findByAccountAndAdminFalse(account);
		if (user == null) {
			return new UserBasicDateRes(RtnCode.ACCOUNT_NOT_FOUND, null);
		}

		Map<String, Object> data = new HashMap<>();
		data.put("username", user.getUsername());
		data.put("email", user.getEmail());
		data.put("bornDate", user.getBornDate());
		data.put("phone", user.getPhone());
		return new UserBasicDateRes(RtnCode.SUCCESSFUL, data);

	}

	@Override
	public RtnCodeRes userPwdChange(String account, String oldPwd, String newPwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		User user = userDao.findByAccountAndAdminFalse(account);
		if (user == null) {
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		if (!encoder.matches(oldPwd, user.getPwd())) { 
			return new RtnCodeRes(RtnCode.PWD_NOT_CORRECT);
		}
		if (encoder.matches(newPwd, user.getPwd())) { 
			return new RtnCodeRes(RtnCode.PLEASE_ENTER_NEW_PWD);
		}
		user.setPwd(encoder.encode(newPwd));
		try {
			userDao.save(user);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.USER_DATA_UPDATE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

}
