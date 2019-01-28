package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Korisnik;
import com.example.demo.services.KorisnikServis;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class KorisnikKontrolerTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@MockBean
	private KorisnikServis korisnikServisMocked;
	
	@Before
	public void setUp() {
		Mockito.when(korisnikServisMocked.getUserByUsername("test@gmail.com"))
			.thenReturn(new Korisnik("Pera", "Peric", "test@gmail.com", "123"));
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testGetKorisnik() {
		ResponseEntity<Korisnik> responseEntity =
				restTemplate.getForEntity("/api/korisnik/email/test@gmail.com", Korisnik.class);
		Korisnik kor = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(kor);
        assertEquals("test@gmail.com", kor.getEmail());
	}

}
