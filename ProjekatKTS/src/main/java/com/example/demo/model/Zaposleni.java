package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "zaposleni")
public class Zaposleni extends Korisnik {

	public Zaposleni() {
		super();
	}

	public Zaposleni(Long id, String ime, String prezime, String email, String lozinka) {
		super(id, ime, prezime, email, lozinka);
	}

}
