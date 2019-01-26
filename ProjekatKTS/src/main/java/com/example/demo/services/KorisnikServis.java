package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KorisnikDTO;
import com.example.demo.dto.LoginRequestDTO;
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

@Service
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
	
	public Korisnik save(Korisnik kor) {
		this.korRep.save(kor);
		return kor;
	}
	
	public Korisnik getUserByUsername(String username) {
		Korisnik kor = null;
		kor = this.korRep.findByUsername(username);
        return kor;
    }
	
	public Korisnik getUserById(Long id) {
		Korisnik kor = this.korRep.getOne(id);
        return kor;
    }
	
	public LoginResponseDTO registracija(RegistracijaDTO regDTO) {
		regDTO.setLozinka(passwordEncoder.encode(regDTO.getLozinka()));
		//u bazi se nalaze predefinisani tipovi korisnika
		Authority authority = this.authRep.findByName(regDTO.getTip());
		Korisnik kor = new Korisnik(regDTO.getIme(), regDTO.getPrezime(), regDTO.getEmail(), regDTO.getLozinka());
		kor.setTip(TipKorisnika.gradjanin);
		this.korRep.save(kor);
		
		KorisnikAuthority korAuth = new KorisnikAuthority();
		korAuth.setKorisnik(kor);
		korAuth.setAuthority(authority);
		this.korAuthRep.save(korAuth);
		
		kor.dodajKorisnikAuthority(korAuth);
		this.korRep.save(kor);
		
		/*switch (regDTO.getTip()) {
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
				this.korRep.save(kor);
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
				this.korRep.save(kor);
				break;
			}
			default:
                break;
		}*/
		return new LoginResponseDTO(kor);
    }
	
	public Korisnik promeniLozinku(LoginRequestDTO logRegDTO) {
		Korisnik kor = korRep.findByUsername(logRegDTO.getEmail());
		kor.setLozinka(logRegDTO.getLozinka());
        return kor;
    }
	
	public Korisnik updateTipKorisnika(KorisnikDTO kDTO) {
		Korisnik kor = korRep.findByUsername(kDTO.getEmail());
		kor.setTip(kDTO.getTip());
		kor.getPrviKorisnikAuthority().setAuthority(authRep.findByName(kDTO.getTip().toString()));
		//kor.setKorisnikAuthorities(korisnikAuthorities);
		korRep.save(kor);
        return kor;
    }
	
	public List<KorisnikDTO> sviKorisnici() {
		List<Korisnik> korisnici = korRep.findAll();
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik kor : korisnici)
			korisniciDTO.add(new KorisnikDTO(kor));
		return korisniciDTO;
	}

}
