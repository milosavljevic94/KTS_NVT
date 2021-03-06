package com.example.demo.services;
 
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;
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

import com.example.demo.model.Karta;
import com.example.demo.model.TipKarte;
 
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class KartaServisIntegrationTest {
   
    @Autowired
    private KartaServis kartaServis;
   
    @Test
    public void testFind_All() {
        List<Karta> karta = kartaServis.findAll();
        assertEquals(3, karta.size());
    }
   
    @Test
    public void testGetByID_found() {
        Karta karta = kartaServis.getOne(-1L);
        assertThat(karta).isNotNull();
        assertEquals(new Long(-1L), karta.getId());
    }
   
    @SuppressWarnings("deprecation")
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testAdd() {
        Karta testKarta = new Karta();
        testKarta.setTip(TipKarte.godisnja);
        testKarta.setCena(11111);
        testKarta.setVaziOd(new Date(2019, 2, 1));
        testKarta.setVaziDo(new Date(2020, 2, 1));
        testKarta.setAktivirana(true);
        testKarta.setVlasnik(1L);
       
        int dbSizeBefore = kartaServis.findAll().size();
        Karta dbKarta = kartaServis.save(testKarta);
       
        assertThat(dbKarta).isNotNull();
        List<Karta> karte = kartaServis.findAll();
        assertThat(karte).hasSize(dbSizeBefore + 1);
        dbKarta = karte.get(karte.size()-1);
        assertEquals(TipKarte.godisnja, dbKarta.getTip());
        assertEquals(11111, dbKarta.getCena());
        assertEquals(new Date(2019, 2, 1), dbKarta.getVaziOd());
        assertEquals(new Date(2020, 2, 1), dbKarta.getVaziDo());
        assertEquals(true, dbKarta.isAktivirana());
        assertEquals(new Long(1L), dbKarta.getVlasnik());
    }
   
    //////////////////////////////////
   
    @Test
    public void testFindOne() {
        Karta testKarta = kartaServis.findOne(-1L);
        assertThat(testKarta).isNotNull();
        assertThat(testKarta.getId()).isEqualTo(-1L); 
    }
   
    @Test
    public void testFindOneNotExist() {
        Karta testKarta = kartaServis.findOne(-123L);
        assertThat(testKarta).isNull();
    }
   
    @Test
    @Transactional
    @Rollback(true)
    public void testRemove() {
        int dbSizeBeforeRemove = kartaServis.findAll().size();
        kartaServis.delete(-1L);;
       
        List<Karta> karte = kartaServis.findAll();
        assertThat(karte).hasSize(dbSizeBeforeRemove - 1);
       
        Karta dbKarta = kartaServis.findOne(-1L);
        assertThat(dbKarta).isNull();
    }
   
    @Test(expected = EmptyResultDataAccessException.class)
    @Transactional
    @Rollback(true)
    public void testRemoveNotExist() {
        int dbSizeBeforeRemove = kartaServis.findAll().size();
        kartaServis.delete(-123L);;
       
        List<Karta> karte = kartaServis.findAll();
        assertNotEquals(karte.size(), dbSizeBeforeRemove-1);
    }
    
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testUpdate() {
    	Karta karta1 = kartaServis.getOne(-2L);
        karta1.setCena(1000);
        karta1.setTip(TipKarte.dnevna);
        
        
        Karta karta2 = kartaServis.save(karta1);
       
        assertThat(karta2).isNotNull();
        Karta kartaUpdate = kartaServis.getOne(-2L);
       
        assertEquals(1000,kartaUpdate.getCena());
        assertEquals(TipKarte.dnevna, kartaUpdate.getTip());
    }
 
}
