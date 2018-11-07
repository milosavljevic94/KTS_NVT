package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "karte")
public class Karta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private TipKarte tip;
	
	private boolean aktivirana;
	
	private Date vaziOd;
	
	private Date vaziDo;
	
	private int cena;
	
	private Korisnik vlasnik;

	public Karta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Karta(Long id, TipKarte tip, boolean aktivirana, Date vaziOd, Date vaziDo, int cena, Korisnik vlasnik) {
		super();
		this.id = id;
		this.tip = tip;
		this.aktivirana = aktivirana;
		this.vaziOd = vaziOd;
		this.vaziDo = vaziDo;
		this.cena = cena;
		this.vlasnik = vlasnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipKarte getTip() {
		return tip;
	}

	public void setTip(TipKarte tip) {
		this.tip = tip;
	}

	public boolean isAktivirana() {
		return aktivirana;
	}

	public void setAktivirana(boolean aktivirana) {
		this.aktivirana = aktivirana;
	}

	public Date getVaziOd() {
		return vaziOd;
	}

	public void setVaziOd(Date vaziOd) {
		this.vaziOd = vaziOd;
	}

	public Date getVaziDo() {
		return vaziDo;
	}

	public void setVaziDo(Date vaziDo) {
		this.vaziDo = vaziDo;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Korisnik getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Korisnik vlasnik) {
		this.vlasnik = vlasnik;
	}

	@Override
	public String toString() {
		return "Karta [id=" + id + ", tip=" + tip + ", aktivirana=" + aktivirana + ", vaziOd=" + vaziOd + ", vaziDo="
				+ vaziDo + ", cena=" + cena + ", vlasnik=" + vlasnik + "]";
	}
	
	
	
}
