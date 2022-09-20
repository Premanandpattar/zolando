package org.zolando.practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAdmin {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(FetchDataFromPropertiesFile.FetchValue("urlForAdmin"));
		driver.findElement(By.id("inputEmail")).sendKeys(FetchDataFromPropertiesFile.FetchValue("adminUN"));
		driver.findElement(By.id("inputPassword")).sendKeys(FetchDataFromPropertiesFile.FetchValue("adminPass"));
		driver.findElement(By.name("submit")).click();
		
	}
	
}
