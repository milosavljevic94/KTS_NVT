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

import com.example.demo.dto.LinijaDTO;
import com.example.demo.dto.PolazakDTO;
import com.example.demo.dto.StajalisteDTO;
import com.example.demo.model.Linija;
import com.example.demo.model.Polazak;
import com.example.demo.model.Stajaliste;
import com.example.demo.services.LinijaServis;
import com.example.demo.services.PolazakServis;
import com.example.demo.services.StajalisteServis;

@RestController
@RequestMapping(value = "api/linija")
public class LinijaKontroler {
	@Autowired
	LinijaServis linijaServis;
	
	@Autowired
	PolazakServis polazakServis;
	
	@Autowired
	StajalisteServis stajalisteServis;
	
	//vrati sve linije
	@GetMapping("/all")
	public ResponseEntity<List<LinijaDTO>> getAll(){
		
		List<Linija> linije = linijaServis.findAll();
		//konvertuj linije u DTO
		List<LinijaDTO> linijeDTO = new ArrayList<>();
		for (Linija lin : linije) {
			linijeDTO.add(new LinijaDTO(lin));
		}
		return new ResponseEntity<>(linijeDTO, HttpStatus.OK);
		
	}
	
	//nadji jednu liniju
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<LinijaDTO> getLinija(@PathVariable Long id){
		Linija linija = linijaServis.getOne(id);
		if(linija == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new LinijaDTO(linija), HttpStatus.OK);
	}
	
	//dodaj novu liniju
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<LinijaDTO> saveLinija(@RequestBody LinijaDTO linijaDTO){
		Linija linija = new Linija();
		linija.setId(linijaDTO.getId());
		linija.setBroj(linijaDTO.getBroj());
		linija.setNaziv(linijaDTO.getNaziv());
		
		//konvertovanje svih StajalisteDTO u Stajaliste
		List<Stajaliste> stajalista1 = new ArrayList<Stajaliste>();
		for(StajalisteDTO stajDTO : linijaDTO.getStajalista()) {
			Stajaliste staj = new Stajaliste();
			staj.setId(stajDTO.getId());
			staj.setNaziv(stajDTO.getNaziv());
			staj.setLokacijaX(stajDTO.getLokacijaX());
			staj.setLokacijaY(stajDTO.getLokacijaY());
			staj.setAdresa(stajDTO.getAdresa());
			stajalista1.add(staj);
		}
		linija.setStajalista(stajalista1);
		
		//konvertovanje svih PolazakDTO u Polazak
		List<Polazak> polasci1 = new ArrayList<Polazak>();
		for(PolazakDTO polDTO : linijaDTO.getPolasci()) {
			Polazak pol = new Polazak();
			pol.setId(polDTO.getId());
			pol.setDan(polDTO.getDan());
			pol.setVreme(polDTO.getVreme());
			polasci1.add(pol);
		}
		linija.setPolasci(polasci1);
		
		/*List<Stajaliste> stajalista1 = new ArrayList<Stajaliste>();
		for(StajalisteDTO stajDTO : linijaDTO.getStajalista()) {
			stajalista1.add(stajalisteServis.getOne(stajDTO.getId()));
		}
		
		linija.setStajalista(stajalista1);
		
		List<Polazak> polasci1 = new ArrayList<Polazak>();
		for(PolazakDTO polDTO : linijaDTO.getPolasci()) {
			polasci1.add(polazakServis.getOne(polDTO.getId()));
		}
		linija.setPolasci(polasci1);*/
		
		linija.setTip(linijaDTO.getTip());
		
		linija = linijaServis.save(linija);
		return new ResponseEntity<>(new LinijaDTO(linija), HttpStatus.CREATED);	
	}
	
	//Izmeni postojecu liniju
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<LinijaDTO> updateLinija(@RequestBody LinijaDTO linijaDTO){
		//linija mora postojati
		Linija linija = linijaServis.getOne(linijaDTO.getId()); 
		if (linija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		linija.setId(linijaDTO.getId());
		linija.setBroj(linijaDTO.getBroj());
		linija.setNaziv(linijaDTO.getNaziv());
		
		//konvertovanje svih StajalisteDTO u Stajaliste
		List<Stajaliste> stajalista1 = new ArrayList<Stajaliste>();
		for(StajalisteDTO stajDTO : linijaDTO.getStajalista()) {
			Stajaliste staj = new Stajaliste();
			staj.setId(stajDTO.getId());
			staj.setNaziv(stajDTO.getNaziv());
			staj.setLokacijaX(stajDTO.getLokacijaX());
			staj.setLokacijaY(stajDTO.getLokacijaY());
			staj.setAdresa(stajDTO.getAdresa());
			stajalista1.add(staj);
		}
		linija.setStajalista(stajalista1);
		
		//konvertovanje svih PolazakDTO u Polazak
		List<Polazak> polasci1 = new ArrayList<Polazak>();
		for(PolazakDTO polDTO : linijaDTO.getPolasci()) {
			Polazak pol = new Polazak();
			pol.setId(polDTO.getId());
			pol.setDan(polDTO.getDan());
			pol.setVreme(polDTO.getVreme());
			polasci1.add(pol);
		}
		linija.setPolasci(polasci1);
		linija.setTip(linijaDTO.getTip());
		
		linija = linijaServis.save(linija);
		return new ResponseEntity<>(new LinijaDTO(linija), HttpStatus.OK);	
	}
	
	
	//obrisi liniju
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLinija(@PathVariable Long id){
		Linija linija = linijaServis.getOne(id);
		if (linija != null){
			linijaServis.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*@GetMapping
	public ResponseEntity<List<Linija>> getAll(){
		return new ResponseEntity<List<Linija>>(linijaServis.findAll(), HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{broj}")
	public ResponseEntity<Void> deleteLinija(@RequestParam("broj") String broj){
		Linija linija1 = linijaServis.getOne(Long.parseLong(broj));
		if (linija1 == null) {
			throw new ResourceNotFoundException();
		}
		linijaServis.delete(linija1);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}*/

}
