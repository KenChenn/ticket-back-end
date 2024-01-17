package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Tracking;
import com.example.ticketbackend.vo.GetTrackingList;

@Repository
public interface TrackingDao extends JpaRepository<Tracking, Integer>{


	@Query(value ="select T from Tracking as T where (tracker = :tracker) and (commodity_codename = :commodityCodeName)")
	public Tracking isTracking(@Param("tracker")String tracker,@Param("commodityCodeName")String commodityCodeName);

//	@Query("select T from Tracking as T where tracker = :tracker")
	@Query("select new com.example.ticketbackend.vo.GetTrackingList(T.id,T.tracker,T.commodityCodename,C.name,C.startDate,C.endDate,C.place,C.keyvisualImg,C.organizer) "
			+ " from Tracking as T "
			+ " inner join Commodity as C on T.commodityCodename = C.codename "
			+ " where (T.tracker = :tracker) "
			+ " order by C.startDate")
	public List<GetTrackingList> getTrackingList(@Param("tracker")String tracker);
}
