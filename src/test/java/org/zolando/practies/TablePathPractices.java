package org.zolando.practies;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePathPractices {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		String expProductName="router";
		
		List<WebElement> listOfProducts = driver.findElements(By.xpath("//table[@class=\"lvt small\"]//tr//a[@title='Products']"));
		for (WebElement products : listOfProducts) {
			String actProductName = products.getText();
			System.out.println(actProductName);
		}
		
	}
}
