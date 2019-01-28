package com.example.demo.selenium;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HomePageTest {
private WebDriver browser;
	
	HomePage homePage;
	
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
		
	}
	
	
	@Test
	public void testClickLogin() throws InterruptedException {
		// check is HomePage OK
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
		
		homePage.setInputEmail("test@kts.com");
		homePage.setInputPassword("test");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/", browser.getCurrentUrl());
		//homePage.korisnikStatusFieldisVisible();
		
		Thread.sleep(1500);
		
	
	}
	
	@Test
	public void testClickLoginBadPassWord() throws InterruptedException {
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
		
		homePage.setInputEmail("test@kts.com");
		homePage.setInputPassword("losPassword");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());


		assertEquals("Prijava nije uspela, pokušajte ponovo.", homePage.getErrorMessage().getText());
		
		Thread.sleep(1500);
		
	}
	
	@Test
	public void testClickLoginBadMail() throws InterruptedException {
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
		
		homePage.setInputEmail("losMail@kts.com");
		homePage.setInputPassword("test");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());


		assertEquals("Prijava nije uspela, pokušajte ponovo.", homePage.getErrorMessage().getText());
		
		Thread.sleep(1500);
	}

	@Test
	public void testClickLoginNoMail() throws InterruptedException {
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
		
		homePage.setInputEmail("");
		homePage.setInputPassword("losPassword");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertFalse(homePage.getSubmitButton().isEnabled());
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());

		
		Thread.sleep(1500);
	}
	
	
	@Test
	public void testClickLoginBadMailFormat() throws InterruptedException {
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
		
		homePage.setInputEmail("testkts.com");
		homePage.setInputPassword("test");
		
		
		homePage.getSubmitButton().click();
		Thread.sleep(1000);
		assertFalse(homePage.getSubmitButton().isEnabled());
		assertEquals("http://localhost:8080/#!/prijava", browser.getCurrentUrl());

		
		Thread.sleep(1500);
	}
	
	

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}	
}
