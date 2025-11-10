package com.PracticeAutomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String filename) {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(filename);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setReportName("Selenium Framework Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Tamanappa Inde");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		
		return extent;
	}
}
