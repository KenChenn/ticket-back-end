package com.example.ticketbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.ticketbackend.entity.Subscription;

public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {

	@Query(value = "SELECT * FROM Subscription where (account = :account)", nativeQuery = true)
	public List<Subscription> getSubscribeList(@Param("account")String account);

	public boolean existsByAccountAndSubscribe(String account,String subscribe);
	
	@Transactional
	@Modifying
	@Query("delete Subscription where (account = :account) and (subscribe = :subscribe)")
	public void delete(@Param("account")String account,@Param("subscribe")String subscribe);
	
	@Query("SELECT U.email from Subscription as S join User as U on S.account = U.account where (S.subscribe = :subscribe)")
	public String[] getSubscriberEmails(@Param("subscribe")String subscribe);
}
