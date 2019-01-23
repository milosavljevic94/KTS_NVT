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

import com.example.demo.model.Linija;
import com.example.demo.model.Stajaliste;
import com.example.demo.model.TipVozila;
import com.example.demo.model.Vozilo;
import com.example.demo.repositories.VoziloRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class VoziloServisTest {

	@Autowired
	private VoziloServis voziloServis;

	@MockBean
	private VoziloRepozitorijum voziloRepozitorijumMocked;

	
	@Before
	public void setUp() {
		Vozilo vozilo = new Vozilo(123L, 9L, 0L, TipVozila.autobus);
		Mockito.when(voziloRepozitorijumMocked.getOne(123L)).thenReturn(vozilo);
	}

	@Test(expected=NullPointerException.class)
	public void whenNonExistingId_thenThrowNullPointerException() {
		Long id = 2L;
		Vozilo found = voziloServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
	@Test
	public void whenExistingId_thenfindVozilo() {
		Long id = 123L;
		Vozilo found = voziloServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
}
