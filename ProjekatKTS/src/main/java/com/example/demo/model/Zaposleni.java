package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zaposleni")
public class Zaposleni extends Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ime;
	private String prezime;
	private TipKorisnika tip;
	private String email;
	private String lozinka;

	public Zaposleni() {
		super();
	}

	public Zaposleni(Long id, String ime, String prezime, TipKorisnika tip, String email, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.tip = TipKorisnika.zaposleni;
		this.email = email;
		this.lozinka = lozinka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public TipKorisnika getTip() {
		return tip;
	}

	public void setTip(TipKorisnika tip) {
		this.tip = tip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	@Override
	public String toString() {
		return "Zaposleni [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", tip=" + tip + ", email="
				+ email + ", lozinka=" + lozinka + "]";
	}

}
