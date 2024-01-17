package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Forum;

@Repository
public interface ForumDao extends JpaRepository<Forum, Integer>{
	
	@Query(value = "select * from Forum where (commodity_codename "
			+ " = :name)", nativeQuery = true)
	public List<Forum> getComments(@Param("name") String name);

	
	
}
