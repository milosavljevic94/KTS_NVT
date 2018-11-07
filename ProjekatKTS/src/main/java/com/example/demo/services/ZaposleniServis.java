package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Zaposleni;
import com.example.demo.repositories.ZaposleniRepozitorijum;

public class ZaposleniServis {
	@Autowired
	ZaposleniRepozitorijum zaposleniRepo;

	public List<Zaposleni> findAll() {
		return zaposleniRepo.findAll();
	}

	public Zaposleni getOne(Long id) {
		return zaposleniRepo.getOne(id);
	}

	public Zaposleni save(Zaposleni zap) {
		return zaposleniRepo.save(zap);
	}

	public void delete(Zaposleni zap) {
		zaposleniRepo.delete(zap);
	}

}
