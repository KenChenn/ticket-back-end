package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Forum;

@Repository
public interface ForumDao extends JpaRepository<Forum, String>{

}
