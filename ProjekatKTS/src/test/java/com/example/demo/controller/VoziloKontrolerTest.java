package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.example.demo.model.Linija;
import com.example.demo.model.Stajaliste;
import com.example.demo.model.TipVozila;
import com.example.demo.model.Vozilo;
import com.example.demo.services.VoziloServis;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class VoziloKontrolerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private VoziloServis voziloServisMocked;
	
	@Before
	public void setUp() {
		Mockito.when(voziloServisMocked.getOne(13456L)).thenReturn(new Vozilo(13456L, 0L, 0L, TipVozila.autobus));
	}
	
	@Test
	public void testGetVozilo() {
		ResponseEntity<Vozilo> responseEntity = restTemplate.getForEntity("/api/vozilo?id=123L", Vozilo.class);
		
		Vozilo vozilo = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(vozilo);
		assertEquals(new Long(13456L), vozilo.getId());
	}

}
