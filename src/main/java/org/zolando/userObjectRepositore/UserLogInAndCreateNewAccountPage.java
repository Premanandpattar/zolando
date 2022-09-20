package org.zolando.userObjectRepositore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogInAndCreateNewAccountPage {

	@FindBy(xpath = "//input[@name='email']")
	private WebElement userEmailTextField;

	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	private WebElement userPasswordTextField;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement logInButton;

	@FindBy(xpath = "//input[@id='fullname']")
	private WebElement fullNameTextField;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextField;

	@FindBy(xpath = "//input[@id='contactno']")
	private WebElement contactNumberTextField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@id='confirmpassword']")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement signUpButton;

	public UserLogInAndCreateNewAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginInToUserAccount(String userEmail, String userPassword) {
		userEmailTextField.sendKeys(userEmail);
		userPasswordTextField.sendKeys(userPassword);
		logInButton.click();
	}

	public void createNewUserAccount(String fullName, String emailAddress, String contactNumber, String password) {
		fullNameTextField.sendKeys(fullName);
		emailTextField.sendKeys(emailAddress);
		contactNumberTextField.sendKeys(contactNumber);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(password);
		signUpButton.click();
	}
}
