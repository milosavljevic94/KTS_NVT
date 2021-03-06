package com.example.demo.model;

import java.io.Serializable;

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
	
	//@Column(nullable = false)
	private Long idTrenutnoStajaliste;
	
	//@Column(nullable = false)
	private Long idLinija;
	
	@Enumerated(EnumType.STRING)
	private TipVozila tip;
	
	public Vozilo() {
		super();
	}
	
	public Vozilo(Long id, long Idstajaliste, Long IdLinije, TipVozila tip) {
		super();
		this.id = id;
		this.idTrenutnoStajaliste = Idstajaliste;
		this.idLinija = IdLinije;
		this.tip = tip;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStajaliste() {
		return idTrenutnoStajaliste;
	}
	public void setStajaliste(Long Idstajaliste) {
		this.idTrenutnoStajaliste = Idstajaliste;
	}
	public Long getLinija() {
		return idLinija;
	}
	public void setLinija(Long idLinija) {
		this.idLinija = idLinija;
	}
	public TipVozila getTip() {
		return tip;
	}
	public void setTip(TipVozila tip) {
		this.tip = tip;
	}
	
	@Override
	public String toString() {
		return "Vozilo [id=" + id + ", stajaliste=" + idTrenutnoStajaliste + ", linija=" + idLinija + ", tip=" + tip + "]";
	}
}
