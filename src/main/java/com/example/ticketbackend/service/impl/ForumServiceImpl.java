package com.example.ticketbackend.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ticketbackend.constants.RtnCode;
import com.example.ticketbackend.entity.Forum;
import com.example.ticketbackend.entity.User;
import com.example.ticketbackend.repository.ForumDao;
import com.example.ticketbackend.repository.UserDao;
import com.example.ticketbackend.service.ifs.ForumService;
import com.example.ticketbackend.vo.GetComments;
import com.example.ticketbackend.vo.RtnCodeRes;

@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	ForumDao forumDao;
	@Autowired
	UserDao userDao;
	
	@Override
	public RtnCodeRes comment(String commenter, String commodityCodename, String comments) {
		if (!StringUtils.hasText(commenter) || !StringUtils.hasText(commodityCodename)
				|| !StringUtils.hasText(comments)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		User u = userDao.findByAccountAndAdminFalse(commenter);
		if(u == null) {
			return new RtnCodeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		Forum newComment = new Forum(commodityCodename, u.getUsername(), comments, LocalDateTime.now());
		try {
			forumDao.save(newComment);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.COMMENT_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public RtnCodeRes deleteComment(int id, String commenter) {
		if (id <= 0 || !StringUtils.hasText(commenter)) {
			return new RtnCodeRes(RtnCode.PARAM_ERROR);
		}
		Optional<Forum> op = forumDao.findById(id);
		if (op.isEmpty()) {
			return new RtnCodeRes(RtnCode.DATA_NOT_FOUND);
		}
		Forum deleteComment = op.get();
		if(!deleteComment.getCommenter().equals(commenter)) {
			return new RtnCodeRes(RtnCode.COMMENTER_ERROR);
		}
		try {
			forumDao.deleteById(id);
		} catch (Exception e) {
			return new RtnCodeRes(RtnCode.COMMENT_DELETE_ERROR);
		}
		return new RtnCodeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public GetComments getComments(String commodityCodename) {
		if (!StringUtils.hasText(commodityCodename)) {
			return new GetComments(RtnCode.PARAM_ERROR,null);
		}
		List<Forum> data = forumDao.getComments(commodityCodename);
		return new GetComments(RtnCode.SUCCESSFUL,data);
	}

}
