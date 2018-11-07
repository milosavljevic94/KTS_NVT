package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Administrator;
import com.example.demo.repositories.AdministratorRepozitorijum;

public class AdministratorServis {
	@Autowired
	AdministratorRepozitorijum adminRepo;

	public List<Administrator> findAll() {
		return adminRepo.findAll();
	}

	public Administrator getOne(Long id) {
		return adminRepo.getOne(id);
	}

	public Administrator save(Administrator admin) {
		return adminRepo.save(admin);
	}

	public void delete(Administrator admin) {
		adminRepo.delete(admin);
	}

}
