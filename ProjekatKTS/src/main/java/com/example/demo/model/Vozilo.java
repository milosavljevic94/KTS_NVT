package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vozilo")
public class Vozilo implements Serializable {
	@Id
	@Column(name = "vozilo_id")
	String id;
	
	@Column(nullable = false)
	Stajaliste stajaliste;
	
	@Column(nullable = false)
	Linija linija;
	
	@Column(nullable = false)
	TipVozila tip;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Stajaliste getStajaliste() {
		return stajaliste;
	}
	public void setStajaliste(Stajaliste stajaliste) {
		this.stajaliste = stajaliste;
	}
	public Linija getLinija() {
		return linija;
	}
	public void setLinija(Linija linija) {
		this.linija = linija;
	}
	public TipVozila getTip() {
		return tip;
	}
	public void setTip(TipVozila tip) {
		this.tip = tip;
	}
}
