package org.zolando.practies;

import org.testng.annotations.Test;
import org.zolando.genericUtilities.WebDriverUtility;

public class CmdDataDrivenTestingTest {

	@Test
	public void launchTest() {
		String browser = System.getProperty("b");
//		browser="chrome";
		String url = System.getProperty("u");
//		url="https://www.flipkart.com";
		System.out.println();
		new WebDriverUtility().openApplication(browser,(long) 10,url);
	}
}
