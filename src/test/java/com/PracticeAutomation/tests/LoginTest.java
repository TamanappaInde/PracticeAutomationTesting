package com.PracticeAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PracticeAutomation.base.BaseClass;
import com.PracticeAutomation.pages.LoginPage;
import com.PracticeAutomation.utils.ConfigReader;
import com.PracticeAutomation.utils.ReportUtils;

public class LoginTest extends BaseClass {
	
	
	
	LoginPage loginpage;
	ConfigReader reader;
	
	@Test
	public void loginTest() {
		loginpage = new LoginPage(driver);
		reader = new ConfigReader();
		
		String username = reader.getProperty("username");
		String password = reader.getProperty("password");
		
		ReportUtils.log("Lounching LoginPage");
		loginpage.login(username, password);
		ReportUtils.log("Clicked on Login and On Home page");
		
		// validate login successful
		String expectedname = loginpage.showsusername();
		String actualname = "indesuraj";
		Assert.assertEquals(actualname, expectedname, "login failed due wrong username");
		
		ReportUtils.takeScreenshot(driver);
		ReportUtils.log("Login is successfull");
		
		
	}

}
