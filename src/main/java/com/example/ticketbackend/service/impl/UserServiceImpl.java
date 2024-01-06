package com.example.ticketbackend.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.User;
import com.example.ticketbackend.repository.UserDao;
import com.example.ticketbackend.service.ifs.UserService;
import com.example.ticketbackend.vo.UserLoginRes;

@Service
public class UserServiceImpl implements UserService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private UserDao userDao;

	// �ϥΪ̵n�J
	@Override
	public UserLoginRes login(String account, String pwd) {
		// �ˬd�b����K�X�O�_����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UserLoginRes(RtnCode.PARAM_ERROR);
		}
		Optional<User> op = userDao.findById(account);
		// �ˬd�b���O�_�s�b
		if (op.isEmpty()) {
			return new UserLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		;
		User user = op.get();
		// �ˬd�K�X�O�_���T
		if (!encoder.matches(pwd, user.getPwd())) { // �p�G�K�X���~���ܴN�^�ǧ䤣��b��
			return new UserLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new UserLoginRes(RtnCode.SUCCESSFUL);
	}

	// �ϥΪ̵��U
	@Override
	public UserLoginRes signUp(String account, String pwd, String realname, String username, String email,
			LocalDate bornDate, String phone) {
		Optional<LocalDate> bornDateOP = Optional.ofNullable(bornDate);
		// �ˬd�b����K�X�O�_����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || !StringUtils.hasText(realname)
				|| !StringUtils.hasText(username) || !StringUtils.hasText(email) || !bornDateOP.isPresent()
				|| !StringUtils.hasText(phone)) {
			return new UserLoginRes(RtnCode.PARAM_ERROR);
		}
		// �ˬd�b���O�_�w�s�b
		if (userDao.existsById(account)) {
			return new UserLoginRes(RtnCode.ACCOUNT_EXISTED);
		}
		if (userDao.existsByUsername(username)) {
			return new UserLoginRes(RtnCode.USERNAME_ALREADY_IN_USE);
		}
		userDao.save(new User(account, encoder.encode(pwd), realname, username, email, bornDate, phone, null, false));
		return new UserLoginRes(RtnCode.SUCCESSFUL);
	}

	// �޲z�̵n�J
	@Override
	public UserLoginRes adminLogin(String account, String pwd) {
		// �ˬd�b����K�X�O�_����
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UserLoginRes(RtnCode.PARAM_ERROR);
		}
		User admin = userDao.findByAccountAndAdminTrue(account);
		if (admin == null || !encoder.matches(pwd, admin.getPwd())) {
			return new UserLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new UserLoginRes(RtnCode.SUCCESSFUL);
	}

}
