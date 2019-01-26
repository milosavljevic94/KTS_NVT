package com.example.demo.services;

import static com.example.demo.constants.PolazakConstants.DB_COUNT;
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

import com.example.demo.model.Polazak;
import com.example.demo.model.Stajaliste;

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
        assertThat(polazak).isNotNull();
        assertEquals(new Long(-1L), polazak.getId());
    }
   
    @Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testAdd() {
        Polazak testPolazak = new Polazak();
        testPolazak.setDan("Radni dan");
        testPolazak.setVreme("11:24");
        int dbSizeBefore = polazakServis.findAll().size();
        Polazak dbPolazak = polazakServis.save(testPolazak);
       
        assertThat(dbPolazak).isNotNull();
        List<Polazak> polasci = polazakServis.findAll();
        assertThat(polasci).hasSize(dbSizeBefore + 1);
        dbPolazak = polasci.get(polasci.size()-1);
        assertEquals(new Long(1L), dbPolazak.getId());
        assertEquals("Radni dan",dbPolazak.getDan());
        assertEquals("11:24", dbPolazak.getVreme());
   
    }
    
    ///////////////////////////
    @Test 
	public void testFindOne() {
    	Polazak testPolazak = polazakServis.findOne(-1L);
		assertThat(testPolazak).isNotNull();	
		assertThat(testPolazak.getId()).isEqualTo(-1L);
		assertEquals(testPolazak.getDan(), "Radni dan");  
	}
	
	@Test 
	public void testFindOneNotExist() {
		Polazak dbTestPolazak = polazakServis.findOne(-123L);
		assertThat(dbTestPolazak).isNull();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testRemove() {
		int dbSizeBeforeRemove = polazakServis.findAll().size();
		polazakServis.delete(-1L);;
		
		List<Polazak> polasci = polazakServis.findAll();
		assertThat(polasci).hasSize(dbSizeBeforeRemove - 1);
		
		Polazak dbPolazak = polazakServis.findOne(-1L);
		assertThat(dbPolazak).isNull();
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	@Transactional
	@Rollback(true)
	public void testRemoveNotExist() {
		int dbSizeBeforeRemove = polazakServis.findAll().size();
		polazakServis.delete(-123L);
		
		List<Polazak> polasci = polazakServis.findAll();
		assertNotEquals(polasci.size(), dbSizeBeforeRemove-1);
	}
	
	@Test
    @Transactional
    @Rollback(true) //it can be omitted because it is true by default
    public void testUpdate() {
    	Polazak polazak1 = polazakServis.getOne(-2L);
        polazak1.setDan("TestDan");
        polazak1.setVreme("11:11");
        
        Polazak polazak2 = polazakServis.save(polazak1);
       
        assertThat(polazak2).isNotNull();
        Polazak polazakUpdate = polazakServis.getOne(-2L);
       
        assertEquals("TestDan",polazakUpdate.getDan());
        assertEquals("11:11",polazakUpdate.getVreme());
    }
 
}
