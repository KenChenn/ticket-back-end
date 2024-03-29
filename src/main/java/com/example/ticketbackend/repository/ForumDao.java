package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ticketbackend.entity.Forum;

@Repository
public interface ForumDao extends JpaRepository<Forum, Integer>{
	
	@Query(value = "select * from Forum where (commodity_codename "
			+ " = :name)", nativeQuery = true)
	public List<Forum> getComments(@Param("name") String name);
	
	@Transactional
	@Modifying
	@Query("update Forum set commenter = :newName where commenter = :oldName")
	public void updateCommenter(@Param("oldName")String oldName,@Param("newName")String newName);
	
}
