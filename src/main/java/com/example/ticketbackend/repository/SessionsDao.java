package com.example.ticketbackend.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Sessions;

@Repository
public interface SessionsDao extends JpaRepository<Sessions, Integer>{
	
	@Query(value = "select * from Sessions where (commodity_codename = :codename) and (show_datetime = :showDateTime)",nativeQuery = true)
	public int getSessionNum(@Param("codename") String codename,@Param("showDateTime") LocalDateTime showDateTime);

}
