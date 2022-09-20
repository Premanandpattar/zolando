package org.zolando.practies;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static String getExcelData(String key, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Ajio");
		DataFormatter df = new DataFormatter();
		String value = null;
		try {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				if (key.equalsIgnoreCase(df.formatCellValue(sheet.getRow(i).getCell(0)))) {
					value = df.formatCellValue(sheet.getRow(i).getCell(cell));
					break;
				}
			}
		} finally {
			wb.close();
		}
		return value;
	}

	public static void setDataToExcel(String key, int cell, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Ajio");
		DataFormatter df = new DataFormatter();
		try {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				if (key.equalsIgnoreCase(df.formatCellValue(sheet.getRow(i).getCell(0)))) {
					sheet.getRow(i).createCell(cell).setCellValue(value);
					FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
					wb.write(fos);
					break;
				}
			}
		} finally {
			wb.close();
		}

	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(getExcelData("url", 1));
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {

		}
		driver.findElement(By.xpath("//a[.='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();

		int cellNumber = 1;
		String itemName = getExcelData("itemname", cellNumber);
		String priceXpath = "//div[.='" + itemName + "']/following-sibling::div/span[@class='price  ']";
		String price = driver.findElement(By.xpath(priceXpath)).getText();
		setDataToExcel("itemPrice", cellNumber, price);

		cellNumber = 2;
		itemName = getExcelData("itemname", cellNumber);
		priceXpath = "//div[.='" + itemName + "']/following-sibling::div/span[@class='price  ']";
		price = driver.findElement(By.xpath(priceXpath)).getText();
		setDataToExcel("itemPrice", cellNumber, price);
		System.out.println("price updated successfully");
	}
}
