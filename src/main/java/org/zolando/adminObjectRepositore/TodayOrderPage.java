package org.zolando.adminObjectRepositore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodayOrderPage {

	@FindBy(xpath = "//tr[last()]//td//a")
	private WebElement lastEditlink;
	
	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement entriesDropDown;
	
	public TodayOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLastUserEditLink() {
		lastEditlink.click();
	}
	
	public WebElement entriesDropDown() {
		return entriesDropDown;
	}
}
