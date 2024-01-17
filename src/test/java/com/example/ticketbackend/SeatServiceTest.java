package com.example.ticketbackend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketbackend.entity.Seat;
import com.example.ticketbackend.repository.SeatDao;
import com.example.ticketbackend.service.ifs.SeatService;


@SpringBootTest
public class SeatServiceTest {
	

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private SeatService seatService;
	
	
	public List<Seat> createDate(){
		List<Seat> data = new ArrayList<Seat>();
		
		for (int i =0 ; i<=50000;i++) {
			data.add(i, new Seat(123,"A2",i,4000));
		}
		return data;
	}
	
	
	@Test
	public void jdbcInto() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO seat(num,area,seat_num,price) VALUES (?,?,?,?)";
		List<Seat> seats = createDate();
		long start = System.currentTimeMillis();
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			pstmt = connection.prepareStatement(sql);
			for(Seat seat : seats) {
				pstmt.setInt(1, seat.getNum());
				pstmt.setString(2, seat.getArea());
				pstmt.setInt(3, seat.getSeatNum());
				pstmt.setInt(4, seat.getPrice());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			connection.commit();
			long end = System.currentTimeMillis();
			String result = String.format("Total time: %d ²@¬í", (end - start));
			System.out.println(result);


		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				
			}
			finally {
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
	
	@Test
	public void jpaInto() {
//		seatService.insertSeat(112, "A2", 500, 4000);
//		seatService.insertSeat(new Seat(123,"A",1,4000));
		
//		List<Seat> seats = createDate();
//		long start = System.currentTimeMillis();
//		seatDao.saveAll(seats);
//		long end = System.currentTimeMillis();
//		String result = String.format("Total time: %d ²@¬í", (end - start));
//		System.out.println(result);
	}
}
