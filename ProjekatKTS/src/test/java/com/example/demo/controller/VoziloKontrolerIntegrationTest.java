package com.example.demo.controller;

import static com.example.demo.constants.VoziloConstants.DB_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

import com.example.demo.model.TipVozila;
import com.example.demo.model.Vozilo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VoziloKontrolerIntegrationTest {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void testGet_All() {
		ResponseEntity<Vozilo[]> responseEntity =
				restTemplate.getForEntity("/api/vozilo/all", Vozilo[].class);
		Vozilo[] vozila = responseEntity.getBody();
		
		assertEquals(vozila.length, DB_COUNT-1);
	}
	
	@Test
    public void testGet_By_ID() {
		ResponseEntity<Vozilo> responseEntity =
				restTemplate.getForEntity("/api/vozilo/-1", Vozilo.class);
		Vozilo vozilo = responseEntity.getBody();
		
		assertThat(vozilo).isNotNull();
		assertEquals(vozilo.getId(), new Long(-1L));
		assertEquals(vozilo.getLinija(), new Long(-1L));
		assertEquals(vozilo.getStajaliste(), new Long(-1L));
		assertEquals(vozilo.getTip(), TipVozila.autobus);
	}
	
	//throws EntityNotFoundException
	@Test
    public void testGet_By_ID_Fail() {
		//nonexistent ID -123
		ResponseEntity<Vozilo> responseEntity =
				restTemplate.getForEntity("/api/vozilo/-123", Vozilo.class);
		Vozilo vozilo = responseEntity.getBody();
		
		assertNull(vozilo.getId());
		assertEquals(responseEntity.getStatusCodeValue(), 500);
	}
	
	@Test
    @Transactional
    @Rollback(true) 
    public void testAdd_Vozilo() throws JsonProcessingException {
		Vozilo testVozilo = new Vozilo();
		testVozilo.setLinija(-1L);
		testVozilo.setStajaliste(-1L);
		testVozilo.setTip(TipVozila.autobus);
		testVozilo.setId(-123L);
		
		// converting to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String voziloJSON = ow.writeValueAsString(testVozilo);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(voziloJSON, headers);

		ResponseEntity<Vozilo> responseEntity =
				restTemplate.postForEntity("/api/vozilo/add", entity, Vozilo.class);
		
		// 201 CREATED
		assertEquals(responseEntity.getStatusCodeValue(), 201);
	}
	
	@Test
    @Transactional
    @Rollback(true) 
    public void testUpdate_Vozilo() throws JsonProcessingException {
		ResponseEntity<Vozilo> responseEntity =
				restTemplate.getForEntity("/api/vozilo/-2", Vozilo.class);
		Vozilo testVozilo = responseEntity.getBody();
		
		assertThat(testVozilo).isNotNull();
		assertEquals(testVozilo.getId(), new Long(-2L));
		assertEquals(testVozilo.getLinija(), new Long(-2L));
		assertEquals(testVozilo.getStajaliste(), new Long(-2L));
		assertEquals(testVozilo.getTip(), TipVozila.autobus);
		
		testVozilo.setLinija(-3L);
		testVozilo.setStajaliste(-3L);
		testVozilo.setTip(TipVozila.tramvaj);
		
		// converting to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String voziloJSON = ow.writeValueAsString(testVozilo);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(voziloJSON, headers);
		
		responseEntity = restTemplate.exchange("/api/vozilo/update", HttpMethod.PUT, entity, Vozilo.class);
		
		assertEquals(responseEntity.getStatusCodeValue(), 200);
		
		responseEntity = restTemplate.getForEntity("/api/vozilo/-2", Vozilo.class);
		testVozilo = responseEntity.getBody();
		
		assertThat(testVozilo).isNotNull();
		assertEquals(testVozilo.getId(), new Long(-2L));
		assertEquals(testVozilo.getLinija(), new Long(-3L));
		assertEquals(testVozilo.getStajaliste(), new Long(-3L));
		assertEquals(testVozilo.getTip(), TipVozila.tramvaj);
	}
	
	@Test
	@Transactional
    @Rollback(true)
    public void testDelete() {
		HttpEntity<String> entity = new HttpEntity<String>("");
		
		ResponseEntity<Void> responseEntity =
				restTemplate.exchange("/api/vozilo/-3", HttpMethod.DELETE, entity, Void.class);
			
		assertEquals(responseEntity.getStatusCodeValue(), 200);
	}
}
