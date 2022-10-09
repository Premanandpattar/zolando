package org.zolando.practies;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromenotificationPopUp {
	
	public static ChromeOptions chromeDisablePopUp() {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;		
	}
}
