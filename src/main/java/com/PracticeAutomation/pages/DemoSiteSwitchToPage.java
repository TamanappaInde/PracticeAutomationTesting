package com.PracticeAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoSiteSwitchToPage {
	
	static WebDriver driver;
	
	public DemoSiteSwitchToPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Demo Site']")
	private static WebElement demositelink;
	
	// move to switch to tab
	public static void movetoSwitchTotab() {
		
		WebElement switchto = driver.findElement(By.xpath("//*[text()='SwitchTo']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(switchto);
	}
	public static void switchTo() {
		demositelink.click();
		movetoSwitchTotab();
	}

}
