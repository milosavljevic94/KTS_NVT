package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KartaDTO;
import com.example.demo.dto.PolazakDTO;
import com.example.demo.dto.StajalisteDTO;
import com.example.demo.dto.VoziloDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Karta;
import com.example.demo.model.Linija;
import com.example.demo.model.Polazak;
import com.example.demo.model.Stajaliste;
import com.example.demo.model.Vozilo;
import com.example.demo.services.VoziloServis;


@RestController
@RequestMapping(value = "api/vozilo")
public class VoziloKontroler {
	
	
	@Autowired
	VoziloServis voziloServis;
	
	//Get all of entity vozilo.
	@GetMapping("/all")
	public ResponseEntity<List<VoziloDTO>> getAll(){
		
		List<Vozilo> vozila = voziloServis.findAll();
		
		//convert vozilo in DTOVozlo.
		List<VoziloDTO> vozilaDTO = new ArrayList<>();
			for (Vozilo voz : vozila) {
				vozilaDTO.add(new VoziloDTO(voz));
			}
		
		return new ResponseEntity<>(vozilaDTO, HttpStatus.OK);
	}
	
	
	//Get vozilo.
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VoziloDTO> getVozilo(@PathVariable Long id){
		
		Vozilo vozilo = voziloServis.getOne(id);
		
		if(vozilo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.OK);
		}
	}

	
	//Create new vozilo.
	@RequestMapping(method = RequestMethod.POST, consumes = "aplication/json")
	public ResponseEntity<VoziloDTO> newVozilo(@RequestBody VoziloDTO voziloDto){
			
		Vozilo vozilo = new Vozilo();
		
		
		vozilo.setId(voziloDto.getId());
		
		
		//StajalisteDTO
		Stajaliste stajaliste = new Stajaliste();
		
		stajaliste.setId(voziloDto.getStajaliste().getId());
		stajaliste.setNaziv(voziloDto.getStajaliste().getNaziv());
		stajaliste.setLokacijaX(voziloDto.getStajaliste().getLokacijaX());
		stajaliste.setLokacijaY(voziloDto.getStajaliste().getLokacijaY());
		stajaliste.setAdresa(voziloDto.getStajaliste().getAdresa());
		
		vozilo.setStajaliste(stajaliste);
		
		
		//LinijaDTO
		Linija linija = new Linija();
		
		linija.setId(voziloDto.getLinija().getId());
		linija.setBroj(voziloDto.getLinija().getBroj());
		linija.setNaziv(voziloDto.getLinija().getNaziv());
		
		
		List<Stajaliste> stajalista = new ArrayList<Stajaliste>();
			for(StajalisteDTO stajalistaDTO : voziloDto.getLinija().getStajalista()) {
				Stajaliste stajaliste2 = new Stajaliste();
				stajaliste2.setId(stajalistaDTO.getId());
				stajaliste2.setNaziv(stajalistaDTO.getNaziv());
				stajaliste2.setLokacijaX(stajalistaDTO.getLokacijaX());
				stajaliste2.setLokacijaY(stajalistaDTO.getLokacijaY());
				stajaliste2.setAdresa(stajalistaDTO.getAdresa());
				stajalista.add(stajaliste2);
			}
		linija.setStajalista(stajalista);
		
		//PolasciDTO
		List<Polazak> polasci = new ArrayList<Polazak>();
		for (PolazakDTO polazakDto : voziloDto.getLinija().getPolasci()) {
			Polazak polazak = new Polazak();
			polazak.setId(polazakDto.getId());
			polazak.setDan(polazakDto.getDan());
			polazak.setVreme(polazakDto.getVreme());
			polasci.add(polazak);
		}
		linija.setPolasci(polasci);
		linija.setTip(voziloDto.getLinija().getTip());
		
		vozilo.setLinija(linija);
		vozilo.setTip(voziloDto.getTip());
			
		vozilo = voziloServis.save(vozilo);
		
		return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.CREATED);
	}
	
	
	
	//Update vozilo.
	@RequestMapping(method = RequestMethod.PUT, consumes = "aplication/json")
	public ResponseEntity<VoziloDTO> updateVozilo(@RequestBody VoziloDTO voziloDto){
			
		Vozilo vozilo = voziloServis.getOne(voziloDto.getId());
		
		if(vozilo == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		vozilo.setId(voziloDto.getId());
		
		
		//StajalisteDTO
		Stajaliste stajaliste = new Stajaliste();
		
		stajaliste.setId(voziloDto.getStajaliste().getId());
		stajaliste.setNaziv(voziloDto.getStajaliste().getNaziv());
		stajaliste.setLokacijaX(voziloDto.getStajaliste().getLokacijaX());
		stajaliste.setLokacijaY(voziloDto.getStajaliste().getLokacijaY());
		stajaliste.setAdresa(voziloDto.getStajaliste().getAdresa());
		
		vozilo.setStajaliste(stajaliste);
		
		
		//LinijaDTO
		Linija linija = new Linija();
		
		linija.setId(voziloDto.getLinija().getId());
		linija.setBroj(voziloDto.getLinija().getBroj());
		linija.setNaziv(voziloDto.getLinija().getNaziv());
		
		
		List<Stajaliste> stajalista = new ArrayList<Stajaliste>();
			for(StajalisteDTO stajalistaDTO : voziloDto.getLinija().getStajalista()) {
				Stajaliste stajaliste2 = new Stajaliste();
				stajaliste2.setId(stajalistaDTO.getId());
				stajaliste2.setNaziv(stajalistaDTO.getNaziv());
				stajaliste2.setLokacijaX(stajalistaDTO.getLokacijaX());
				stajaliste2.setLokacijaY(stajalistaDTO.getLokacijaY());
				stajaliste2.setAdresa(stajalistaDTO.getAdresa());
				stajalista.add(stajaliste2);
			}
		linija.setStajalista(stajalista);
		
		//PolasciDTO
		List<Polazak> polasci = new ArrayList<Polazak>();
		for (PolazakDTO polazakDto : voziloDto.getLinija().getPolasci()) {
			Polazak polazak = new Polazak();
			polazak.setId(polazakDto.getId());
			polazak.setDan(polazakDto.getDan());
			polazak.setVreme(polazakDto.getVreme());
			polasci.add(polazak);
		}
		linija.setPolasci(polasci);
		linija.setTip(voziloDto.getLinija().getTip());
		
		vozilo.setLinija(linija);
		vozilo.setTip(voziloDto.getTip());
			
		vozilo = voziloServis.save(vozilo);
		
		return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.OK);
	}
	
	
	
	
	//Delete vozilo.
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVozilo(@PathVariable Long id){
		Vozilo vozilo = voziloServis.getOne(id);
		if (vozilo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			voziloServis.delete(vozilo);
			return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
