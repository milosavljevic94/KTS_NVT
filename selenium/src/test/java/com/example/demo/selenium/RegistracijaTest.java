package com.example.demo.selenium;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RegistracijaTest {
private WebDriver browser;
	
	HomePage homePage;
	RegistracijaPage registracijaPage;
	
	@BeforeMethod
	public void setupSelenium() {
		//instantiate browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		//maximize window
		browser.manage().window().maximize();
		//navigate
		browser.navigate().to("http://localhost:8080");
		homePage = PageFactory.initElements(browser, HomePage.class);
		registracijaPage = PageFactory.initElements(browser, RegistracijaPage.class);
		
	}
	
	

	
	@Test
	public void testRegistracijaClick() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		Thread.sleep(1000);
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
			
		
	
		Thread.sleep(1500);
		
	
	}
	
	
	@Test
	public void testRegistracijaOK() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		Thread.sleep(1000);
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
		
		
		registracijaPage.setInputIme("TestE2E");
		registracijaPage.setInputPrezime("teste2e");
		registracijaPage.setInputEmail("testE2E@kts.com");
		registracijaPage.setInputPassword("test");
		registracijaPage.setInputPasswordRepeat("test");
		
		
		registracijaPage.getOkButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		
		Thread.sleep(1500);

	}
	@Test
	public void testRegistracijaNoPasswordRepeat() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		Thread.sleep(1000);
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
		
		
		registracijaPage.setInputIme("TestE2E");
		registracijaPage.setInputPrezime("teste2e");
		registracijaPage.setInputEmail("testE2E@kts.com");
		registracijaPage.setInputPassword("test");
		registracijaPage.getPasswordRepeatField().clear();
		
		
		assertFalse(registracijaPage.getOkButton().isEnabled());
	}
	
	
	@Test
	public void testRegistracijaNoPassword() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		Thread.sleep(1000);
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
		
		
		registracijaPage.setInputIme("TestE2E");
		registracijaPage.setInputPrezime("teste2e");
		registracijaPage.setInputEmail("testE2E@kts.com");
		registracijaPage.getPasswordField().clear();
		registracijaPage.setInputPasswordRepeat("test");
		
		assertFalse(registracijaPage.getOkButton().isEnabled());
		
		Thread.sleep(1500);

	}
	
	@Test
	public void testRegistracijaNoMail() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
		
		
		registracijaPage.setInputIme("TestE2E");
		registracijaPage.setInputPrezime("teste2e");
		registracijaPage.getEmailField().clear();
		registracijaPage.setInputPassword("test");
		registracijaPage.setInputPasswordRepeat("test");
		
		
		assertFalse(registracijaPage.getOkButton().isEnabled());
		
		
		Thread.sleep(1500);

	}
	
	@Test
	public void testRegistracijaNoPrezime() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		Thread.sleep(1000);
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
		
		
		registracijaPage.setInputIme("TestE2E");
		registracijaPage.getPrezimeField().clear();;
		registracijaPage.setInputEmail("testE2E@kts.com");
		registracijaPage.setInputPassword("test");
		registracijaPage.setInputPasswordRepeat("test");
		
		
		assertFalse(registracijaPage.getOkButton().isEnabled());
		
		
		Thread.sleep(1500);

	}
	
	@Test
	public void testRegistracijaNoName() throws InterruptedException {
		// check is HomePage OK
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		Thread.sleep(1000);
		//check LoginButton and Click
		homePage.ensureRegistracijaIsDisplayed();
		homePage.getRegistracijaButton().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/registracija", browser.getCurrentUrl());
		
		//check page objects
		registracijaPage.ensureImeFieldiSPresent();
		registracijaPage.ensurePrezimeFieldiSPresent();
		registracijaPage.ensurePassWordFieldiSPresent();
		registracijaPage.ensureUserNameFieldiSPresent();
		registracijaPage.ensurePasswordRepeatFieldiSPresent();
		
		registracijaPage.getImeField().clear();
		registracijaPage.setInputPrezime("teste2e");
		registracijaPage.setInputEmail("testFail@kts.com");
		registracijaPage.setInputPassword("test");
		registracijaPage.setInputPasswordRepeat("test");
		
		
		assertFalse(registracijaPage.getOkButton().isEnabled());
		
		
		Thread.sleep(1500);

	}
	

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}	
}
