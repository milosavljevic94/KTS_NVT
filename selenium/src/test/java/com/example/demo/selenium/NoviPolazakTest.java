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

public class NoviPolazakTest {
	
	private WebDriver browser;
	
	HomePage homePage;
	AfterLoginZaposleniPage afterLoginZaposleniPage;
	NoviPolazakPage noviPolazakPage;
	
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
		noviPolazakPage = PageFactory.initElements(browser, NoviPolazakPage.class);
		
	}
	
	

	
	@Test
	public void testAddPolazakRadniDan() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNoviPolazakButton().click();
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addPolazak", browser.getCurrentUrl());
		
		noviPolazakPage.ensureSelectDanIsPresent();
		noviPolazakPage.ensureVremeFieldIsPresent();
		
		Select sel=new Select(noviPolazakPage.getSelectDan());
        sel.selectByValue("Radni dan");
        
        noviPolazakPage.setInputVreme("11:11");
        
        noviPolazakPage.getSubmitButton().click();
		
	}
	
	@Test
	public void testAddPolazakSubota() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNoviPolazakButton().click();
		

		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addPolazak", browser.getCurrentUrl());
		
	
		noviPolazakPage.ensureSelectDanIsPresent();
		noviPolazakPage.ensureVremeFieldIsPresent();

		
		Select sel=new Select(noviPolazakPage.getSelectDan());
        sel.selectByValue("Subota");
        
        noviPolazakPage.setInputVreme("11:11");
        
        noviPolazakPage.getSubmitButton().click();
		
	}
	
	@Test
	public void testAddPolazakNedelja() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNoviPolazakButton().click();
		
		
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addPolazak", browser.getCurrentUrl());
		
		
		
		noviPolazakPage.ensureSelectDanIsPresent();
		noviPolazakPage.ensureVremeFieldIsPresent();
		
	
		Select sel=new Select(noviPolazakPage.getSelectDan());
        sel.selectByValue("Nedelja");
        
        noviPolazakPage.setInputVreme("11:11");
        
        noviPolazakPage.getSubmitButton().click();
		
	}
	
	@Test
	public void testAddPolazakNoTime() throws InterruptedException { 
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
		
		afterLoginZaposleniPage.getNoviPolazakButton().click();
		
		
		
		Thread.sleep(1000);
		
		assertEquals("http://localhost:8080/#!/addPolazak", browser.getCurrentUrl());
		
		
		
		noviPolazakPage.ensureSelectDanIsPresent();
		noviPolazakPage.ensureVremeFieldIsPresent();
		
	
		Select sel=new Select(noviPolazakPage.getSelectDan());
		
        sel.selectByValue("Nedelja");
        
        noviPolazakPage.getVremeField().clear();
        assertFalse(noviPolazakPage.getSubmitButton().isEnabled());
        
        //noviPolazakPage.getSubmitButton().click();
		
	}
	
	
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
}