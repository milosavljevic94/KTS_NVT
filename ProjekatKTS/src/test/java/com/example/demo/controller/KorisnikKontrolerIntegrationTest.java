package com.example.demo.controller;

import static com.example.demo.constants.KorisnikConstants.DB_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.RegistracijaDTO;
import com.example.demo.model.Korisnik;
import com.example.demo.model.TipKorisnika;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class KorisnikKontrolerIntegrationTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void testLogin() {
		LoginRequestDTO loginRequest = new LoginRequestDTO("admin@kts.com", "a");
		
		ResponseEntity<?> responseEntity = 
				restTemplate.postForEntity("/api/korisnik/login", loginRequest, Korisnik.class);
		
		assertEquals(responseEntity.getStatusCodeValue(), 200);
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testRegistracija() throws JsonProcessingException {
		RegistracijaDTO registracijaDTO = new RegistracijaDTO("test@kts.com", "test", "gradjanin", "Testko", "Testic");
		
		// converting to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String registracijaJSON = ow.writeValueAsString(registracijaDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(registracijaJSON, headers);
		
		ResponseEntity<?> responseEntity = 
				restTemplate.postForEntity("/api/korisnik/registracija", entity, Korisnik.class);
		
		// 201 CREATED
		assertEquals(responseEntity.getStatusCodeValue(), 201);
	}
	
	@Test
    public void testGet_All() {
		ResponseEntity<Korisnik[]> responseEntity =
				restTemplate.getForEntity("/api/korisnik/sviKorisnici", Korisnik[].class);
		Korisnik[] korisnici = responseEntity.getBody();
		
		assertEquals(korisnici.length, DB_COUNT);
	}
	
	@Test
    public void testGet_By_ID() {
		ResponseEntity<Korisnik> responseEntity =
				restTemplate.getForEntity("/api/korisnik/-1", Korisnik.class);
		Korisnik korisnik = responseEntity.getBody();
		
		assertThat(korisnik).isNotNull();
		assertEquals(korisnik.getId(), new Long(-1L));
		assertEquals(korisnik.getEmail(), "pera@kts.com");
		assertEquals(korisnik.getIme(), "Petar");
		assertEquals(korisnik.getPrezime(), "Petrovic");
		assertEquals(korisnik.getTip(), TipKorisnika.gradjanin);
	}
	
	//throws EntityNotFoundException
	@Test
    public void testGet_By_ID_Fail() {
		// nonexistent ID -123
		ResponseEntity<Korisnik> responseEntity =
				restTemplate.getForEntity("/api/korisnik/-123", Korisnik.class);
		
		assertEquals(responseEntity.getStatusCodeValue(), 500);
	}
	
	@Test
    public void testGet_By_Email() {
		ResponseEntity<Korisnik> responseEntity =
				restTemplate.getForEntity("/api/korisnik/email/pera@kts.com", Korisnik.class);
		Korisnik korisnik = responseEntity.getBody();
		
		assertThat(korisnik).isNotNull();
		assertEquals(korisnik.getId(), new Long(-1L));
		assertEquals(korisnik.getEmail(), "pera@kts.com");
		assertEquals(korisnik.getIme(), "Petar");
		assertEquals(korisnik.getPrezime(), "Petrovic");
		assertEquals(korisnik.getTip(), TipKorisnika.gradjanin);
	}
	
	@Test
    public void testGet_By_Email_Fail() {
		ResponseEntity<Korisnik> responseEntity =
				restTemplate.getForEntity("/api/korisnik/email/ne_postoji@kts.com", Korisnik.class);
		
		assertEquals(responseEntity.getStatusCodeValue(), 404);
	}
	
	@Test
    @Transactional
    @Rollback(true) 
    public void testUpdate_Tip_Korisnika() throws JsonProcessingException {
		ResponseEntity<Korisnik> responseEntity =
				restTemplate.getForEntity("/api/korisnik/-2", Korisnik.class);
		Korisnik testKorisnik = responseEntity.getBody();
		
		assertThat(testKorisnik).isNotNull();
		assertEquals(testKorisnik.getId(), new Long(-2L));
		assertEquals(testKorisnik.getEmail(), "nikola@kts.com");
		assertEquals(testKorisnik.getIme(), "Nikola");
		assertEquals(testKorisnik.getPrezime(), "Nikolic");
		assertEquals(testKorisnik.getTip(), TipKorisnika.gradjanin);

		testKorisnik.setTip(TipKorisnika.ucenik);
		
		// converting to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String voziloJSON = ow.writeValueAsString(testKorisnik);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(voziloJSON, headers);
		
		responseEntity = restTemplate.exchange("/api/korisnik/updateTipKorisnika", HttpMethod.PUT, entity, Korisnik.class);
		
		assertEquals(responseEntity.getStatusCodeValue(), 200);
		
		responseEntity = restTemplate.getForEntity("/api/korisnik/-2", Korisnik.class);
		testKorisnik = responseEntity.getBody();
		
		assertThat(testKorisnik).isNotNull();
		assertEquals(testKorisnik.getId(), new Long(-2L));
		assertEquals(testKorisnik.getTip(), TipKorisnika.ucenik);
	}

}
