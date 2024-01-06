package com.example.ticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbackend.entity.Organizer;

@Repository
public interface OrganizerDao extends JpaRepository<Organizer,String> {

}
