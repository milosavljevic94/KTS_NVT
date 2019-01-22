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

import com.example.demo.model.Stajaliste;
import com.example.demo.repositories.StajalisteRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class StajalisteServisTest {

	@Autowired
	private StajalisteServis stajalisteServis;

	@MockBean
	private StajalisteRepozitorijum stajalisteRepozitorijumMocked;

	
	@Before
	public void setUp() {
		Stajaliste stajaliste = new Stajaliste(1l, "Liman1", 11.04, 11.05, "Bulevar Cara Lazara");
		Mockito.when(stajalisteRepozitorijumMocked.getOne(1L)).thenReturn(stajaliste);
	}

	@Test(expected=NullPointerException.class)
	public void whenNonExistingId_thenThrowNullPointerException() {
		Long id = 2L;
		Stajaliste found = stajalisteServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
	@Test
	public void whenExistingId_thenfindStajaliste() {
		Long id = 1L;
		Stajaliste found = stajalisteServis.getOne(id);

		assertEquals(id, found.getId());
	}
	
}
