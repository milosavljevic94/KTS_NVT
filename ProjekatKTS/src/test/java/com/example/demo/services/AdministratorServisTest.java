package com.example.demo.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repositories.AdministratorRepozitorijum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class AdministratorServisTest {
	
	@Autowired
	private AdministratorServis administratorServis;

	@MockBean
	private AdministratorRepozitorijum administratorRepozitorijumMocked;
	
	@Before
	//TO-DO
	
	@Test(expected=NullPointerException.class)
	public void whenNonExistingID_thenThrowNullPointerException() {
		//TO-DO	
	}
	
	@Test
	public void whenExistingEmail_thenfindAdministrator() {
		//TO-DO	
	}

}
