package com.example.ticketbackend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ticketbackend.entity.Sessions;
import com.example.ticketbackend.vo.GetSessionsDateVo;

@Repository
public interface SessionsDao extends JpaRepository<Sessions, Integer>{
	
	@Query(value = "select * from Sessions where (commodity_codename = :codename) and (show_datetime = :showDateTime)",nativeQuery = true)
	public int getSessionNum(@Param("codename") String codename,@Param("showDateTime") LocalDateTime showDateTime);
	
	@Query(value = "select * from Sessions where (commodity_codename = :codename) and (show_datetime = :showDateTime)",nativeQuery = true)
	public Sessions getSessionDataByCodeNameAndShowDateTime(@Param("codename") String codename,@Param("showDateTime") LocalDateTime showDateTime);
	
	public List<Sessions> findByCommodityCodenameOrderByShowDateTime(String codeName);
	
	public List<Sessions> findByCommodityCodenameOrderByStartSellDateTime(String codeName);
		
	public Sessions findByCommodityCodenameAndNum(String codeName,int num);
	
	@Transactional
	@Modifying
	@Query("delete from Sessions where (num = :num)")
	public void deleteSessionsByNum(@Param("num")int num);
	
	
	@Query("select new com.example.ticketbackend.vo.GetSessionsDateVo(S1.num , S1.commodityCodename , S1.showDateTime , S1.startSellDateTime , S1.endSellDateTime , S2.area ,count(S2.num) as remainingTicket , S2.price) "
			+ " FROM Sessions as S1 "
			+ " inner join Seat as S2 on S1.num = S2.num"
			+ " where (S1.commodityCodename = :codeName)"
			+ " and S2.buyNum is null "
			+ " group by S2.area,S2.price,S1.num order by price desc ")
	public List<GetSessionsDateVo> getSessionsData(@Param("codeName")String codeName);
	
	
	

}
