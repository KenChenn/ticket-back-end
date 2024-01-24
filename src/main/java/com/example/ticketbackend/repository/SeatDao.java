package com.example.ticketbackend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.entity.SeatId;
import com.example.ticketbackend.vo.GetRemainingTicketsVo;
import com.example.ticketbackend.vo.GetSeatDataVo;
import com.example.ticketbackend.vo.GetSessionsDateVo;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SeatReq;
import com.example.ticketbackend.vo.TicketJoinVo;

@Repository
public interface SeatDao extends JpaRepository<Seat, SeatId> {

	public default void insertSeat(Connection connection, List<Seat> data) {
		String sql = "INSERT INTO seat(num,area,seat_num,price) VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			for (Seat seat : data) {
				pstmt.setInt(1, seat.getNum());
				pstmt.setString(2, seat.getArea());
				pstmt.setInt(3, seat.getSeatNum());
				pstmt.setInt(4, seat.getPrice());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {

			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e3) {
					}
				}

				if (connection != null) {
					try {
						connection.setAutoCommit(true);
						connection.close();
					} catch (SQLException e4) {
					}
				}
			}
		}

	}

//	@Query(value = "select * from Seat as seat join Sessions as sessions on seat.num = sessions.num where (seat.num = :num) and (seat.area = :area) and (seat.buy_num is null) LIMIT :buyPieces")
	@Query("select new com.example.ticketbackend.vo.TicketJoinVo(S1.num,S1.area,S1.seatNum,S1.price,S1.buyNum,S1.version,S2.commodityCodename,S2.startSellDateTime,S2.endSellDateTime) "
			+ " from Seat as S1 join Sessions as S2 on S1.num = S2.num "
			+ " where (S1.num = :num) and (S1.area = :area) and (S1.buyNum is null) ")
	public List<TicketJoinVo> getTickets(@Param("num") int num, @Param("area") String area, Pageable pageable);

	@Query("select new com.example.ticketbackend.vo.GetSeatDataVo(S1.num,S1.area,S1.seatNum,S1.price,S1.buyNum,S1.version,B.buyAccount,B.payFinalDate,B.payment,S2.startSellDateTime,S2.endSellDateTime) "
			+ " from Seat as S1 " + " inner join Buy as B on S1.buyNum = B.buyNum "
			+ " inner join Sessions as S2 on B.sessionsNum = S2.num" + " where (S1.buyNum = :buyNum)")
	public List<GetSeatDataVo> getSeatDataByBuyNum(@Param("buyNum") String buyNum);

	@Query("select new com.example.ticketbackend.vo.SeatReq(num,area,count(seatNum) as maxSeatNum,price)"
			+ "FROM Seat where(num=:num) group by area,price")
	public List<SeatReq> gettotalSeatDataByNum(@Param("num") int num);
	
	@Transactional
	@Modifying
	@Query("delete from Seat where (num = :num)")
	public void deleteSeatByNum(@Param("num")int num);
	
	

	@Query("select new com.example.ticketbackend.vo.GetRemainingTicketsVo(S1.num , S1.commodityCodename , S1.showDateTime , S1.startSellDateTime , S1.endSellDateTime , S2.area ,COALESCE(SUM(CASE WHEN S2.buyNum IS NULL THEN 1 ELSE 0 END), 0) as remainingTicket , S2.price) "
			+ " FROM Sessions as S1 "
			+ " inner join Seat as S2 on S1.num = S2.num"
			+ " where (S2.num = :num)"
			+ " group by S2.area,S2.price,S1.num order by price desc")
	public List<GetRemainingTicketsVo> getRemainingTickets(@Param("num")int num);
	
	@Transactional
	@Modifying
	@Query("update Seat as S set S.buyNum = null "
			+ " where S.buyNum "
			+ " in (select B.buyNum from Buy as B where (B.payment = false) and (B.payFinalDate < now()))")
	public void checkPayment();
	
	public List<Seat> findByBuyNumOrderBySeatNum(String buyNum);

}
