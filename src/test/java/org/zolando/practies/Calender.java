package org.zolando.practies;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String reqDate = "15";// DD
		String reqMonth = "Jun";// MM-->01to12, MMM-->jan feb etc.., MMMM-->January etc..
		String reqYear = "2020";

		int reqMonthInNum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(reqMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(reqMonthInNum);
		int reqYearInNum = Integer.parseInt(reqYear);
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String ActMonthAndYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		String[] str = ActMonthAndYear.split(" ");
		int actMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
				.get(ChronoField.MONTH_OF_YEAR);
		int actYearInNum = Integer.parseInt(str[1]);

		while (reqMonthInNum > actMonthInNum || reqYearInNum > actYearInNum) {
			driver.findElement(By.xpath("//span[.='Next']")).click();
			ActMonthAndYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			str = ActMonthAndYear.split(" ");
			actMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
			actYearInNum = Integer.parseInt(str[1]);
		}
		while (reqMonthInNum < actMonthInNum || reqYearInNum < actYearInNum) {
			driver.findElement(By.xpath("//span[.='Prev']")).click();
			ActMonthAndYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			str = ActMonthAndYear.split(" ");
			actMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
			actYearInNum = Integer.parseInt(str[1]);
		}
		driver.findElement(By.xpath("//a[.='"+reqDate+"']")).click();

	}
}
