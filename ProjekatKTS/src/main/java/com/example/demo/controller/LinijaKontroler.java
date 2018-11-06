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
import com.example.demo.model.Linija;
import com.example.demo.services.LinijaServis;

@RestController
@RequestMapping(value = "api/linija")
public class LinijaKontroler {
	@Autowired
	LinijaServis linijaServis;
	
	@GetMapping
	public ResponseEntity<List<Linija>> getAll(){
		return new ResponseEntity<List<Linija>>(linijaServis.findAll(), HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{broj}")
	public ResponseEntity<Void> deleteLinija(@RequestParam("broj") String broj){
		Linija linija1 = linijaServis.getOne(broj);
		if (linija1 == null) {
			throw new ResourceNotFoundException();
		}
		linijaServis.delete(linija1);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
