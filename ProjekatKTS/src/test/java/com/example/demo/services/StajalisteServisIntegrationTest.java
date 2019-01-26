package com.example.demo.services;

import static com.example.demo.constants.StajalisteConstants.DB_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Stajaliste;
import com.example.demo.model.TipVozila;
import com.example.demo.model.Vozilo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StajalisteServisIntegrationTest {
 
    @Autowired
    private StajalisteServis stajalisteServis;
   
    @Test
    public void testGet_All() {
        List<Stajaliste> stajalista = stajalisteServis.getAll();
        assertEquals(DB_COUNT, stajalista.size());
    }
   
    @Test
    public void testGetByID_found() {
        Stajaliste stajaliste = stajalisteServis.getOne(-1L);
        //System.out.println(linija.toString());
       
        assertThat(stajaliste).isNotNull();
        assertEquals(new Long(-1L), stajaliste.getId());
    }
   
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testAdd() {
        Stajaliste testStajaliste = new Stajaliste();
        testStajaliste.setNaziv("TestStajaliste");
        testStajaliste.setLokacijaX(10.10);
        testStajaliste.setLokacijaY(11.11);
        testStajaliste.setAdresa("Temerinska");
        int dbSizeBefore = stajalisteServis.getAll().size();
        Stajaliste dbStajaliste = stajalisteServis.save(testStajaliste);
       
        assertThat(dbStajaliste).isNotNull();
        List<Stajaliste> stajalista = stajalisteServis.getAll();
        assertThat(stajalista).hasSize(dbSizeBefore + 1);
        dbStajaliste = stajalista.get(stajalista.size()-1);
        assertEquals(new Long(1L), dbStajaliste.getId());
        assertEquals("TestStajaliste",dbStajaliste.getNaziv());
        assertEquals(new Double(10.10), dbStajaliste.getLokacijaX());
        assertEquals(new Double(11.11), dbStajaliste.getLokacijaY());
        assertEquals("Temerinska", dbStajaliste.getAdresa());       
    }
    ///////////////////////////
	@Test 
	public void testFindOne() {
		Stajaliste dbStajaliste = stajalisteServis.findOne(-1L);
		assertThat(dbStajaliste).isNotNull();		
		assertThat(dbStajaliste.getId()).isEqualTo(-1L);
		assertEquals(dbStajaliste.getNaziv(), "Merkator");        
	}
	
	@Test 
	public void testFindOneNotExist() {
		Stajaliste dbStajaliste = stajalisteServis.findOne(-123L);
		assertThat(dbStajaliste).isNull();   
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testRemove() {
		int dbSizeBeforeRemove = stajalisteServis.getAll().size();
		stajalisteServis.delete(-1L);;
		
		List<Stajaliste> stajalista = stajalisteServis.getAll();
		assertThat(stajalista).hasSize(dbSizeBeforeRemove - 1);
		
		Stajaliste dbStajaliste = stajalisteServis.findOne(-1L);
		assertThat(dbStajaliste).isNull();
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	@Transactional
	@Rollback(true)
	public void testRemoveNotExist() {
		int dbSizeBeforeRemove = stajalisteServis.getAll().size();
		stajalisteServis.delete(-123L);
		
		List<Stajaliste> stajalista = stajalisteServis.getAll();
		assertNotEquals(stajalista.size(), dbSizeBeforeRemove-1);
	}
}
