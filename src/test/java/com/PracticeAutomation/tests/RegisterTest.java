package com.PracticeAutomation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PracticeAutomation.base.BaseClass;
import com.PracticeAutomation.pages.DemoSitePage;
import com.PracticeAutomation.utils.Userdata;

@Listeners(com.PracticeAutomation.utils.ExtentTestListner.class)

public class RegisterTest extends BaseClass {
	
	DemoSitePage demositep;
	
	
	
	@Test
	public void registerTest() {
		
		Userdata user = new Userdata(
				"tamanappa","inde","sastur dharashiv","inde@gmail.com", "8956456895");
		
		demositep = new DemoSitePage(driver);
		demositep.registerUser(user);
		
	}
	
	

}
