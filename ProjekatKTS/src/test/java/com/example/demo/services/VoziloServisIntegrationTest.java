package com.example.demo.services;

import static com.example.demo.constants.VoziloConstants.DB_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Linija;
import com.example.demo.model.Vozilo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VoziloServisIntegrationTest {

	@Autowired
	private VoziloServis voziloServis;
	
	
	@Test
	public void testFind_All() {
		List<Vozilo> vozila = voziloServis.findAll();
		assertEquals(DB_COUNT, vozila.size());
	}
	
	@Test
	public void testGetByID_found() {
		Vozilo vozilo = voziloServis.getOne(1L);
		//System.out.println(vozilo.toString());
		
		assertThat(vozilo).isNotNull();
		assertEquals(new Long(1L), vozilo.getId());
		
	}
	


}