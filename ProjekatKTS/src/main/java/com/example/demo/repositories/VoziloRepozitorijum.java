package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vozilo;

@Repository
public interface VoziloRepozitorijum extends JpaRepository<Vozilo, Long> {
	
}
