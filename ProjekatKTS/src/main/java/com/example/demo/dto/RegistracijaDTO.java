package com.example.demo.dto;

public class RegistracijaDTO {
	
    private String email;
    private String lozinka;
    private String tip;
    private String ime;
    private String prezime;
    
    public RegistracijaDTO () {};

	public RegistracijaDTO(String email, String lozinka, String tip, String ime, String prezime) {
		super();
		this.email = email;
		this.lozinka = lozinka;
		this.tip = tip;
		this.ime = ime;
		this.prezime = prezime;
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
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

}
