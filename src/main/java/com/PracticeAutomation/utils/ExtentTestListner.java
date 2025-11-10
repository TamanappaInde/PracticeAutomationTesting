package com.PracticeAutomation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestListner implements ITestListener {
	
	
	private static ExtentReports extent = ExtentManager.createInstance("./reports/ExtentReport_" 
			+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html");
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
		test.get().log(Status.FAIL, result.getThrowable());
	}
	
	@Override
	 public void onTestSkipped(ITestResult result) {
		 test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	 }
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}