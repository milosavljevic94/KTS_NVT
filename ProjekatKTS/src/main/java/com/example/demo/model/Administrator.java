package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administratori")
public class Administrator extends Korisnik {

	private static final long serialVersionUID = -1405732400258079667L;
	
	public Administrator() {
		super();
	}
	
	public Administrator(Long id, String ime, String prezime, TipKorisnika tip, String email, String lozinka) {
		super(id, ime, prezime, tip, email, lozinka);
	}

}
