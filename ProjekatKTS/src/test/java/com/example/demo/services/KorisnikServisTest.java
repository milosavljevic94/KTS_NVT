package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Korisnik;
import com.example.demo.repositories.KorisnikRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class KorisnikServisTest {
	
	@Autowired
	private KorisnikServis korisnikServis;

	@MockBean
	private KorisnikRepozitorijum korisnikRepozitorijumMocked;
	
	@Before
	public void setUp() {
		Korisnik kor = new Korisnik("Pera", "Peric", "pera@gmail.com", "123");
		Mockito.when(korisnikRepozitorijumMocked.findByUsername("pera@gmail.com")).thenReturn(kor);
	}
	
	@Test(expected=NullPointerException.class)
	public void whenNonExistingEmail_thenThrowNullPointerException() {
		String email = "test@yahoo.com";
		Korisnik found = korisnikServis.getUserByUsername(email);
		assertEquals(email, found.getEmail());
	}
	
	@Test
	public void whenExistingEmail_thenfindKorisnik() {
		String email = "pera@gmail.com";
		Korisnik found = korisnikServis.getUserByUsername(email);
		assertEquals(email, found.getEmail());
	}

}
