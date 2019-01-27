package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistracijaPage {
	
	String APP_URL = "http://localhost:8080/#!/registracija";
	String APP_TITLE = "Gradski Prevoz";
	
	
	// Page Elements.
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[3]")
	private WebElement registracijaButton;
	
	@FindBy(xpath = "//*[@id=\"ime\"]")
	private WebElement imeField;

	@FindBy(xpath = "//*[@id=\"prezime\"]")
	private WebElement prezimeField;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement emailField;
	
	
	@FindBy(xpath = "//*[@id=\"lozinka\"]")
	private WebElement passwordField;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/form/input[5]")
	private WebElement passwordRepeatField;
	
	
	
	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	private WebElement okButton;
		
	
	

	

	
	public WebElement getPasswordRepeatField() {
		return passwordRepeatField;
	}


	public void setPasswordRepeatField(WebElement passwordRepeatField) {
		this.passwordRepeatField = passwordRepeatField;
	}


	public WebElement getRegistracijaButton() {
		return registracijaButton;
	}


	public void setRegistracijaButton(WebElement registracijaButton) {
		this.registracijaButton = registracijaButton;
	}


	public WebElement getImeField() {
		return imeField;
	}


	public void setImeField(WebElement imeField) {
		this.imeField = imeField;
	}


	public WebElement getPrezimeField() {
		return prezimeField;
	}


	public void setPrezimeField(WebElement prezimeField) {
		this.prezimeField = prezimeField;
	}


	public WebElement getEmailField() {
		return emailField;
	}


	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}


	public WebElement getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(WebElement passwordField) {
		this.passwordField = passwordField;
	}


	public WebElement getOkButton() {
		return okButton;
	}


	public void setOkButton(WebElement okButton) {
		this.okButton = okButton;
	}


	public void setInputIme(String userName) {
		WebElement el = getImeField();
		el.clear();
		el.sendKeys(userName);
	}
	
	public void setInputPrezime(String userName) {
		WebElement el = getPrezimeField();
		el.clear();
		el.sendKeys(userName);
	}
	

	public void setInputEmail(String userName) {
		WebElement el = getEmailField();
		el.clear();
		el.sendKeys(userName);
	}
	
	public void setInputPassword(String passWord) {
		WebElement el = getPasswordField();
		el.clear();
		el.sendKeys(passWord);
	}
	
	public void setInputPasswordRepeat(String passWord) {
		WebElement el = getPasswordRepeatField();
		el.clear();
		el.sendKeys(passWord);
	}

	public void registracijaIsDisplayed() {
		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.elementToBeClickable(registracijaButton));
	}

	
	public void ensureImeFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(imeField));
	}

	
	public void ensurePrezimeFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(prezimeField));
	}
	
	public void ensurePasswordRepeatFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(passwordRepeatField));
	}
	
	
	public void ensureUserNameFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(emailField));
	}

	
	public void ensurePassWordFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(passwordField));
	}
	
	public void ensureOKButtonIsClickable() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(okButton));
	}
	
	public void SubmitensureIsDisplayed() {
		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.elementToBeClickable(okButton));
	}
	

	private WebDriver driver;

	public RegistracijaPage(WebDriver driver) {
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
	



	
}
