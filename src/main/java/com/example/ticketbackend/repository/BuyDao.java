package com.example.ticketbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Buy;

@Repository
public interface BuyDao extends JpaRepository<Buy, String>{
	
 public Buy findByBuyNum(String buyNum);

}
