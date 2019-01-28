package com.example.demo.selenium;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NovaLinijaTest {
	
	
	private WebDriver browser;
	
	HomePage homePage;
	AfterLoginZaposleniPage afterLoginZaposleniPage;
	NovaLinijaPage novaLinijaPage;
	
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
		novaLinijaPage = PageFactory.initElements(browser, NovaLinijaPage.class);
		
	}
	
	

	
	@Test
	public void testAddLinija() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNovaLinijaButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addLinija", browser.getCurrentUrl());
		
		novaLinijaPage.ensurePolasciButtonIsPresent();
		novaLinijaPage.ensureSelectDaniSPresent();
		novaLinijaPage.ensureStajalisteButtonIsPresent();
		novaLinijaPage.ensureVremeFieldiSPresent();
		
		Random random = new Random();
		int x = random.nextInt(90) + 9;
		
		novaLinijaPage.setInputBrojLinije(String.valueOf(x));
		novaLinijaPage.setInputNazivLinije("TestLinija" + x);
		
		novaLinijaPage.getStajalisteButton().click();
		Thread.sleep(1500);
		
	    Select sel=new Select(novaLinijaPage.getStajalisteDrop());
	    sel.selectByIndex(1);
		
        
        novaLinijaPage.getPolasciButton().click();
        Thread.sleep(1500);
        
        Select sel2=new Select(novaLinijaPage.getPolasciDrop());
        sel2.selectByIndex(1);
         
        Thread.sleep(1500);
        Select sel3 = new Select(novaLinijaPage.getVoziloDrop());
        sel3.selectByValue("autobus");
        
        Thread.sleep(1000);
        novaLinijaPage.getSubmitButton().click();
        Thread.sleep(500);
        assertEquals(novaLinijaPage.getMessage().getText(), "Linija " + String.valueOf(x) + " TestLinija" + x + " uspešno dodata.");
        Thread.sleep(1000);
	}
	
	@Test
	public void testAddLinijaFail() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNovaLinijaButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addLinija", browser.getCurrentUrl());
		
		novaLinijaPage.ensurePolasciButtonIsPresent();
		novaLinijaPage.ensureSelectDaniSPresent();
		novaLinijaPage.ensureStajalisteButtonIsPresent();
		novaLinijaPage.ensureVremeFieldiSPresent();
		
		Random random = new Random();
		int x = random.nextInt(90) + 9;
		
		novaLinijaPage.setInputBrojLinije(String.valueOf(x));
		novaLinijaPage.setInputNazivLinije("TestLinija" + x);
		
		novaLinijaPage.getStajalisteButton().click();
		Thread.sleep(1500);
		
	    Select sel=new Select(novaLinijaPage.getStajalisteDrop());
	    sel.selectByIndex(1);
		
        
        novaLinijaPage.getPolasciButton().click();
        Thread.sleep(1500);
        
        Select sel2=new Select(novaLinijaPage.getPolasciDrop());
        sel2.selectByIndex(1);
         
      
        
        Thread.sleep(1000);
       
		assertFalse(novaLinijaPage.getSubmitButton().isEnabled());
        //assertEquals("Linija" + String.valueOf(x) + "sada uspešno dodata.", novaLinijaPage.getMessage().getText());
		
	}
	
	@Test
	public void testAddLinijaFail1() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNovaLinijaButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addLinija", browser.getCurrentUrl());
		
		novaLinijaPage.ensurePolasciButtonIsPresent();
		novaLinijaPage.ensureSelectDaniSPresent();
		novaLinijaPage.ensureStajalisteButtonIsPresent();
		novaLinijaPage.ensureVremeFieldiSPresent();
		
		Random random = new Random();
		int x = random.nextInt(90) + 9;
		
		novaLinijaPage.setInputBrojLinije(String.valueOf(x));
		novaLinijaPage.setInputNazivLinije("TestLinija" + x);

		assertFalse(novaLinijaPage.getSubmitButton().isEnabled());
        //assertEquals("Linija" + String.valueOf(x) + "sada uspešno dodata.", novaLinijaPage.getMessage().getText());
		
	}
	
	@Test
	public void testAddLinijaFail2() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNovaLinijaButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addLinija", browser.getCurrentUrl());
		
		novaLinijaPage.ensurePolasciButtonIsPresent();
		novaLinijaPage.ensureSelectDaniSPresent();
		novaLinijaPage.ensureStajalisteButtonIsPresent();
		novaLinijaPage.ensureVremeFieldiSPresent();
		
		
		Random random = new Random();
		int x = random.nextInt(90) + 9;
		
		novaLinijaPage.setInputNazivLinije("TestLinija" + x);
		
		novaLinijaPage.getStajalisteButton().click();
		Thread.sleep(1500);
		
	    Select sel=new Select(novaLinijaPage.getStajalisteDrop());
	    sel.selectByIndex(1);
		
        
        novaLinijaPage.getPolasciButton().click();
        Thread.sleep(1500);
        
        Select sel2=new Select(novaLinijaPage.getPolasciDrop());
        sel2.selectByIndex(1);
         
        Thread.sleep(1500);
        Select sel3 = new Select(novaLinijaPage.getVoziloDrop());
        sel3.selectByValue("autobus");
        
		
		

		assertFalse(novaLinijaPage.getSubmitButton().isEnabled());
        //assertEquals("Linija" + String.valueOf(x) + "sada uspešno dodata.", novaLinijaPage.getMessage().getText());
		
	}
	
	@Test
	public void testAddLinijaFail3() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNovaLinijaButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addLinija", browser.getCurrentUrl());
		
		novaLinijaPage.ensurePolasciButtonIsPresent();
		novaLinijaPage.ensureSelectDaniSPresent();
		novaLinijaPage.ensureStajalisteButtonIsPresent();
		novaLinijaPage.ensureVremeFieldiSPresent();
		
		
		Random random = new Random();
		int x = random.nextInt(90) + 9;
		
		novaLinijaPage.setInputBrojLinije(String.valueOf(x));
		
		novaLinijaPage.getStajalisteButton().click();
		Thread.sleep(1500);
		
	    Select sel=new Select(novaLinijaPage.getStajalisteDrop());
	    sel.selectByIndex(1);
		
        
        novaLinijaPage.getPolasciButton().click();
        Thread.sleep(1500);
        
        Select sel2=new Select(novaLinijaPage.getPolasciDrop());
        sel2.selectByIndex(1);
         
        Thread.sleep(1500);
        Select sel3 = new Select(novaLinijaPage.getVoziloDrop());
        sel3.selectByValue("autobus");
        
		
		

		assertFalse(novaLinijaPage.getSubmitButton().isEnabled());
        //assertEquals("Linija" + String.valueOf(x) + "sada uspešno dodata.", novaLinijaPage.getMessage().getText());
		
	}
	
	
	
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
}