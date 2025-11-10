package com.PracticeAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PracticeAutomation.utils.Userdata;
import java.util.*;

public class DemoSitePage {
	
	static WebDriver driver;
	
	public DemoSitePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// click on demo site link
	@FindBy(xpath="//*[text()='Demo Site']")
	private static WebElement demositelink;
	// enter fistname
	@FindBy(xpath="//input[@placeholder='First Name']")
	private static WebElement firstNameholder;
	// enter lastname
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private static WebElement lastNameholder;
	// enter address
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	private static WebElement address;
	// enter email
	@FindBy(xpath="//input[@ng-model='EmailAdress']")
	private static  WebElement emailid;
	@FindBy(xpath="//input[@ng-model='Phone']")
	private static WebElement phoneno;
	@FindBy(xpath="//input[@value='Male']")
	private static WebElement gender;
	@FindBy(xpath="//input[@type='checkbox']")
	private static WebElement hobbies;
	
	
	// Functions
	public static void checkboxes() {
	
		List<WebElement> options = hobbies.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement option : options) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", option);
	        js.executeScript("arguments[0].click();", option);
			//option.click();
		}
		
	}
	public static void registerUser(Userdata user) {
		demositelink.click();
		firstNameholder.sendKeys(user.getFirstName());
		lastNameholder.sendKeys(user.getLastName());
		address.sendKeys(user.getAddress());
		emailid.sendKeys(user.getEmail());
		phoneno.sendKeys(user.getPhone());
		gender.click();
		checkboxes();
	}

}
