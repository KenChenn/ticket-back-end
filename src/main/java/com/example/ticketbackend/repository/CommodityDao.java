package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Commodity;


@Repository
public interface CommodityDao extends JpaRepository<Commodity, String>{

}
