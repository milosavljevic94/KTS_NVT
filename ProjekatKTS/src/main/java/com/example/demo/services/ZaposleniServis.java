package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KorisnikDTO;
import com.example.demo.model.Zaposleni;
import com.example.demo.repositories.ZaposleniRepozitorijum;

@Service
public class ZaposleniServis {
	@Autowired
	ZaposleniRepozitorijum zaposleniRepo;

	public List<Zaposleni> findAll() {
		return zaposleniRepo.findAll();
	}

	public Zaposleni getOne(Long id) {
		return zaposleniRepo.getOne(id);
	}

	public Zaposleni save(Zaposleni zap) {
		return zaposleniRepo.save(zap);
	}

	public void delete(Zaposleni zap) {
		zaposleniRepo.delete(zap);
	}
	
	public List<KorisnikDTO> sviZaposleni() {
        List<Zaposleni> zaposleni = zaposleniRepo.findAll();
        List<KorisnikDTO> zaposleniDTO = new ArrayList<>();
        for(Zaposleni zap : zaposleni)
        {
        	zaposleniDTO.add(new KorisnikDTO(zap));
        }
        return zaposleniDTO;
    }
	
	public KorisnikDTO izmeniZaposlenog(KorisnikDTO korDTO) {
		Zaposleni zap = zaposleniRepo.getOne(korDTO.getId());
		zap.setId(korDTO.getId());
		zap.setEmail(korDTO.getEmail());
		zap.setLozinka(korDTO.getLozinka());
		zap.setIme(korDTO.getIme());
		zap.setPrezime(korDTO.getPrezime());
		zap = zaposleniRepo.save(zap);
		return new KorisnikDTO(zap);
	}

}
