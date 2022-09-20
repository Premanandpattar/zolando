package org.zolando.adminObjectRepositore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zolando.genericUtilities.WebDriverUtility;

public class ManageProductsPage {
	private WebDriverUtility driverUtility;
	private WebDriver driver;
	
	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement entriesDropDown;

	public ManageProductsPage(WebDriver driver, WebDriverUtility driverUtility) {
		this.driver=driver;
		this.driverUtility=driverUtility;
		PageFactory.initElements(driver, this);
	}
	
	public void deleteAllProducts() {
		WebElement element=null;
		try {
			element=driver.findElement(By.xpath("//tr[last()]//td//a//i[@class='icon-remove-sign']"));
		} catch (Exception e) {
		}
		if (element!=null) {
			element.click();
			driverUtility.alertAccept();
			deleteAllProducts();
		}
	}
	
	public WebElement entriesDropDown() {
		return entriesDropDown;
	}
}
