package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Commodity;
import com.example.ticketbackend.vo.GetCommodityAndSessionsVo;

@Repository
public interface CommodityDao extends JpaRepository<Commodity, Integer> {

	public Commodity findByCodename(String codename);
	
	
	public boolean existsByCodename(String codename);

	@Query(value = "select * from Commodity where (name like %:name%) and (((DATE_FORMAT(NOW(), '%Y-%m-%d') >= start_date) AND (DATE_FORMAT(NOW(), '%Y-%m-%d') < end_date)) OR (DATE_FORMAT(NOW(), '%Y-%m-%d') < start_date))", nativeQuery = true)
	public List<Commodity> searchCommodity(@Param("name")String name);

	@Query("select new com.example.ticketbackend.vo.GetCommodityAndSessionsVo(C.id,C.codename,S.num,S.showDateTime,S.startSellDateTime,S.endSellDateTime) "
			+ " from Commodity as C "
			+ " inner join Sessions as S on C.codename = S.commodityCodename "
			+ " where (C.codename = :codeName) "
			+ " order by S.startSellDateTime")
	public List<GetCommodityAndSessionsVo> getCommodityAndSessions(@Param("codeName")String codeName);
	
	@Query(value = "select * from Commodity order by start_date desc", nativeQuery = true)
	public List<Commodity> getAllCommodity();
}
