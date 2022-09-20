package org.zolando.adminObjectRepositore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotUSeCommonPage {
	//Deceleration
	@FindBy (xpath = "//a[@href='#togglePages']")
	private WebElement orderManagementLink;
	
	@FindBy (xpath = "//a[@href='todays-orders.php']")
	private WebElement todayOrdersLink;
	
	@FindBy (xpath = "//a[@href='pending-orders.php']")
	private WebElement pendingOrdersLink;
	
	@FindBy (xpath = "//a[@href='delivered-orders.php']")
	private WebElement deliveredOrdersLink;
	
	@FindBy (xpath = "//a[@href='manage-users.php']")
	private WebElement manageUserLink;
	
	@FindBy (xpath = "//a[@href='category.php']")
	private WebElement createCategoryLink;
	
	@FindBy (xpath = "//a[@href='subcategory.php']")
	private WebElement subCategoryLink;
	
	@FindBy (xpath = "//a[@href='insert-product.php']")
	private WebElement insertProductLink;
	
	@FindBy (xpath = "//a[@href='manage-products.php']']")
	private WebElement manageProductsLink;
	
	@FindBy (xpath = "//a[@href='user-logs.php']")
	private WebElement userLoginLogLink;
	
	@FindBy (xpath = "//a[@href='#' and @class='dropdown-toggle']")
	private WebElement userDropDwon;
	
	@FindBy (xpath = "//a[.='Logout']")
	private WebElement logOutButton;
	
	@FindBy(xpath = "//a[.='Change Password']")
	private WebElement changePasswordButton;
	
	//Initialization
	public NotUSeCommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Business library
	public void clickOnOrderManagementLink() {
		orderManagementLink.click();
	}

	public void clickOnTodayOrdersLink() {
		todayOrdersLink.click();
	}

	public void clickOnPendingOrdersLink() {
		pendingOrdersLink.click();
	}

	public void clickOnDeliveredOrdersLink() {
		deliveredOrdersLink.click();
	}

	public void clickOnManageUserLink() {
		manageUserLink.click();
	}

	public void clickOnCreateCategoryLink() {
		createCategoryLink.click();
	}

	public void clickOnSubCategoryLink() {
		subCategoryLink.click();
	}

	public void clickOngetInsertProductLink() {
		insertProductLink.click();
	}

	public void clickOnManageProductsLink() {
		manageProductsLink.click();
	}

	public void clickOnUserLoginLogLink() {
		userLoginLogLink.click();
	}

	public void clickOnUserDropDwon() {
		userDropDwon.click();
	}
	
	public void clickOnLogOutButton() {
		logOutButton.click();
	}
	
	public void clickOnChangePasswordButton() {
		changePasswordButton.click();
	}
	
	
	
	
}
