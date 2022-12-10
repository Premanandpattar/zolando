package org.zolando.practies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromenotificationPopUp {
	
	public static ChromeOptions chromeDisablePopUp() {
		ChromeOptions options =new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		options.addArguments("--disable-notifications");
		return options;		
	}
	
	
	@Test
	public void launch() {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(chromeDisablePopUp());
		driver.manage().window().maximize();
		
	}
}
