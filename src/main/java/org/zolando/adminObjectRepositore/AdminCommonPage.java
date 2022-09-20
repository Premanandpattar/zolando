package org.zolando.adminObjectRepositore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCommonPage {
	private WebDriver driver;

	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logOutButton;

	@FindBy(xpath = "//a[@href='#' and @class='dropdown-toggle']")
	private WebElement userDropDwon;

	@FindBy(xpath = "//img[@class='nav-avatar']")
	private WebElement profileImg;
	
	@FindBy(xpath = "//a[contains(.,'Today')]")
	private WebElement todayOrderLink;

	public AdminCommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement convertRequiredXpathTOWebelement(String tabName) {
		String dynamicXpath = "//a[contains(.,'%s')]";
		String requiredXpath = String.format(dynamicXpath, tabName);
		return driver.findElement(By.xpath(requiredXpath));
	}

	public void clickOnRequiredTab(String tabNames) {
		convertRequiredXpathTOWebelement(tabNames).click();
	}

	public void clickOnUserDropDwon() {
		userDropDwon.click();
	}

	public void clickOnLogOutButton() {
		profileImg.click();
		logOutButton.click();
	}
	
	public void clickOnTodayOrder() {
		todayOrderLink.click();
	}
}
