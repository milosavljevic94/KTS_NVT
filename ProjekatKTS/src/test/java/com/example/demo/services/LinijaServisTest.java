package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Linija;
import com.example.demo.model.Polazak;
import com.example.demo.model.Stajaliste;
import com.example.demo.model.TipVozila;
import com.example.demo.repositories.LinijaRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class LinijaServisTest {

	@Autowired
	private LinijaServis linijaServis;

	@MockBean
	private LinijaRepozitorijum linijaRepozitorijumMocked;

	
	@Before
	public void setUp() {
		Linija linija = new Linija(1L, "11", "centar", new ArrayList<Stajaliste>(), new ArrayList<Polazak>(), TipVozila.autobus);
		Mockito.when(linijaRepozitorijumMocked.getOne(1L)).thenReturn(linija);
	}

	@Test(expected=NullPointerException.class)
	public void whenNonExistingId_thenThrowNullPointerException() {
		Long id = 2L;
		Linija found = linijaServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
	@Test
	public void whenExistingId_thenfindLinija() {
		Long id = 1L;
		Linija found = linijaServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
}
