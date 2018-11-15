package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.dto.RegistracijaDTO;

@Entity
@Table(name = "zaposleni")
public class Zaposleni extends Korisnik {

	public Zaposleni() {
		super();
	}

	public Zaposleni(String ime, String prezime, String email, String lozinka) {
		super(ime, prezime, email, lozinka);
	}
	
	public Zaposleni(Korisnik kor) {
		this.setEmail(kor.getEmail());
		this.setLozinka(kor.getLozinka());
		this.setIme(kor.getIme());
		this.setPrezime(kor.getPrezime());
		this.setKorisnikAuthorities(kor.getKorisnikAuthorities());
	}
	
	public Zaposleni(RegistracijaDTO regDTO) {
		this.setEmail(regDTO.getEmail());
		this.setLozinka(regDTO.getLozinka());
		this.setIme(regDTO.getIme());
		this.setPrezime(regDTO.getPrezime());
	}

}
