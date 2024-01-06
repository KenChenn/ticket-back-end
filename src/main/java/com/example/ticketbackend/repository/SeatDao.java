package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.entity.SeatId;

@Repository
public interface SeatDao extends JpaRepository<Seat, SeatId>{

}
