package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Karta;
import com.example.demo.repositories.KartaRepozitorijum;

@Service
public class KartaServis {

	@Autowired
	KartaRepozitorijum kartaRepo;

	public List<Karta> findAll() {
		return kartaRepo.findAll();	
	}

	public Karta getOne(Long id) {
		return kartaRepo.getOne(id);
	}

	public Karta save(Karta karta) {
		return kartaRepo.save(karta);
	}

	public void delete(Long id) {
		kartaRepo.deleteById(id);
	}
	
}
