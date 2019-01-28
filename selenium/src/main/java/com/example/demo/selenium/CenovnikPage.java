package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenovnikPage {
	
	String APP_TITLE = "Gradski Prevoz";
	String APP_URL = "http://localhost:8080/#!/cenovnik";
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/table")
	private WebElement tabela;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/table/tbody/tr[2]/td[3]/button")
	private WebElement kupiJednokratnuButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/table/tbody/tr[3]/td[3]/button")
	private WebElement kupiDnevnuButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/table/tbody/tr[4]/td[3]/button")
	private WebElement kupiMesecnuButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/table/tbody/tr[5]/td[3]/button")
	private WebElement kupiGodisnjuButton;
	
	@FindBy(xpath = "//*[@id=\"kartaSuccess\"]")
	private WebElement message;
	
	




	

	public WebElement getTabela() {
		return tabela;
	}


	public void setTabela(WebElement tabela) {
		this.tabela = tabela;
	}


	public WebElement getKupiJednokratnuButton() {
		return kupiJednokratnuButton;
	}


	public void setKupiJednokratnuButton(WebElement kupiJednokratnuButton) {
		this.kupiJednokratnuButton = kupiJednokratnuButton;
	}


	public WebElement getKupiDnevnuButton() {
		return kupiDnevnuButton;
	}


	public void setKupiDnevnuButton(WebElement kupiDnevnuButton) {
		this.kupiDnevnuButton = kupiDnevnuButton;
	}


	public WebElement getKupiMesecnuButton() {
		return kupiMesecnuButton;
	}


	public void setKupiMesecnuButton(WebElement kupiMesecnuButton) {
		this.kupiMesecnuButton = kupiMesecnuButton;
	}


	public WebElement getKupiGodisnjuButton() {
		return kupiGodisnjuButton;
	}


	public void setKupiGodisnjuButton(WebElement kupiGodisnjuButton) {
		this.kupiGodisnjuButton = kupiGodisnjuButton;
	}


	public WebElement getMessage() {
		return message;
	}


	public void setMessage(WebElement message) {
		this.message = message;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}



	
	private WebDriver driver;

	public CenovnikPage(WebDriver driver) {
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
	
	public void ensureJednokratnaButtonIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(kupiJednokratnuButton));
	}
	
	public void ensureDnevnaButtonPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(kupiDnevnuButton));
	}
	
	public void ensureMesecnaButtonIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(kupiMesecnuButton));
	}

	public void ensureGodisnjaButtonIsPresent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(kupiGodisnjuButton));
	}
	
	
	
	

	
	


}
