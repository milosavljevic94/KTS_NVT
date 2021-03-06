package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KartaDTO;
import com.example.demo.model.Karta;
import com.example.demo.services.KartaServis;



@RestController
@RequestMapping(value = "api/karta")
public class KartaKontroler {

	@Autowired
	KartaServis kartaServis;
	
	//vrati sve karte
	@GetMapping("/all")
	public ResponseEntity<List<KartaDTO>> getAll(){
		
		List<Karta> karte = kartaServis.findAll();
		//konvertuj karte u DTO
		List<KartaDTO> karteDTO = new ArrayList<>();
		for (Karta k : karte) {
			karteDTO.add(new KartaDTO(k));
		}
		return new ResponseEntity<>(karteDTO, HttpStatus.OK);
		
	}
	
	//nadji jednu kartu
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KartaDTO> getKarta(@PathVariable Long id){
		Karta karta = kartaServis.getOne(id);
		if(karta == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.OK);
	}
	
	//dodaj novu kartu
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<KartaDTO> saveKarta(@RequestBody KartaDTO kartaDTO){
		Karta karta = new Karta();
		karta.setId(kartaDTO.getId());
		karta.setTip(kartaDTO.getTip());
		karta.setAktivirana(kartaDTO.isAktivirana());
		karta.setVaziOd(kartaDTO.getVaziOd());
		karta.setVaziDo(kartaDTO.getVaziDo());
		karta.setCena(kartaDTO.getCena());
		karta.setVlasnik(kartaDTO.getVlasnik());
		
		karta = kartaServis.save(karta);
		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.CREATED);	
	}
	
	//Izmeni postojecu kartu
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<KartaDTO> updateKarta(@RequestBody KartaDTO kartaDTO){
		//karta mora postojati
		Karta karta = kartaServis.getOne(kartaDTO.getId()); 
		if (karta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		karta.setId(kartaDTO.getId());
		karta.setTip(kartaDTO.getTip());
		karta.setAktivirana(kartaDTO.isAktivirana());
		karta.setVaziOd(kartaDTO.getVaziOd());
		karta.setVaziDo(kartaDTO.getVaziDo());
		karta.setCena(kartaDTO.getCena());
		karta.setVlasnik(kartaDTO.getVlasnik());
		
		karta = kartaServis.save(karta);
		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.OK);	
	}
	
	
	//obrisi kartu
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKarta(@PathVariable Long id){
		Karta karta = kartaServis.getOne(id);
		if (karta != null){
			kartaServis.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
