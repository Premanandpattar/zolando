package org.zolando.userObjectRepositore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackOrderPage {

	@FindBy (xpath = "//b[.='Status:']/ancestor::td/following-sibling::td")
	private WebElement status;
	
	public TrackOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getStatus() {
		return status.getText();
	}
}

