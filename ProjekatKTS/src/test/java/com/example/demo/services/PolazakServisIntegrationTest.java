package com.example.demo.services;

import static com.example.demo.constants.PolazakConstants.DB_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Polazak;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PolazakServisIntegrationTest {

	@Autowired
	private PolazakServis polazakServis;
	
	
	@Test
	public void testFind_All() {
		List<Polazak> polasci = polazakServis.findAll();
		assertEquals(DB_COUNT, polasci.size());
	}
	
	@Test
	public void testGetByID_found() {
		Polazak polazak = polazakServis.getOne(1L);
		//System.out.println(vozilo.toString());
		
		assertThat(polazak).isNotNull();
		assertEquals(new Long(1L), polazak.getId());
		
	}
	

	

}