package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Tracking;

@Repository
public interface TrackingDao extends JpaRepository<Tracking, Integer>{


	@Query(value ="select T from Tracking as T where (tracker = :tracker) and (commodity_codename = :commodityCodeName)")
	public Tracking isTracking(@Param("tracker")String tracker,@Param("commodityCodeName")String commodityCodeName);

	@Query(value ="select T from Tracking as T where tracker = :tracker")
	public List<Tracking> getTrackingList(@Param("tracker")String tracker);
}
