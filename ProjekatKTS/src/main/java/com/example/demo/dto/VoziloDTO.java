package com.example.demo.dto;

import com.example.demo.model.TipVozila;
import com.example.demo.model.Vozilo;

public class VoziloDTO {
	
	private Long id;
	private StajalisteDTO stajaliste;
	private LinijaDTO linija;
	private TipVozila tip;
	
	public VoziloDTO (Vozilo voz) {
		this.id = voz.getId();
		if(voz.getStajaliste()!=null)
			this.stajaliste = new StajalisteDTO(voz.getStajaliste());
		if(voz.getLinija()!=null)
			this.linija = new LinijaDTO(voz.getLinija());
		this.tip = voz.getTip();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StajalisteDTO getStajaliste() {
		return stajaliste;
	}

	public void setStajaliste(StajalisteDTO stajaliste) {
		this.stajaliste = stajaliste;
	}

	public LinijaDTO getLinija() {
		return linija;
	}

	public void setLinija(LinijaDTO linija) {
		this.linija = linija;
	}

	public TipVozila getTip() {
		return tip;
	}

	public void setTip(TipVozila tip) {
		this.tip = tip;
	}

}
