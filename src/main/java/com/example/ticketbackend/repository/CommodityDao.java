package com.example.ticketbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Commodity;

@Repository
public interface CommodityDao extends JpaRepository<Commodity, String> {

	public List<Commodity> findByCodename(String codename);

	@Query(value = "select * from Commodity where (name like %:name%) and (((now() >= start_date) AND (now() <= end_date)) OR (now() <= start_date))", nativeQuery = true)
	public List<Commodity> searchCommodity(@Param("name") String name);

}
