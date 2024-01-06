package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Sessions;

@Repository
public interface SessionsDao extends JpaRepository<Sessions, Integer>{

}
