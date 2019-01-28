package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovoStajalistePage {

	String APP_TITLE = "Gradski Prevoz";
	String APP_URL = "http://localhost:8080/#!/addStajaliste";
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"naziv\"]")
	private WebElement naziv;
	
	@FindBy(xpath = "//*[@id=\"lokacijaX\"]")
	private WebElement lokacijaX;
	
	@FindBy(xpath = "//*[@id=\"lokacijaY\"]")
	private WebElement lokacijaY;
	
	@FindBy(xpath = "//*[@id=\"adresa\"]")
	private WebElement adresa;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[4]/td/button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"stajalisteSuccess\"]")
	private WebElement stajalisteSuccess;

	public NovoStajalistePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		WebElement el = getNaziv();
		el.clear();
		el.sendKeys(naziv);
	}

	public WebElement getLokacijaX() {
		return lokacijaX;
	}

	public void setLokacijaX(String lokacijaX) {
		WebElement el = getLokacijaX();
		el.clear();
		el.sendKeys(lokacijaX);
	}

	public WebElement getLokacijaY() {
		return lokacijaY;
	}

	public void setLokacijaY(String lokacijaY) {
		WebElement el = getLokacijaY();
		el.clear();
		el.sendKeys(lokacijaY);
	}

	public WebElement getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		WebElement el = getAdresa();
		el.clear();
		el.sendKeys(adresa);
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getStajalisteSuccess() {
		return stajalisteSuccess;
	}
	
	protected void isLoaded() throws Error {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, APP_TITLE);
	}
	
	protected void load() {
		driver.get(APP_URL);
	}
	
	public void ensureNazivFieldIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(naziv));
	}
	
	public void ensureLokacijaXFieldIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lokacijaX));
	}
	
	public void ensureLokacijaYFieldIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(lokacijaY));
	}
	
	public void ensureAdresaFieldIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(adresa));
	}
	
	public void ensureSubmitButtonIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(submitButton));
	}
	
	public void ensureSubmitButtonIsClickable() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(submitButton));
	}
	
	public void ensureStajalisteSuccessIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(stajalisteSuccess));
	}
	
}
