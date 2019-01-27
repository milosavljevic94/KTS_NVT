package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
		
	String APP_TITLE = "Gradski Prevoz";
	
	
	// Page Elements.
	

	@FindBy(xpath = "/html/body/div[1]/div/div/a[2]")
	private WebElement buttonPrijava;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement emailField;

	@FindBy(xpath = "//*[@id=\"lozinka\"]")
	private WebElement passwordField;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"error\"]")
	private WebElement errorMessage;
	
	
	public WebElement getButtonPrijava() {
		return buttonPrijava;
	}


	public void setButtonPrijava(WebElement buttonPrijava) {
		this.buttonPrijava = buttonPrijava;
	}


	public WebElement getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(WebElement passwordField) {
		this.passwordField = passwordField;
	}


	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}


	public void setErrorMessage(WebElement errorMessage) {
		this.errorMessage = errorMessage;
	}


	public WebElement getEmailField() {
		return emailField;
	}


	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}


	public WebElement getSubmitButton() {
		return submitButton;
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
	
	public void prijavaIsDisplayed() {
		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.elementToBeClickable(buttonPrijava));
	}
	
	public void ensureUserNameFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(emailField));
	}

	
	public void ensurePassWordFieldiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(passwordField));
	}
	
	public void ensureSubmitButtonIsClickable() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(submitButton));
	}
	
	public void SubmitensureIsDisplayed() {
		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.elementToBeClickable(submitButton));
	}
	

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	protected void isLoaded() throws Error {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, APP_TITLE);
	}
	
	
	protected void load() {
		
	}
	



	
}
