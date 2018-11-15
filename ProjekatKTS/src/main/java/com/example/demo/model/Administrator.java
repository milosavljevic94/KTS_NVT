package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.dto.RegistracijaDTO;

@Entity
@Table(name = "administratori")
public class Administrator extends Korisnik {
	
	public Administrator() {
		super();
	}
	
	public Administrator(String ime, String prezime, String email, String lozinka) {
		super(ime, prezime, email, lozinka);
	}
	
	public Administrator(Korisnik kor) {
		this.setEmail(kor.getEmail());
		this.setLozinka(kor.getLozinka());
		this.setIme(kor.getIme());
		this.setPrezime(kor.getPrezime());
		this.setKorisnikAuthorities(kor.getKorisnikAuthorities());
	}
	
	public Administrator(RegistracijaDTO regDTO) {
		this.setEmail(regDTO.getEmail());
		this.setLozinka(regDTO.getLozinka());
		this.setIme(regDTO.getIme());
		this.setPrezime(regDTO.getPrezime());
	}

}
