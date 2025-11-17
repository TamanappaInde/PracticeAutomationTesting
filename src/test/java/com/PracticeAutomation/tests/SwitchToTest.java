package com.PracticeAutomation.tests;

import com.PracticeAutomation.base.BaseClass;
import com.PracticeAutomation.pages.DemoSiteSwitchToPage;
import org.testng.annotations.Test;

public class SwitchToTest extends BaseClass {

	static DemoSiteSwitchToPage switchpage;
	
	@Test
	public static void switchToTest() {
		
		switchpage = new DemoSiteSwitchToPage(driver);
		switchpage.switchTo();
		
	}
}
