package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.model.Authority;
import com.example.demo.repositories.AuthorityRepozitorijum;
import com.example.demo.repositories.KartaRepozitorijum;

public class AuthorityServis {

	@Autowired
	AuthorityRepozitorijum authorityRepo;
	
	public Authority findByName(String name) {
		return authorityRepo.findByName(name);
	}

}
