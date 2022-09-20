package org.zolando.adminObjectRepositore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(xpath = "//input[@id='inputEmail']")
	private WebElement adminEmailTextField;
	
	@FindBy(xpath = "//input[@id='inputPassword']")
	private WebElement adminPasswordTextField;
	
	@FindBy(xpath = "//button[.='Login']")
	private WebElement logInButton;
	
	@FindBy(xpath = "//a[@class='brand']")
	private WebElement adminLoginPageTitle;

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginInToUserAccount(String userEmail, String password) {
		adminEmailTextField.sendKeys(userEmail);
		adminPasswordTextField.sendKeys(password);
		logInButton.click();
	}
	
	public WebElement adminLoginPageTitle() {
		return adminLoginPageTitle;
	}
}
