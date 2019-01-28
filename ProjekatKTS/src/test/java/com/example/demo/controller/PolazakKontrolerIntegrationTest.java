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

import com.example.demo.model.Polazak;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PolazakKontrolerIntegrationTest {
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void testGet_All() {
		ResponseEntity<Polazak[]> responseEntity =
				restTemplate.getForEntity("/api/polazak/all", Polazak[].class);
		Polazak[] polasci = responseEntity.getBody();
		
		assertEquals(polasci.length, DB_COUNT-1);
	}
	
	@Test
    public void testGet_By_ID() {
		ResponseEntity<Polazak> responseEntity =
				restTemplate.getForEntity("/api/polazak/-1", Polazak.class);
		Polazak polazak = responseEntity.getBody();
		
		assertThat(polazak).isNotNull();
		assertEquals(polazak.getId(), new Long(-1L));
		assertEquals(polazak.getDan(), "Radni dan");
		assertEquals(polazak.getVreme(), "11:45");
	}
	
	
	@Test
    public void testGet_By_ID_Fail() {
		//nonexistent ID -123
		ResponseEntity<Polazak> responseEntity =
				restTemplate.getForEntity("/api/polazak/-123", Polazak.class);
		Polazak polazak = responseEntity.getBody();
		
		assertNull(polazak.getId());
		assertEquals(responseEntity.getStatusCodeValue(), 500);
	}
	
	@Test
    @Transactional
    @Rollback(true) 
    public void testAdd_Polazak() throws JsonProcessingException {
		Polazak testPolazak = new Polazak();
		testPolazak.setDan("Subota");
		testPolazak.setVreme("13:00");
		testPolazak.setId(-123L);
		
		// converting to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String polazakJSON = ow.writeValueAsString(testPolazak);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(polazakJSON, headers);

		ResponseEntity<Polazak> responseEntity =
				restTemplate.postForEntity("/api/polazak/add", entity, Polazak.class);
		
		// 201 CREATED
		assertEquals(responseEntity.getStatusCodeValue(), 201);
	}
	
	@Test
    @Transactional
    @Rollback(true) 
    public void testUpdate_Polazak() throws JsonProcessingException {
		ResponseEntity<Polazak> responseEntity =
				restTemplate.getForEntity("/api/polazak/-2", Polazak.class);
		Polazak testPolazak = responseEntity.getBody();
		
		assertThat(testPolazak).isNotNull();
		assertEquals(testPolazak.getId(), new Long(-2L));
		assertEquals(testPolazak.getDan(), "Nedelja");
		assertEquals(testPolazak.getVreme(), "13:50");
		
		testPolazak.setDan("Radni dan");
		testPolazak.setVreme("18:00");
		
		// converting to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String polazakJSON = ow.writeValueAsString(testPolazak);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(polazakJSON, headers);
		
		responseEntity = restTemplate.exchange("/api/polazak/update", HttpMethod.PUT, entity, Polazak.class);
		
		assertEquals(responseEntity.getStatusCodeValue(), 200);
		
		responseEntity = restTemplate.getForEntity("/api/polazak/-2", Polazak.class);
		testPolazak = responseEntity.getBody();
		
		assertThat(testPolazak).isNotNull();
		assertEquals(testPolazak.getId(), new Long(-2L));
		assertEquals(testPolazak.getDan(), "Radni dan");
		assertEquals(testPolazak.getVreme(), "18:00");
	}
	
	@Test
	@Transactional
    @Rollback(true)
    public void testDelete() {
		HttpEntity<String> entity = new HttpEntity<String>("");
		
		ResponseEntity<Void> responseEntity =
				restTemplate.exchange("/api/polazak/-3", HttpMethod.DELETE, entity, Void.class);
			
		assertEquals(responseEntity.getStatusCodeValue(), 200);
	}
}
