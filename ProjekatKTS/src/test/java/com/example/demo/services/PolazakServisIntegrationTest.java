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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        Polazak polazak = polazakServis.getOne(-1L);
        //System.out.println(vozilo.toString());
       
        assertThat(polazak).isNotNull();
        assertEquals(new Long(-1L), polazak.getId());
       
    }
   
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testAdd() {
        Polazak testPolazak = new Polazak();
        testPolazak.setDan("Utorak");
        testPolazak.setVreme("11:24");
        int dbSizeBefore = polazakServis.findAll().size();
        Polazak dbPolazak = polazakServis.save(testPolazak);
       
        assertThat(dbPolazak).isNotNull();
        List<Polazak> polasci = polazakServis.findAll();
        assertThat(polasci).hasSize(dbSizeBefore + 1);
        dbPolazak = polasci.get(polasci.size()-1);
        assertEquals(new Long(1L), dbPolazak.getId());
        assertEquals("Utorak",dbPolazak.getDan());
        assertEquals("11:24", dbPolazak.getVreme());
   
    }
   
 
   
 
}