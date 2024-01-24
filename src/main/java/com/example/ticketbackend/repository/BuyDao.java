package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ticketbackend.entity.Buy;
import com.example.ticketbackend.vo.BuyDataVo;
import com.example.ticketbackend.vo.CreateTicketVo;

@Repository
public interface BuyDao extends JpaRepository<Buy, String> {

	public Buy findByBuyNum(String buyNum);

// @Query("select new com.example.ticketbackend.vo.BuyDataVo(B.buyNum,B.sessionsNum,B.payFinalDate,B.payment,S.commodityCodename,S.showDateTime,S.endSellDateTime,C.name,C.place,C.keyvisualImg) "
//			+ " from Buy as B join Sessions as S join Commodity as C "
//			+ " on B.sessionsNum = S.num and S.commodityCodename = C.codename where (B.buyAccount = :account)")
	@Query("select new com.example.ticketbackend.vo.BuyDataVo(B.buyNum,B.sessionsNum,B.payFinalDate,B.payment,S.commodityCodename,S.showDateTime,S.startSellDateTime,S.endSellDateTime,C.name,C.place,C.keyvisualImg) "
			+ " from Buy as B inner join Sessions as S on B.sessionsNum = S.num"
			+ " inner join Commodity as C on S.commodityCodename = C.codename"
			+ " where (B.buyAccount = :account) and (S.showDateTime > now()) order by S.showDateTime")
	public List<BuyDataVo> getOrderList(@Param("account") String account);
	
	
	@Transactional
	@Query("select new com.example.ticketbackend.vo.CreateTicketVo(B.buyNum,B.sessionsNum,B.buyAccount,B.payment,S.area,S.seatNum,U.realname,U.username) "
			+ " from Buy as B inner join Seat as S on B.buyNum = S.buyNum "
			+ " inner join User as U on B.buyAccount = U.account "
			+ " where (B.buyNum = :buyNum) and (B.payment is true)")
	public List<CreateTicketVo> getCreateTicketData(@Param("buyNum") String buyNum);
}
