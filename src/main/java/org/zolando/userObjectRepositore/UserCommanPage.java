package org.zolando.userObjectRepositore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCommanPage {

	private WebDriver driver;
	@FindBy(xpath = "//a[@href='my-account.php']")
	private WebElement myAccountLink;

	@FindBy(xpath = "//a[@href='my-wishlist.php']")
	private WebElement wishListLink;

	@FindBy(xpath = "//a[@href='my-cart.php']")
	private WebElement myCartLink;

	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement logInLink;

	@FindBy(xpath = "//a[@href='track-orders.php']")
	private WebElement trackOredrLink;

	@FindBy(xpath = "//span[.='cart -']")
	private WebElement cartButton;

	@FindBy(xpath = "//input[@class='search-field']")
	private WebElement searchTextField;

	@FindBy(xpath = "//button[@class='search-button']")
	private WebElement searchbutton;

	@FindBy(xpath = "//a[.='Home']")
	private WebElement appHomePage;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement userLogOutLink;

	public UserCommanPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnRequiredCategory(String categoryName) {
		driver.findElement(By.xpath("//nav//a[contains(.,'" + categoryName + "')]")).click();
	}

	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}

	public void clickOnWishListLink() {
		wishListLink.click();
	}

	public void clickOnMyCartLink() {
		myCartLink.click();
	}

	public void clickOnLogInLink() {
		logInLink.click();
	}

	public void clickOnTrackOredrLink() {
		trackOredrLink.click();
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

	public void SearchTheProduct(String productName) {
		searchTextField.sendKeys(productName);
		searchbutton.click();
	}

	public void clickonAppHomePage() {
		appHomePage.click();
	}
	
	public void clickonUserLogOut() {
		userLogOutLink.click();
	}
}
