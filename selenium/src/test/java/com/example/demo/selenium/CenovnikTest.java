package com.example.demo.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CenovnikTest {
	
	
	private WebDriver browser;
	
	HomePage homePage;
	AfterLoginZaposleniPage afterLoginZaposleniPage;
	CenovnikPage cenovnikPage;
	
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
		cenovnikPage = PageFactory.initElements(browser, CenovnikPage.class);
		
	}
	
	

	
	@Test
	public void testKupiJednokratnu() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getCenovnikButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/cenovnik", browser.getCurrentUrl());

		cenovnikPage.ensureJednokratnaButtonIsPresent();
		cenovnikPage.ensureDnevnaButtonPresent();
		cenovnikPage.ensureMesecnaButtonIsPresent();
		cenovnikPage.ensureGodisnjaButtonIsPresent();
		
		cenovnikPage.getKupiJednokratnuButton().click();
		
        

        Thread.sleep(1000);
        
        assertTrue(cenovnikPage.getMessage().isDisplayed());
        
       
	}
	
	@Test
	public void testKupiDnevnu() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getCenovnikButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/cenovnik", browser.getCurrentUrl());

		cenovnikPage.ensureJednokratnaButtonIsPresent();
		cenovnikPage.ensureDnevnaButtonPresent();
		cenovnikPage.ensureMesecnaButtonIsPresent();
		cenovnikPage.ensureGodisnjaButtonIsPresent();
		
		cenovnikPage.getKupiDnevnuButton().click();
		
        

        Thread.sleep(1000);
        
        assertTrue(cenovnikPage.getMessage().isDisplayed());
        
       
	}
	
	@Test
	public void testKupiMesecnu() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getCenovnikButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/cenovnik", browser.getCurrentUrl());

		cenovnikPage.ensureJednokratnaButtonIsPresent();
		cenovnikPage.ensureDnevnaButtonPresent();
		cenovnikPage.ensureMesecnaButtonIsPresent();
		cenovnikPage.ensureGodisnjaButtonIsPresent();
		
		cenovnikPage.getKupiMesecnuButton().click();
		
        

        Thread.sleep(1000);
        
        assertTrue(cenovnikPage.getMessage().isDisplayed());
        
       
	}
	
	@Test
	public void testKupiGodisnju() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getCenovnikButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/cenovnik", browser.getCurrentUrl());

		cenovnikPage.ensureJednokratnaButtonIsPresent();
		cenovnikPage.ensureDnevnaButtonPresent();
		cenovnikPage.ensureMesecnaButtonIsPresent();
		cenovnikPage.ensureGodisnjaButtonIsPresent();
		
		cenovnikPage.getKupiGodisnjuButton().click();
		
        

        Thread.sleep(1000);
        
        assertTrue(cenovnikPage.getMessage().isDisplayed());
        
       
	}
	
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
}