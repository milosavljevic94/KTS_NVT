package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Karta;

@Repository
public interface KartaRepozitorijum extends JpaRepository<Karta, Long> {
	
}
