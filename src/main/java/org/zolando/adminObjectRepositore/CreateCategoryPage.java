package org.zolando.adminObjectRepositore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zolando.genericUtilities.WebDriverUtility;

public class CreateCategoryPage {
	private WebDriver driver;
	private WebDriverUtility driverUtility;
	// Deceleration
	@FindBy(xpath = "//input[@placeholder='Enter category Name']")
	private WebElement categoryNametextField;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionTextArea;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement createButton;

	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement entriesDropDown;

	@FindBy(xpath = "//tbody//tr[last()]//td")
	private List<WebElement> lastRowData;
	

	// Initialization

	public CreateCategoryPage(WebDriver driver,WebDriverUtility driverUtility) {
		this.driverUtility=driverUtility;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createNewCategory(String categoryName, String description) {
		categoryNametextField.sendKeys(categoryName);
		descriptionTextArea.sendKeys(description);
		createButton.click();
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
	
	public void deleteAllCategory() {
		WebElement element=null;
		try {
			element=driver.findElement(By.xpath("//tr[last()]//td//a//i[@class='icon-remove-sign']"));
		} catch (Exception e) {
		}
		if (element!=null) {
			element.click();
			driverUtility.alertAccept();
			deleteAllCategory();
		}
	}

}
