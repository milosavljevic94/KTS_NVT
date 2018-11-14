package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vozilo")
public class Vozilo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Stajaliste stajaliste;
	
	@Column(nullable = false)
	private Linija linija;
	
	@Enumerated(EnumType.STRING)
	private TipVozila tip;
	
	public Vozilo() {
		super();
	}
	
	public Vozilo(Long id, Stajaliste stajaliste, Linija linija, TipVozila tip) {
		super();
		this.id = id;
		this.stajaliste = stajaliste;
		this.linija = linija;
		this.tip = tip;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	@Override
	public String toString() {
		return "Vozilo [id=" + id + ", stajaliste=" + stajaliste + ", linija=" + linija + ", tip=" + tip + "]";
	}
}
