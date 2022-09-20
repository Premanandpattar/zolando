package org.zolando.adminObjectRepositore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.zolando.genericUtilities.WebDriverUtility;

public class InsertProductPage {
	private WebDriverUtility driverUtility;
	@FindBy(xpath = "//select[@name='category']")
	private WebElement categoryDropDown;

	@FindBy(xpath = "//select[@id='subcategory']")
	private WebElement subCategoryDropDown;

	@FindBy(xpath = "//input[@name='productName']")
	private WebElement productNameTextField;

	@FindBy(xpath = "//input[@name='productCompany']")
	private WebElement productCompanyTextField;

	@FindBy(xpath = "//input[@name='productpricebd']")
	private WebElement productpricebdTextField;

	@FindBy(xpath = "//input[@name='productprice']")
	private WebElement productpriceTextFiled;

	@FindBy(xpath = "//textarea[@name='productDescription']")
	private WebElement productDescriptionTextArea;

	@FindBy(xpath = "//input[@name='productShippingcharge']")
	private WebElement productShippingchargeTextField;

	@FindBy(xpath = "//select[@id='productAvailability']")
	private WebElement productAvailabilityDropDown;

	@FindBy(xpath = "//input[@id='productimage1']")
	private WebElement productimage1;

	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement productimage2;

	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement productimage3;

	@FindBy(xpath = "//button[.='Insert']")
	private WebElement insertButton;

	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement entriesDropDown;

	@FindBy(xpath = "//tbody//tr[last()]//td")
	private List<WebElement> lastRowData;
	
	public InsertProductPage(WebDriver driver, WebDriverUtility driverUtility) {
		this.driverUtility = driverUtility;
		PageFactory.initElements(driver, this);
	}

	private void selectStockOption(boolean productAvailability) {
		Select s = driverUtility.initSelectClass(productAvailabilityDropDown);
		if (productAvailability = true) {
			s.selectByVisibleText("In Stock");
		} else if (productAvailability = false) {
			s.deselectByVisibleText("Out of Stock");
		}
	}

	/**
	 * 
	 * @param categoryName
	 * @param subCategoryName
	 * @param setProductName
	 * @param setProductCompany
	 * @param setProductPriceBeforDiscount
	 * @param setProductPriceAfterDiscount
	 * @param setProductDescription
	 * @param setProductShippingcharge
	 * @param productAvailability          if true means In Stock, suppose false
	 *                                     means Out of Stock
	 * @param image1Path
	 * @param image2Path
	 * @param image3Path
	 */
	public void insertProduct(String categoryName, String subCategoryName, String setProductName,
			String setProductCompany, String setProductPriceBeforDiscount, String setProductPriceAfterDiscount,
			String setProductDescription, String setProductShippingcharge, boolean productAvailability,
			String image1Path, String image2Path, String image3Path) {
		driverUtility.selectOptionInDropDwon(categoryDropDown, categoryName);
		driverUtility.selectOptionInDropDwon(subCategoryDropDown, subCategoryName);
		productNameTextField.sendKeys(setProductName);
		productCompanyTextField.sendKeys(setProductCompany);
		productpricebdTextField.sendKeys(setProductPriceBeforDiscount);
		productpriceTextFiled.sendKeys(setProductPriceAfterDiscount);
		productDescriptionTextArea.sendKeys(setProductDescription);
		productShippingchargeTextField.sendKeys(setProductShippingcharge);
		selectStockOption(productAvailability);
		productimage1.sendKeys(image1Path);
		productimage2.sendKeys(image2Path);
		productimage3.sendKeys(image3Path);
		insertButton.click();
	}
	
	public WebElement entriesDropDown() {
		return entriesDropDown;
	}

	public ArrayList<String> getLastRowData() {
		ArrayList<String> data = new ArrayList<String>();
		for (WebElement webElement : lastRowData) {
			data.add(webElement.getText());
		}
		return data;
	}

}
