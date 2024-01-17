package com.example.ticketbackend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Buy;
import com.example.ticketbackend.vo.BuyDataVo;

@Repository
public interface BuyDao extends JpaRepository<Buy, String>{
	
 public Buy findByBuyNum(String buyNum);

 
 
// @Query("select new com.example.ticketbackend.vo.BuyDataVo(B.buyNum,B.sessionsNum,B.payFinalDate,B.payment,S.commodityCodename,S.showDateTime,S.endSellDateTime,C.name,C.place,C.keyvisualImg) "
//			+ " from Buy as B join Sessions as S join Commodity as C "
//			+ " on B.sessionsNum = S.num and S.commodityCodename = C.codename where (B.buyAccount = :account)")
 @Query("select new com.example.ticketbackend.vo.BuyDataVo(B.buyNum,B.sessionsNum,B.payFinalDate,B.payment,S.commodityCodename,S.showDateTime,S.endSellDateTime,C.name,C.place,C.keyvisualImg) "
			+ " from Buy as B "
			+ " inner join Sessions as S on B.sessionsNum = S.num"
			+ " inner join Commodity as C on S.commodityCodename = C.codename"
			+ " where (B.buyAccount = :account)")
 public List<BuyDataVo> getOrderList(@Param("account")String account);
}
