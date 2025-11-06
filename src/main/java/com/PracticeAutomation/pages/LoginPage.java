package com.PracticeAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locate WebElement
	@FindBy(xpath = "//*[text()='My Account']")
	private WebElement myaccountlink;
	@FindBy(id = "username")
	private WebElement usernamefield;
	@FindBy(id="password")
	private WebElement passwordfield;
	@FindBy(xpath = "//input[@name='login']")
	private WebElement loginbutton;
	
	// Functions
	public void clickonMyAccount() {
		myaccountlink.click();
	}
	public void enterUsername(String username) {
		usernamefield.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	public void clickonlogin() {
		loginbutton.click();
	}
	
	// validation message
	@FindBy(xpath = "//*[text()='indesuraj']")
	private WebElement userverify;
	
	public void login(String username, String password) {
		clickonMyAccount();
		enterUsername(username);
		enterPassword(password);
		clickonlogin();
	}
	
	public String showsusername() {
		return userverify.getText();
	}

}
