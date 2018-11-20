package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Polazak;
import com.example.demo.repositories.PolazakRepozitorijum;

@Service
public class PolazakServis {

	@Autowired
	PolazakRepozitorijum polazakRepo;

	public List<Polazak> findAll() {
		return polazakRepo.findAll();	
	}

	public Polazak getOne(Long id) {
		return polazakRepo.getOne(id);
	}

	public Polazak save(Polazak polazak) {
		return polazakRepo.save(polazak);
	}

	public void delete(Long id) {
		polazakRepo.deleteById(id);
		//linijaRepo.delete(linija);	
	}
	
}
