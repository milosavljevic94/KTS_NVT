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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Linija;
import com.example.demo.model.TipVozila;


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
        Linija linija = linijaServis.getOne(-1L);
        //System.out.println(linija.toString());
       
        assertThat(linija).isNotNull();
        assertEquals(new Long(-1L), linija.getId());
       
    }
   
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testAdd() {
        Linija testLinija = new Linija();
        testLinija.setBroj("24");
        testLinija.setNaziv("TestLinija");
        testLinija.setTip(TipVozila.autobus);
        int dbSizeBefore = linijaServis.findAll().size();
        Linija dbLinija = linijaServis.save(testLinija);
       
        assertThat(dbLinija).isNotNull();
        List<Linija> linije = linijaServis.findAll();
        assertThat(linije).hasSize(dbSizeBefore + 1);
        dbLinija = linije.get(linije.size()-1);
        assertEquals("24", dbLinija.getBroj());
        assertEquals("TestLinija", dbLinija.getNaziv());
        assertEquals(TipVozila.autobus, dbLinija.getTip());
    }
   
 
}