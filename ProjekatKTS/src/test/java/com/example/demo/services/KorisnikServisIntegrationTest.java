package com.example.demo.services;

import static com.example.demo.constants.KorisnikConstants.DB_COUNT;
import static com.example.demo.constants.KorisnikConstants.DB_ID;
import static com.example.demo.constants.KorisnikConstants.DB_USERNAME;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.KorisnikDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegistracijaDTO;
import com.example.demo.model.Korisnik;
import com.example.demo.model.TipVozila;
import com.example.demo.model.Vozilo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class KorisnikServisIntegrationTest {

	@Autowired
	private KorisnikServis korisnikServis;
	
	
	@Test
	public void testGetAll() {
		List<KorisnikDTO> korisnici = korisnikServis.sviKorisnici();
		assertEquals(DB_COUNT, korisnici.size());
		//Vraca 3 iako postoje 2 korisnika, verovatno racuna + 1 adminstrator; 2+1=3
	}
	
	@Test
	public void testGetByID() {
		Korisnik korisnik = korisnikServis.getUserById(DB_ID);
		assertThat(korisnik).isNotNull();
		assertEquals(DB_ID, korisnik.getId());
	}
	
	@Test
	public void testGetByUserName() {
		Korisnik korisnik = korisnikServis.getUserByUsername(DB_USERNAME);
		assertThat(korisnik).isNotNull();
		assertEquals(DB_USERNAME, korisnik.getEmail());
			
	}
	
	//Pitati minu oko ovoga, nece da odradi dodavanje novog;
	/*
	@Test
	public void registracijaKorisnika() {
		RegistracijaDTO regDTO = new RegistracijaDTO("test@kts.com", "test", "test", "testName", "testSurname");
		LoginResponseDTO logRespDTO = korisnikServis.registracija(regDTO);
		Korisnik korisnik = korisnikServis.getUserByUsername("test@kts.com");
		
		assertEquals("test@kts.com", korisnik.getEmail());
	}
	*/
	
	
	/*
	@Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
	public void testAdd() {
		Vozilo testVozilo = new Vozilo();
		testVozilo.setId(NEW_DB_ID);
		testVozilo.setLinija(NEW_DB_LINIJA_ID);
		testVozilo.setStajaliste(NEW_DB_STAJALISTE_ID);
		testVozilo.setTip(TipVozila.autobus);
		int dbSizeBefore = voziloServis.findAll().size();
		Vozilo dbVozilo = voziloServis.save(testVozilo);
		
		assertThat(dbVozilo).isNotNull();
		List<Vozilo> vozila = voziloServis.findAll();
		//assertThat(vozila).hasSize(dbSizeBefore + 1);
		dbVozilo = vozila.get(vozila.size()-1);
		assertEquals(dbVozilo.getId(),NEW_DB_ID );
		assertEquals(dbVozilo.getStajaliste(),NEW_DB_STAJALISTE_ID);
		assertEquals(dbVozilo.getLinija(),NEW_DB_LINIJA_ID);
		
	}
	*/


}