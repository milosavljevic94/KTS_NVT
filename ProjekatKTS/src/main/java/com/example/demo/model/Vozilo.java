package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vozilo {
	@Id
	@Column(name = "vozilo_id")
	String id;
	@Column(nullable = false)
	Stajaliste stajaliste;
	@Column(nullable = false)
	Linija linija;
	@Column(nullable = false)
	TipVozila tip;
}
