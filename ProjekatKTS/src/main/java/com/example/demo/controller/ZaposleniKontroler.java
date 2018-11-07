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
import com.example.demo.model.Zaposleni;
import com.example.demo.services.ZaposleniServis;

@RestController
@RequestMapping(value = "api/admin")
public class ZaposleniKontroler {
	@Autowired
	ZaposleniServis zaposleniServis;
	
	@GetMapping
	public ResponseEntity<List<Zaposleni>> sviZaposleni() {
		return new ResponseEntity<List<Zaposleni>>(zaposleniServis.findAll(), HttpStatus.OK);
	}

	@DeleteMapping(value = "obrisizaposlenog/{id}")
	public ResponseEntity<Void> obrisiZaposlenog(@RequestParam("id") Long id) {
		Zaposleni zap = zaposleniServis.getOne(id);
		if (zap == null)
			throw new ResourceNotFoundException();
		zaposleniServis.delete(zap);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
