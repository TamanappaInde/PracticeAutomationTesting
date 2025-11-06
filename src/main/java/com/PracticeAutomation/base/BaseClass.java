package com.PracticeAutomation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.PracticeAutomation.utils.ConfigReader;

public class BaseClass {
	
	protected WebDriver driver;
	ConfigReader reader;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		reader = new ConfigReader();
		String url = reader.getProperty("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
		
		if (driver != null) {
			driver.close();
		}
	}

}
