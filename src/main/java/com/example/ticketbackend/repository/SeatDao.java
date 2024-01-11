package com.example.ticketbackend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.entity.SeatId;
import com.example.ticketbackend.vo.RtnCodeRes;

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

}
