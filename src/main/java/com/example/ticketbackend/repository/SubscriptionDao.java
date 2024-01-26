package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticketbackend.entity.Subscription;

public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {

}
