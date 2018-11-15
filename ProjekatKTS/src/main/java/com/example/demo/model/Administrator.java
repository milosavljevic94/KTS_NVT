package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administratori")
public class Administrator extends Korisnik {
	
	public Administrator() {
		super();
	}
	
	public Administrator(Long id, String ime, String prezime, String email, String lozinka) {
		super(id, ime, prezime, email, lozinka);
	}

}
