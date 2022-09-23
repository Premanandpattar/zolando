package org.zolando;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.zolando.genericUtilities.BaseClass;

public class Test2 extends BaseClass {

	@Test
	public void test2() {
		
//		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
		System.out.println("browser launched statrted successfully");
	}
}
