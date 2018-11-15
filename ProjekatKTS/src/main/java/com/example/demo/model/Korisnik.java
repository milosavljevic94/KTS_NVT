package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "korisnik")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Korisnik {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id" , unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "email")
	private String email;
	
	@NotNull
	private String lozinka;
	
	@Column(name = "tip")
	private TipKorisnika tip;
	
	@OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<KorisnikAuthority> korisnikAuthorities = new HashSet<KorisnikAuthority>();

	public Korisnik() {};

	public Korisnik(String ime, String prezime, String email, @NotNull String lozinka) {
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.tip = TipKorisnika.gradjanin;
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

	public TipKorisnika getTip() {
		return tip;
	}

	public void setTip(TipKorisnika tip) {
		this.tip = tip;
	}

	public Set<KorisnikAuthority> getKorisnikAuthorities() {
		return korisnikAuthorities;
	}

	public void setKorisnikAuthorities(Set<KorisnikAuthority> korisnikAuthorities) {
		this.korisnikAuthorities = korisnikAuthorities;
	}
	
	public void dodajKorisnikAuthority(KorisnikAuthority korAuth)
    {
		korisnikAuthorities.add(korAuth);
    }
	
	public KorisnikAuthority getPrviKorisnikAuthority()
    {
        if(!this.korisnikAuthorities.isEmpty()){
            return this.korisnikAuthorities.iterator().next();
        }
        return null;
    }

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email="
				+ email + ", lozinka=" + lozinka + "]";
	}

}
