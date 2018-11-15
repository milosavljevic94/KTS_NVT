package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Authority {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "authority_naziv")
	private String naziv;
	
	@OneToMany(mappedBy = "authority", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<KorisnikAuthority> korisnikAuthorities = new HashSet<KorisnikAuthority>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<KorisnikAuthority> getKorisnikAuthorities() {
		return korisnikAuthorities;
	}

	public void setKorisnikAuthorities(Set<KorisnikAuthority> korisnikAuthorities) {
		this.korisnikAuthorities = korisnikAuthorities;
	}

}
