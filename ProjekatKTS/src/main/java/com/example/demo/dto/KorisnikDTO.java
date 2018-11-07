package com.example.demo.dto;

import com.example.demo.model.Korisnik;
import com.example.demo.model.TipKorisnika;

public class KorisnikDTO {
	
	private Long id;
	private String ime;
	private String prezime;
	private TipKorisnika tip;
	private String email;
	private String lozinka;
	
	public KorisnikDTO (Korisnik kor) {
		this.id = kor.getId();
		this.ime = kor.getIme();
		this.prezime = kor.getPrezime();
		this.tip = kor.getTip();
		this.email = kor.getEmail();
		this.lozinka = kor.getLozinka();
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
}
