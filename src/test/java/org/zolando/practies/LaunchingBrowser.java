package org.zolando.practies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {
	
	public static void browserName(String name) {
		WebDriver driver=null;
		if (name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else {
			System.out.println("please enter valide browser name");
		}
		
	}
	
	public static void main(String[] args) {
		browserName("chrome");
	}
	
	
	
}
