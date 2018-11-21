package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Linija;

@Repository
public interface LinijaRepozitorijum extends JpaRepository<Linija, Long> {
	
}
