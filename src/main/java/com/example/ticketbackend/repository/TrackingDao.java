package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Tracking;

@Repository
public interface TrackingDao extends JpaRepository<Tracking, Integer>{

}
