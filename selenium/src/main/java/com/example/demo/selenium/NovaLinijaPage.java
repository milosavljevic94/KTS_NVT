package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovaLinijaPage {
	
	String APP_TITLE = "Gradski Prevoz";
	String APP_URL = "http://localhost:8080/#!/addLinija";
	
	@FindBy(xpath = "//*[@id=\"broj\"]")
	private WebElement brojLinije;
	
	@FindBy(xpath = "//*[@id=\"naziv\"]")
	private WebElement nazivLinije;

	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[3]/button")
	private WebElement stajalisteButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[2]/select")
	private WebElement stajalisteDrop;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[4]/td[3]/button")
	private WebElement polasciButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[4]/td[2]/select")
	private WebElement polasciDrop;
	
	@FindBy(xpath = "//*[@id=\"tip\"]")
	private WebElement voziloDrop;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[6]/td/button")
	private WebElement submitButton;
	
	
	@FindBy(xpath = "//*[@id=\"linijaSuccess\"]")
	private WebElement message;
	
	



	public WebElement getSubmitButton() {
		return submitButton;
	}


	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}


	public WebElement getMessage() {
		return message;
	}


	public void setMessage(WebElement message) {
		this.message = message;
	}


	public WebElement getBrojLinije() {
		return brojLinije;
	}


	public void setBrojLinije(WebElement brojLinije) {
		this.brojLinije = brojLinije;
	}


	public WebElement getNazivLinije() {
		return nazivLinije;
	}


	public void setNazivLinije(WebElement nazivLinije) {
		this.nazivLinije = nazivLinije;
	}


	public WebElement getStajalisteButton() {
		return stajalisteButton;
	}


	public void setStajalisteButton(WebElement stajalisteButton) {
		this.stajalisteButton = stajalisteButton;
	}


	public WebElement getStajalisteDrop() {
		return stajalisteDrop;
	}


	public void setStajalisteDrop(WebElement stajalisteDrop) {
		this.stajalisteDrop = stajalisteDrop;
	}


	public WebElement getPolasciButton() {
		return polasciButton;
	}


	public void setPolasciButton(WebElement polasciButton) {
		this.polasciButton = polasciButton;
	}


	public WebElement getPolasciDrop() {
		return polasciDrop;
	}


	public void setPolasciDrop(WebElement polasciDrop) {
		this.polasciDrop = polasciDrop;
	}


	public WebElement getVoziloDrop() {
		return voziloDrop;
	}


	public void setVoziloDrop(WebElement voziloDrop) {
		this.voziloDrop = voziloDrop;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void setInputBrojLinije(String vreme) {
		WebElement el = getBrojLinije();
		el.clear();
		el.sendKeys(vreme);
	}
	
	public void setInputNazivLinije(String vreme) {
		WebElement el = getNazivLinije();
		el.clear();
		el.sendKeys(vreme);
	}
	
	
	private WebDriver driver;

	public NovaLinijaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	protected void isLoaded() throws Error {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, APP_TITLE);
	}
	
	
	protected void load() {
		driver.get(APP_URL);
	}
	
	public void ensureVremeFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(brojLinije));
	}
	
	public void ensureSelectDaniSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(nazivLinije));
	}
	
	public void ensureStajalisteButtonIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(stajalisteButton));
	}

	public void ensurePolasciButtonIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(polasciButton));
	}
	
	public void ensureMessageiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(message));
	}
	
	
	

	
	


}
