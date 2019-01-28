package com.example.demo.selenium;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NovoStajalisteTest {
	
	private WebDriver browser;
	
	HomePage homePage;
	AfterLoginZaposleniPage afterLoginZaposleniPage;
	NovoStajalistePage novoStajalistePage;
	
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
		afterLoginZaposleniPage = PageFactory.initElements(browser, AfterLoginZaposleniPage.class);
		novoStajalistePage = PageFactory.initElements(browser, NovoStajalistePage.class);
		
	}
	
	

	
	@Test
	public void testAddStajalisteSuccess() throws InterruptedException { 
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		//check LoginButton and Click
		homePage.prijavaIsDisplayed();
		homePage.getButtonPrijava().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());
		
		//check page objects
		homePage.ensurePassWordFieldiSPresent();
		homePage.ensureUserNameFieldiSPresent();
		//homePage.ensureSubmitButtonIsClickable();
		
		homePage.setInputEmail("zaposleni@kts.com");
		homePage.setInputPassword("a");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		afterLoginZaposleniPage.isRedVoznjeButtonVisible();
		afterLoginZaposleniPage.isNoviPolazakButtonVisible();
		afterLoginZaposleniPage.isNovoStajalisteButtonVisible();
		afterLoginZaposleniPage.isNovaLinijaButtonVisible();
		afterLoginZaposleniPage.isKorisniciButtonVisible();
		afterLoginZaposleniPage.isMojeKarteButtonVisible();
		afterLoginZaposleniPage.isOdjavaButtonFieldisVisible();
		
		afterLoginZaposleniPage.getNovoStajalisteButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addStajaliste", browser.getCurrentUrl());
		
		novoStajalistePage.ensureNazivFieldIsPresent();
		novoStajalistePage.ensureLokacijaXFieldIsPresent();
		novoStajalistePage.ensureLokacijaYFieldIsPresent();
		novoStajalistePage.ensureAdresaFieldIsPresent();
        
        novoStajalistePage.setNaziv("Test Naziv Stajalista");
        novoStajalistePage.setLokacijaX("35.5");
        novoStajalistePage.setLokacijaY("35.5");
        novoStajalistePage.setAdresa("Test Adresa Stajalista");
        
        novoStajalistePage.ensureSubmitButtonIsPresent();
        novoStajalistePage.ensureSubmitButtonIsClickable();
        novoStajalistePage.getSubmitButton().click();
        
        novoStajalistePage.ensureStajalisteSuccessIsPresent();
        
        assertEquals("Stajalište Test Naziv Stajalista na adresi Test Adresa Stajalista uspešno dodato.", novoStajalistePage.getStajalisteSuccess().getText());

		
	}
	
	@Test
	public void testAddPolazakNoNaziv() throws InterruptedException { 
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		//check LoginButton and Click
		homePage.prijavaIsDisplayed();
		homePage.getButtonPrijava().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());
		
		//check page objects
		homePage.ensurePassWordFieldiSPresent();
		homePage.ensureUserNameFieldiSPresent();
		//homePage.ensureSubmitButtonIsClickable();
		
		homePage.setInputEmail("zaposleni@kts.com");
		homePage.setInputPassword("a");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		afterLoginZaposleniPage.isRedVoznjeButtonVisible();
		afterLoginZaposleniPage.isNoviPolazakButtonVisible();
		afterLoginZaposleniPage.isNovoStajalisteButtonVisible();
		afterLoginZaposleniPage.isNovaLinijaButtonVisible();
		afterLoginZaposleniPage.isKorisniciButtonVisible();
		afterLoginZaposleniPage.isMojeKarteButtonVisible();
		afterLoginZaposleniPage.isOdjavaButtonFieldisVisible();
		
		afterLoginZaposleniPage.getNovoStajalisteButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addStajaliste", browser.getCurrentUrl());
		
		novoStajalistePage.ensureNazivFieldIsPresent();
		novoStajalistePage.ensureLokacijaXFieldIsPresent();
		novoStajalistePage.ensureLokacijaYFieldIsPresent();
		novoStajalistePage.ensureAdresaFieldIsPresent();
        
        //novoStajalistePage.setNaziv("Test Naziv Stajalista");
		novoStajalistePage.getNaziv().clear();
        novoStajalistePage.setLokacijaX("35.5");
        novoStajalistePage.setLokacijaY("35.5");
        novoStajalistePage.setAdresa("Test Adresa Stajalista");
        
        novoStajalistePage.ensureSubmitButtonIsPresent();
        
        assertFalse(novoStajalistePage.getSubmitButton().isEnabled());
		
	}
	
	@Test
	public void testAddPolazakNoLokacijaX() throws InterruptedException { 
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		//check LoginButton and Click
		homePage.prijavaIsDisplayed();
		homePage.getButtonPrijava().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());
		
		//check page objects
		homePage.ensurePassWordFieldiSPresent();
		homePage.ensureUserNameFieldiSPresent();
		//homePage.ensureSubmitButtonIsClickable();
		
		homePage.setInputEmail("zaposleni@kts.com");
		homePage.setInputPassword("a");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		afterLoginZaposleniPage.isRedVoznjeButtonVisible();
		afterLoginZaposleniPage.isNoviPolazakButtonVisible();
		afterLoginZaposleniPage.isNovoStajalisteButtonVisible();
		afterLoginZaposleniPage.isNovaLinijaButtonVisible();
		afterLoginZaposleniPage.isKorisniciButtonVisible();
		afterLoginZaposleniPage.isMojeKarteButtonVisible();
		afterLoginZaposleniPage.isOdjavaButtonFieldisVisible();
		
		afterLoginZaposleniPage.getNovoStajalisteButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addStajaliste", browser.getCurrentUrl());
		
		novoStajalistePage.ensureNazivFieldIsPresent();
		novoStajalistePage.ensureLokacijaXFieldIsPresent();
		novoStajalistePage.ensureLokacijaYFieldIsPresent();
		novoStajalistePage.ensureAdresaFieldIsPresent();
        
        novoStajalistePage.setNaziv("Test Naziv Stajalista");
        //novoStajalistePage.setLokacijaX("35.5");
        novoStajalistePage.getLokacijaX().clear();
        novoStajalistePage.setLokacijaY("35.5");
        novoStajalistePage.setAdresa("Test Adresa Stajalista");
        
        novoStajalistePage.ensureSubmitButtonIsPresent();
        
        assertFalse(novoStajalistePage.getSubmitButton().isEnabled());
		
	}
	
	@Test
	public void testAddPolazakNoLokacijaY() throws InterruptedException { 
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		//check LoginButton and Click
		homePage.prijavaIsDisplayed();
		homePage.getButtonPrijava().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());
		
		//check page objects
		homePage.ensurePassWordFieldiSPresent();
		homePage.ensureUserNameFieldiSPresent();
		//homePage.ensureSubmitButtonIsClickable();
		
		homePage.setInputEmail("zaposleni@kts.com");
		homePage.setInputPassword("a");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		afterLoginZaposleniPage.isRedVoznjeButtonVisible();
		afterLoginZaposleniPage.isNoviPolazakButtonVisible();
		afterLoginZaposleniPage.isNovoStajalisteButtonVisible();
		afterLoginZaposleniPage.isNovaLinijaButtonVisible();
		afterLoginZaposleniPage.isKorisniciButtonVisible();
		afterLoginZaposleniPage.isMojeKarteButtonVisible();
		afterLoginZaposleniPage.isOdjavaButtonFieldisVisible();
		
		afterLoginZaposleniPage.getNovoStajalisteButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addStajaliste", browser.getCurrentUrl());
		
		novoStajalistePage.ensureNazivFieldIsPresent();
		novoStajalistePage.ensureLokacijaXFieldIsPresent();
		novoStajalistePage.ensureLokacijaYFieldIsPresent();
		novoStajalistePage.ensureAdresaFieldIsPresent();
        
        novoStajalistePage.setNaziv("Test Naziv Stajalista");
        novoStajalistePage.setLokacijaX("35.5");
        //novoStajalistePage.setLokacijaY("35.5");
        novoStajalistePage.getLokacijaY().clear();
        novoStajalistePage.setAdresa("Test Adresa Stajalista");
        
        novoStajalistePage.ensureSubmitButtonIsPresent();
        
        assertFalse(novoStajalistePage.getSubmitButton().isEnabled());
		
	}
	
	@Test
	public void testAddPolazakNoAdresa() throws InterruptedException { 
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		//check LoginButton and Click
		homePage.prijavaIsDisplayed();
		homePage.getButtonPrijava().click();
		Thread.sleep(1500);
		//check is Page correct
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());
		
		//check page objects
		homePage.ensurePassWordFieldiSPresent();
		homePage.ensureUserNameFieldiSPresent();
		//homePage.ensureSubmitButtonIsClickable();
		
		homePage.setInputEmail("zaposleni@kts.com");
		homePage.setInputPassword("a");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		
		afterLoginZaposleniPage.isRedVoznjeButtonVisible();
		afterLoginZaposleniPage.isNoviPolazakButtonVisible();
		afterLoginZaposleniPage.isNovoStajalisteButtonVisible();
		afterLoginZaposleniPage.isNovaLinijaButtonVisible();
		afterLoginZaposleniPage.isKorisniciButtonVisible();
		afterLoginZaposleniPage.isMojeKarteButtonVisible();
		afterLoginZaposleniPage.isOdjavaButtonFieldisVisible();
		
		afterLoginZaposleniPage.getNovoStajalisteButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addStajaliste", browser.getCurrentUrl());
		
		novoStajalistePage.ensureNazivFieldIsPresent();
		novoStajalistePage.ensureLokacijaXFieldIsPresent();
		novoStajalistePage.ensureLokacijaYFieldIsPresent();
		novoStajalistePage.ensureAdresaFieldIsPresent();
        
        novoStajalistePage.setNaziv("Test Naziv Stajalista");
        novoStajalistePage.setLokacijaX("35.5");
        novoStajalistePage.setLokacijaY("35.5");
        //novoStajalistePage.setAdresa("Test Adresa Stajalista");
        novoStajalistePage.getAdresa().clear();
        
        novoStajalistePage.ensureSubmitButtonIsPresent();
        
        assertFalse(novoStajalistePage.getSubmitButton().isEnabled());
		
	}
	
	
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
}
