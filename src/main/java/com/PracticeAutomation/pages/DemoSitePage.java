package com.PracticeAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	// languages
	@FindBy(xpath="//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']")
	private static WebElement languages;
	// Select skills
	@FindBy(xpath="//*[text()='Skills']")
	private static WebElement skillstab;
	@FindBy(xpath="//select[@id='Skills']")
	private static WebElement skillsdropdown;
	// Select country
	@FindBy(xpath="//span[@class='select2-selection select2-selection--single']")
	private static WebElement countrydropdown;
	
	
	
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
	// Select a language from drop down
	public static void selectLanguage() {
		languages.click();
		List<WebElement> listoflags = driver.findElements(By.cssSelector(".ui-corner-all"));
		System.out.println("Number of Languages available: " + listoflags.size());
		String selectlang = "Hindi";
		for (WebElement lang : listoflags) {
			if (lang.getText().equals(selectlang)) {
				lang.click();
				break;
			} 
		}
	}
	
	// Select  Skills from the dropdown
	public static void selectSkill() {
		skillstab.click();
		Select select = new Select(skillsdropdown);
		List<WebElement> alloptions = select.getOptions();
		System.out.println("All Available Skills : " + alloptions.size());
		//select.selectByVisibleText("Java");
		String skillneedtoselect = "Java";
		for (WebElement option : alloptions) {
			if (option.getText().equals(skillneedtoselect)) {
				option.click();
				break;
			}
		}
	}
	// Select Country
	public static void selectCountry() {
		countrydropdown.click();
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		System.out.println("Number of Countries Available : " + countryList.size());
		String india = "India";
		for (WebElement country : countryList) {
			
			if (country.getText().equals(india)) {
				country.click();
				break;
			} else {
				System.out.println("Country is not available");
			}
		}
	}
	
	// Select a date
	public static void selectDate() {
		
		// select year
		WebElement yeardown = driver.findElement(By.id("yearbox"));
		Select selectYear = new Select(yeardown);
		selectYear.selectByVisibleText("1991");
		// select month
		WebElement selectmonth = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
		Select selectMonth = new Select(selectmonth);
		selectMonth.selectByVisibleText("March");
		// select day
		WebElement selectdate = driver.findElement(By.id("daybox"));
		Select selectDate = new Select(selectdate);
		selectDate.selectByVisibleText("12");
	}
	
	// Enter the password
	public static void enterPassword() {
		
		WebElement password = driver.findElement(By.id("firstpassword"));
		password.sendKeys("inde@4221");
		WebElement confirmPassword = driver.findElement(By.id("secondpassword"));
		confirmPassword.sendKeys("inde@4221");
		
		// click on submit
		driver.findElement(By.id("submitbtn")).click();
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
		selectLanguage();
		selectSkill();
		selectCountry();
		selectDate();
		enterPassword();
		
	}

}
