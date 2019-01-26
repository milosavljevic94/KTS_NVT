package com.example.demo.services;

import static com.example.demo.constants.VoziloConstants.DB_COUNT;
import static com.example.demo.constants.VoziloConstants.NEW_DB_LINIJA_ID;
import static com.example.demo.constants.VoziloConstants.NEW_DB_STAJALISTE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.TipVozila;
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
        Vozilo vozilo = voziloServis.getOne(-1L);
        //System.out.println(vozilo.toString());
       
        assertThat(vozilo).isNotNull();
        assertEquals(new Long(-1L), vozilo.getId());
    }
    
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testAdd() {
        Vozilo testVozilo = new Vozilo();
        testVozilo.setLinija(NEW_DB_LINIJA_ID);
        testVozilo.setStajaliste(NEW_DB_STAJALISTE_ID);
        testVozilo.setTip(TipVozila.autobus);
        int dbSizeBefore = voziloServis.findAll().size();
        Vozilo dbVozilo = voziloServis.save(testVozilo);
       
        assertThat(dbVozilo).isNotNull();
        List<Vozilo> vozila = voziloServis.findAll();
        assertThat(vozila).hasSize(dbSizeBefore + 1);
        dbVozilo = vozila.get(vozila.size()-1);
        assertEquals(dbVozilo.getId(),new Long(1L));
        assertEquals(dbVozilo.getStajaliste(),NEW_DB_STAJALISTE_ID);
        assertEquals(dbVozilo.getLinija(),NEW_DB_LINIJA_ID);
    }
    
    ///////////////////////////////////////////////////////////////////////
	@Test 
	public void testFindOne() {
		Vozilo dbVozilo = voziloServis.findOne(-1L);
		assertThat(dbVozilo).isNotNull();
		assertThat(dbVozilo.getId()).isEqualTo(-1L);
		assertEquals(dbVozilo.getTip(), TipVozila.autobus);      
	}
	
	@Test 
	public void testFindOneNotExist() {
		Vozilo dbVozilo = voziloServis.findOne(-123L);
		assertThat(dbVozilo).isNull();    
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testRemove() {
		int dbSizeBeforeRemove = voziloServis.findAll().size();
		voziloServis.delete(-1L);;
		
		List<Vozilo> vozila = voziloServis.findAll();
		assertThat(vozila).hasSize(dbSizeBeforeRemove - 1);
		
		Vozilo dbVozilo = voziloServis.findOne(-1L);
		assertThat(dbVozilo).isNull();
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	@Transactional
	@Rollback(true)
	public void testRemoveNotExist() {
		int dbSizeBeforeRemove = voziloServis.findAll().size();
		voziloServis.delete(-123L);
		
		List<Vozilo> vozila = voziloServis.findAll();		
		assertNotEquals(vozila.size(), dbSizeBeforeRemove-1);
	}
	
	@Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testUpdate() {
    	Vozilo vozilo = voziloServis.getOne(-2L);
        vozilo.setLinija(-3L);
        vozilo.setStajaliste(-3L);
        vozilo.setTip(TipVozila.tramvaj);
        
        Vozilo dbVozilo = voziloServis.save(vozilo);
       
        assertThat(dbVozilo).isNotNull();
        Vozilo voziloUpdate = voziloServis.getOne(-2L);
       
        assertEquals(new Long(-3L),voziloUpdate.getStajaliste());
        assertEquals(new Long(-3L),dbVozilo.getLinija());
        assertEquals(dbVozilo.getTip(),TipVozila.tramvaj);
    }
	
}
