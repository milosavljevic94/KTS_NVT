package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KorisnikDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Zaposleni;
import com.example.demo.services.ZaposleniServis;

@RestController
@RequestMapping(value = "api/zaposleni")
public class ZaposleniKontroler {
	@Autowired
	ZaposleniServis zaposleniServis;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getZaposleni(@PathVariable Long id) {
		Zaposleni zap = zaposleniServis.getOne(id);
		if (zap == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new KorisnikDTO(zap), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> obrisiZaposlenog(@RequestParam("id") Long id) {
		Zaposleni zap = zaposleniServis.getOne(id);
		if (zap == null)
			throw new ResourceNotFoundException();
		zaposleniServis.delete(zap);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> sviZaposleni() {
        List<KorisnikDTO> zaposleniDTO = this.zaposleniServis.sviZaposleni();
        if(zaposleniDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(zaposleniDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> izmeniZaposlenog(@RequestBody KorisnikDTO korDTO) {
		KorisnikDTO zap = zaposleniServis.izmeniZaposlenog(korDTO);
		if (zap == null)
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
}
