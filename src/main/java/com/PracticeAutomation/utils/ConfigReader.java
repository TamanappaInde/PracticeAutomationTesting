package com.PracticeAutomation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public ConfigReader() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\eclipse-workspace\\PracticeAutomationTesting\\src\\test\\resources\\Config\\config.properties");
			prop.load(fis);
			
		} catch(Exception e) {
			System.out.println("File not found" + e.getMessage());
		}
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

}
