package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Vozilo;
import com.example.demo.services.VoziloServis;

@RestController
@RequestMapping(value = "api/vozilo")
public class VoziloKontroler {
	@Autowired
	VoziloServis voziloServis;
	
	@GetMapping
	public ResponseEntity<List<Vozilo>> getAll(){
		return new ResponseEntity<List<Vozilo>>(voziloServis.findAll(), HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<Void> deleteVozilo(@RequestParam("id") String id){
		Vozilo vozilo1 = voziloServis.getOne(id);
		if (vozilo1 == null) {
			throw new ResourceNotFoundException();
		}
		voziloServis.delete(vozilo1);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
