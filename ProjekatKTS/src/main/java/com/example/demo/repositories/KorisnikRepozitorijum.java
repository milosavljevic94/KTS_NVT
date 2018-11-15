package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Korisnik;

public interface KorisnikRepozitorijum extends JpaRepository<Korisnik, Long> {

	@Query("SELECT k FROM Korisnik k WHERE k.email = :username")
	Korisnik findByUsername(@Param("username") String username);
}
