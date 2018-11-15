package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Authority;

public interface AuthorityRepozitorijum extends JpaRepository<Authority, Long> {
	
	@Query("SELECT a FROM Authority a WHERE a.naziv = :name")
    Authority findByName(@Param("name") String name);
}
