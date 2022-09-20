package org.zolando.userObjectRepositore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zolando.genericUtilities.WebDriverUtility;

public class UserLoggedinInterfacePage {

	private WebDriver driver;
	private WebDriverUtility driverUtility;
	
	@FindBy(xpath = "//button[.='PROCCED TO CHEKOUT']")
	private WebElement procedToCeckOutButton;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy (xpath = "//tr[last()]//td//a[@title='Track order']")
	private WebElement trackOrder;
	
	public UserLoggedinInterfacePage(WebDriver driver,WebDriverUtility driverUtility) {
		this.driver = driver;
		this.driverUtility=driverUtility;
		PageFactory.initElements(driver, this);
	}

	public void compliteProcedToCheckOut(String product) {
		driver.findElement(By.xpath(
				"//a[.='"+product+"']/ancestor::div[@class='product-info text-left']/following-sibling::div//button[.='Add to cart']"))
				.click();
		driverUtility.alertAccept();
		driver.findElement(By.xpath("//a[.='"+product+"']/ancestor::td/preceding::td[@class='romove-item']/input")).click();
		procedToCeckOutButton.click();
		submitButton.click();
	}

	public void clickOnLastTrackOrder() {
		trackOrder.click();
	}
}
