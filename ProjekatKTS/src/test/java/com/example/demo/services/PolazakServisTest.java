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

import com.example.demo.model.Polazak;
import com.example.demo.repositories.PolazakRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PolazakServisTest {

	@Autowired
	private PolazakServis polazakServis;

	@MockBean
	private PolazakRepozitorijum polazakRepozitorijumMocked;

	
	@Before
	public void setUp() {
		Polazak polazak = new Polazak(1L, "Ponedeljak", "11:30");
		Mockito.when(polazakRepozitorijumMocked.getOne(1L)).thenReturn(polazak);
	}

	@Test(expected=NullPointerException.class)
	public void whenNonExistingId_thenThrowNullPointerException() {
		Long id = 2L;
		Polazak found = polazakServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
	@Test
	public void whenExistingId_thenfindPolazak() {
		Long id = 1L;
		Polazak found = polazakServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
}
