package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoviPolazakPage {
	
	String APP_TITLE = "Gradski Prevoz";
	String APP_URL = "http://localhost:8080/#!/addPolazak";
	
	@FindBy(xpath = "//*[@id=\"dan\"]")
	private WebElement selectDan;
	
	@FindBy(xpath = "//*[@id=\"vreme\"]")
	private WebElement vremeField;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td/button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"polazakSuccess\"]")
	private WebElement messageField;

	public WebElement getSelectDan() {
		return selectDan;
	}

	public void setSelectDan(WebElement selectDan) {
		this.selectDan = selectDan;
	}

	public WebElement getVremeField() {
		return vremeField;
	}

	public void setVremeField(WebElement vremeField) {
		this.vremeField = vremeField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

	public WebElement getMessageField() {
		return messageField;
	}

	public void setMessageField(WebElement messageField) {
		this.messageField = messageField;
	}
	
	public void setInputVreme(String vreme) {
		WebElement el = getVremeField();
		el.clear();
		el.sendKeys(vreme);
	}
	
	private WebDriver driver;

	public NoviPolazakPage(WebDriver driver) {
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
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(vremeField));
	}
	
	public void ensureSelectDaniSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(selectDan));
	}
	
	public void ensureSubmitPolazakiSPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(submitButton));
	}

	
	

	
	


}