package org.zolando.adminObjectRepositore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zolando.genericUtilities.WebDriverUtility;

public class UpdateOrderPage {
	private WebDriverUtility driverUtility;
	@FindBy(xpath = "//select")
	private WebElement dropDown;
	
	@FindBy(xpath = "//textarea")
	private WebElement textArea;
	
	@FindBy(xpath = "//input[@name='submit2']")
	private WebElement submitButton;

	
	public UpdateOrderPage(WebDriver driver, WebDriverUtility driverUtility) {
		this.driverUtility=driverUtility;
		PageFactory.initElements(driver, this);
	}

	public void selectStatus(String status) {
		driverUtility.selectOptionInDropDwon(dropDown, status);
	}
	
	public void setRemark(String remark) {
		textArea.sendKeys(remark);
	}
	
	public void clickOnSubmit() {
		submitButton.click();
	}
}
