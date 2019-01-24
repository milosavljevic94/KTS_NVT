package com.example.demo.services;

import static com.example.demo.constants.StajalisteConstants.DB_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Stajaliste;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StajalisteServisIntegrationTest {

	@Autowired
	private StajalisteServis stajalisteServis;
	
	
	@Test
	public void testFind_All() {
		List<Stajaliste> stajalista = stajalisteServis.getAll();
		assertEquals(DB_COUNT, stajalista.size());
	}
	
	@Test
	public void testGetByID_found() {
		Stajaliste stajaliste = stajalisteServis.getOne(1L);
		//System.out.println(linija.toString());
		
		assertThat(stajaliste).isNotNull();
		assertEquals(new Long(1L), stajaliste.getId());
		
	}
	

	

}