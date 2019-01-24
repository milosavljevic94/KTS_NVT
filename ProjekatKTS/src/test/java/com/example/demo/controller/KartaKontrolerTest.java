package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

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

import com.example.demo.model.Karta;
import com.example.demo.model.Korisnik;
import com.example.demo.model.TipKarte;
import com.example.demo.services.KartaServis;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class KartaKontrolerTest {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@MockBean
	private KartaServis kartaServisMocked;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		Mockito.when(kartaServisMocked.getOne(13456L)).thenReturn(new Karta(13456L, TipKarte.mesecna, true, new Date(11,11,2015), new Date (11,12,2015), 1250, 1L));
	}
	
	@Test
	public void testGetKarta() {
		ResponseEntity<Karta> responseEntity =
	            restTemplate.getForEntity("/api/karta?id=1L", Karta.class);
		
		Karta karta = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(karta);
        assertEquals(new Long(13456L), karta.getId());
	}
	
}
