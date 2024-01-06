package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

}
