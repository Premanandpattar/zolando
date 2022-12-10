package org.zolando.practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigement {

	
	@Test
	public  void main() {
		
//		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(ChromenotificationPopUp.chromeDisablePopUp());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
//		WebElement ele = driver.findElement(By.xpath("(//a[.='JSONPlaceholder'])[1]"));
		WebElement ele = driver.findElement(By.xpath("//input[@name='email' and @placeholder='Email Address']"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		
//		jss.executeScript("arguments[0].scrollIntoView(true)", ele);
		jss.executeScript("arguments[0].value=arguments[1]", ele,"premamdsd");
		
		WebElement ele2 = driver.findElement(By.xpath("//button[contains(.,'Follow')]"));
		jss.executeScript("arguments[0].click()", ele2);
		
//		driver.findElement(By.xpath("//span[.='From']")).click();
//		driver.findElement(By.xpath("//div[.='BOM']")).click();
//		driver.findElement(By.xpath("//span[.='To']")).click();
//		driver.findElement(By.xpath("//div[.='DEL']")).click();
//		driver.findElement(By.xpath("//a[.='Search']")).click();
		
		
		
		
	}
}
