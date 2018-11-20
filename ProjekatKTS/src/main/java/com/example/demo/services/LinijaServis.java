package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Linija;
import com.example.demo.repositories.LinijaRepozitorijum;

@Service
public class LinijaServis {
	@Autowired
	LinijaRepozitorijum linijaRepo;

	public List<Linija> findAll() {
		return linijaRepo.findAll();	
	}

	public Linija getOne(Long broj) {
		return linijaRepo.getOne(broj);
	}

	public Linija save(Linija linija) {
		return linijaRepo.save(linija);
	}

	public void delete(Long id) {
		linijaRepo.deleteById(id);
		//linijaRepo.delete(linija);	
	}
		
		
}
