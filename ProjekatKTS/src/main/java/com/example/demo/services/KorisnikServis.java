package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegistracijaDTO;
import com.example.demo.model.Administrator;
import com.example.demo.model.Authority;
import com.example.demo.model.Korisnik;
import com.example.demo.model.KorisnikAuthority;
import com.example.demo.model.TipKorisnika;
import com.example.demo.model.Zaposleni;
import com.example.demo.repositories.AdministratorRepozitorijum;
import com.example.demo.repositories.AuthorityRepozitorijum;
import com.example.demo.repositories.KorisnikAuthorityRepozitorijum;
import com.example.demo.repositories.KorisnikRepozitorijum;
import com.example.demo.repositories.ZaposleniRepozitorijum;

public class KorisnikServis {
	
	@Autowired
	KorisnikRepozitorijum korRep;
	
	@Autowired
    AuthorityRepozitorijum authRep;
	
	@Autowired
	KorisnikAuthorityRepozitorijum korAuthRep;
	
	@Autowired
	AdministratorRepozitorijum adminRep;
	
	@Autowired
	ZaposleniRepozitorijum zapRep;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Korisnik getUserByUsername(String username)
    {
		Korisnik kor = null;
		kor = this.korRep.findByUsername(username);
        return kor;
    }
	
	public LoginResponseDTO registracija(RegistracijaDTO regDTO) {
		regDTO.setLozinka(passwordEncoder.encode(regDTO.getLozinka()));
		//u bazi se nalaze predefinisani tipovi korisnika
		Authority authority = this.authRep.findByName(regDTO.getTip());
		Korisnik kor = new Korisnik(regDTO.getIme(), regDTO.getPrezime(), regDTO.getEmail(), regDTO.getLozinka());
		KorisnikAuthority korAuth = new KorisnikAuthority();
		korAuth.setAuthority(authority);
		this.korAuthRep.save(korAuth);
		
		switch (regDTO.getTip()) {
			case "ADMINISTRATOR":
			{
				Administrator admin = new Administrator(regDTO);
				admin.dodajKorisnikAuthority(korAuth);
				this.adminRep.save(admin);
				korAuth.setKorisnik(admin);
				this.korAuthRep.save(korAuth);
				kor.setId(admin.getId());
				kor.setTip(TipKorisnika.administrator);
				kor.dodajKorisnikAuthority(korAuth);
				break;
			}
			case "ZAPOSLENI":
			{
				Zaposleni zap = new Zaposleni(regDTO);
				zap.dodajKorisnikAuthority(korAuth);
				this.zapRep.save(zap);
				korAuth.setKorisnik(zap);
				this.korAuthRep.save(korAuth);
				kor.setId(zap.getId());
				kor.setTip(TipKorisnika.zaposleni);
				kor.dodajKorisnikAuthority(korAuth);
				break;
			}
			default:
                break;
		}
		return new LoginResponseDTO(kor);
    }

}
