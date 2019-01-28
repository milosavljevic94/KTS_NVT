package com.example.demo.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginZaposleniTest {
	
		private WebDriver browser;
		
		HomePage homePage;
		AfterLoginZaposleniPage afterLoginZaposleniPage;
		
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
			
		}
		
		
		@Test
		public void testClickLoginZaposleni() throws InterruptedException {
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
			
			
			
			Thread.sleep(1000);
			
		
		}
		
		
		@Test
		public void testClickOdjavaZaposleni() throws InterruptedException {
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
			
			
			afterLoginZaposleniPage.getOdjavaButton().click();
			Thread.sleep(1000);
			assertTrue(homePage.getButtonPrijava().isDisplayed());
			assertTrue(homePage.getRegistracijaButton().isDisplayed());
			
			assertEquals("Prijava", homePage.getButtonPrijava().getText());
			assertEquals("Registracija", homePage.getRegistracijaButton().getText());
			
			
			Thread.sleep(1000);
			
		
		}
		
		@AfterMethod
		public void closeSelenium() {
			// Shutdown the browser
			browser.quit();
		}
			
}
