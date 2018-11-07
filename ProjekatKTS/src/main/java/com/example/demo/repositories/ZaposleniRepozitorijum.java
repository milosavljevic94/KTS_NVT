package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Zaposleni;

@Repository
public interface ZaposleniRepozitorijum extends JpaRepository<Zaposleni, Long> {

}
