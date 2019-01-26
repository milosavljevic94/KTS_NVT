package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Stajaliste;
import com.example.demo.model.Vozilo;
import com.example.demo.repositories.StajalisteRepozitorijum;

/**
 * @author Nemanja
 * Nov 22, 2018
 */

@Service
public class StajalisteServis {

	@Autowired
	StajalisteRepozitorijum stajalisteRep;
	
	public List<Stajaliste> getAll(){
		return stajalisteRep.findAll();
	}
	
	public Stajaliste findOne(Long id) {
		return stajalisteRep.findById(id).orElse(null);
	}
	
	public Stajaliste getOne(Long id) {
		return stajalisteRep.getOne(id);
	}
	
	public Stajaliste save(Stajaliste s) {
		return stajalisteRep.save(s);
	}
	
	public void delete(Long id) {
		stajalisteRep.deleteById(id);
	}
}
