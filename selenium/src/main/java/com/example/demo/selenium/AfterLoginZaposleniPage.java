package com.example.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AfterLoginZaposleniPage {
	
	String APP_URL = "http://localhost:8080/#!/";
	String APP_TITLE = "Gradski Prevoz";
	
	
	// Page Elements.
	

	@FindBy(xpath = "/html/body/div[1]/div/div/a[1]")
	private WebElement redVoznjeButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[2]")
	private WebElement noviPolazakButton;

	@FindBy(xpath = "/html/body/div[1]/div/div/a[3]")
	private WebElement novoStajalisteButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[4]")
	private WebElement novaLinijaButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[5]")
	private WebElement korisniciButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[6]")
	private WebElement cenovnikButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[7]")
	private WebElement mojeKarteButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[8]")
	private WebElement korisnikStatus;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/a[9]")
	private WebElement odjavaButton;

	public WebElement getRedVoznjeButton() {
		return redVoznjeButton;
	}

	public void setRedVoznjeButton(WebElement redVoznjeButton) {
		this.redVoznjeButton = redVoznjeButton;
	}

	public WebElement getNoviPolazakButton() {
		return noviPolazakButton;
	}

	public void setNoviPolazakButton(WebElement noviPolazakButton) {
		this.noviPolazakButton = noviPolazakButton;
	}

	public WebElement getNovoStajalisteButton() {
		return novoStajalisteButton;
	}

	public void setNovoStajalisteButton(WebElement novoStajalisteButton) {
		this.novoStajalisteButton = novoStajalisteButton;
	}

	public WebElement getNovaLinijaButton() {
		return novaLinijaButton;
	}

	public void setNovaLinijaButton(WebElement novaLinijaButton) {
		this.novaLinijaButton = novaLinijaButton;
	}

	public WebElement getKorisniciButton() {
		return korisniciButton;
	}

	public void setKorisniciButton(WebElement korisniciButton) {
		this.korisniciButton = korisniciButton;
	}

	public WebElement getCenovnikButton() {
		return cenovnikButton;
	}

	public void setCenovnikButton(WebElement cenovnikButton) {
		this.cenovnikButton = cenovnikButton;
	}

	public WebElement getMojeKarteButton() {
		return mojeKarteButton;
	}

	public void setMojeKarteButton(WebElement mojeKarteButton) {
		this.mojeKarteButton = mojeKarteButton;
	}

	public WebElement getKorisnikStatus() {
		return korisnikStatus;
	}

	public void setKorisnikStatus(WebElement korisnikStatus) {
		this.korisnikStatus = korisnikStatus;
	}

	public WebElement getOdjavaButton() {
		return odjavaButton;
	}

	public void setOdjavaButton(WebElement odjavaButton) {
		this.odjavaButton = odjavaButton;
	}
	
	private WebDriver driver;

	public AfterLoginZaposleniPage(WebDriver driver) {
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
	
	public void isRedVoznjeButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(redVoznjeButton));
	}
	
	public void isNoviPolazakButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(noviPolazakButton));
	}
	
	public void isNovoStajalisteButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(novoStajalisteButton));
	}
	
	public void isNovaLinijaButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(novaLinijaButton));
	}
	
	public void isKorisniciButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(korisniciButton));
	}
	
	public void isCenovnikButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(cenovnikButton));
	}
	
	public void isMojeKarteButtonVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(mojeKarteButton));
	}
	
	public void isKorisnikStatusFieldisVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(korisnikStatus));
	}
	
	public void isOdjavaButtonFieldisVisible() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(odjavaButton));
	}

}
