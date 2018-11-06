package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Linija {
	@Id
	@Column(name = "broj_linije")
	String broj;
	@Column(nullable = false)
	String naziv;
	@ManyToMany
	List<Stajaliste> stajalista;
	@Column(name = "polasciRadnidan")
	List<String> polasciRadniDan;
	@Column(name = "polasciSubota")
	List<String> polasciSubota;
	@Column(name = "polasciNedelja")
	List<String> polasciNedelja;
	TipVozila tip;
	
	
	public Linija(String broj, String naziv, List<Stajaliste> stajalista, List<String> polasciRadniDan,
			List<String> polasciSubota, List<String> polasciNedelja, TipVozila tip) {
		super();
		this.broj = broj;
		this.naziv = naziv;
		this.stajalista = stajalista;
		this.polasciRadniDan = polasciRadniDan;
		this.polasciSubota = polasciSubota;
		this.polasciNedelja = polasciNedelja;
		this.tip = tip;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Stajaliste> getStajalista() {
		return stajalista;
	}
	public void setStajalista(List<Stajaliste> stajalista) {
		this.stajalista = stajalista;
	}
	public List<String> getPolasciRadniDan() {
		return polasciRadniDan;
	}
	public void setPolasciRadniDan(List<String> polasciRadniDan) {
		this.polasciRadniDan = polasciRadniDan;
	}
	public List<String> getPolasciSubota() {
		return polasciSubota;
	}
	public void setPolasciSubota(List<String> polasciSubota) {
		this.polasciSubota = polasciSubota;
	}
	public List<String> getPolasciNedelja() {
		return polasciNedelja;
	}
	public void setPolasciNedelja(List<String> polasciNedelja) {
		this.polasciNedelja = polasciNedelja;
	}
	public TipVozila getTip() {
		return tip;
	}
	public void setTip(TipVozila tip) {
		this.tip = tip;
	}
	@Override
	public String toString() {
		return "Linija [broj=" + broj + ", naziv=" + naziv + ", stajalista=" + stajalista + ", polasciRadniDan="
				+ polasciRadniDan + ", polasciSubota=" + polasciSubota + ", polasciNedelja=" + polasciNedelja + ", tip="
				+ tip + "]";
	}
	
}
