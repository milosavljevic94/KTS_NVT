package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Karta;
import com.example.demo.model.Korisnik;
import com.example.demo.model.TipKarte;
import com.example.demo.repositories.KartaRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class KartaServisTest {

	@Autowired
	private KartaServis kartaServis;

	@MockBean
	private KartaRepozitorijum kartaRepozitorijumMocked;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		Karta kar = new Karta(1L, TipKarte.mesecna, true, new Date(11,11,2015), new Date (11,12,2015), 1250, 1L);
		Mockito.when(kartaRepozitorijumMocked.getOne(1L)).thenReturn(kar);
	}

	@Test(expected=NullPointerException.class)
	public void whenNonExistingId_thenThrowNullPointerException() {
		Long id = 2L;
		Karta found = kartaServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
	@Test
	public void whenExistingId_thenfindKarta() {
		Long id = 1L;
		Karta found = kartaServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
}
