package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{

	public User findByAccountAndPwd(String account,String pwd);
	
	public boolean existsByAccountAndPwd(String account,String pwd);
	
}
