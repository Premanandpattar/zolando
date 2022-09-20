package org.zolando.practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigement {

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(ChromenotificationPopUp.chromeDisablePopUp());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//div[.='BOM']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//div[.='DEL']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		
		
	}
}
