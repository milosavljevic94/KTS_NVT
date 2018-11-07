package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "zaposleni")
public class Zaposleni extends Korisnik {
	
	private static final long serialVersionUID = -3733047763904770521L;

	public Zaposleni() {
		super();
	}

	public Zaposleni(Long id, String ime, String prezime, TipKorisnika tip, String email, String lozinka) {
		super(id, ime, prezime, tip, email, lozinka);
	}

}
