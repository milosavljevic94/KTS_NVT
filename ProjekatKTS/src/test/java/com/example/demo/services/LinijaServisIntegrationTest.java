package com.example.demo.services;

import static com.example.demo.constants.LinijaConstants.DB_COUNT;
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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LinijaServisIntegrationTest {

	@Autowired
	private LinijaServis linijaServis;
	
	
	@Test
	public void testFind_All() {
		List<Linija> linije = linijaServis.findAll();
		assertEquals(DB_COUNT, linije.size());
	}
	
	@Test
	public void testGetByID_found() {
		Linija linija = linijaServis.getOne(1L);
		//System.out.println(linija.toString());
		
		assertThat(linija).isNotNull();
		assertEquals(new Long(1L), linija.getId());
		
	}

	

}