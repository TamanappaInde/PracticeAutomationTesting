package com.PracticeAutomation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import io.qameta.allure.Allure;

public class ReportUtils {
	
	// Add custom step to log report
	public static void log(String message) {
		Allure.step(message);
	}
	
	// Attache screenshot to report
	public static byte[] takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	// Attache plain text to report
	public static void attachText(String name, String content) {
		Allure.addAttachment(name, new ByteArrayInputStream(content.getBytes()));
	}

}
