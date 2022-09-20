package org.zolando.genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consist of reusable methods of web driver
 * 
 * @author PREM
 *
 */
public final class WebDriverUtility {
	private WebDriver driver;
	private JavascriptExecutor jsExecutor;
	private WebDriverWait wait;

	/**
	 * This method used to launch empty browser
	 * 
	 * @param browser
	 * @return WebDriver
	 */
	public WebDriver launchEmptyBrowser(String browser) {
		if (browser.equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("Please enter valid browser name");
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait the page implicitly
	 * 
	 * @param longTimeOut
	 */
	public void waitPageImplicitly(Long longTimeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeOut));
	}

	/**
	 * This method is used to switch the window based on xpath
	 * 
	 * @param xPath
	 */
	public void switchToWindow(String text) {
		Set<String> AllWindowIds = driver.getWindowHandles();
		for (String wind : AllWindowIds) {
			driver.switchTo().window(wind);
			String url = driver.getCurrentUrl();
			if (url.contains(text)) {
				break;
			}
		}
	}

	/**
	 * This method is used to wait the page customize
	 * 
	 * @param xPath
	 * @throws InterruptedException
	 */
	public void waitPageCustomize(String xPath) throws InterruptedException {
		int time = 20;
		int count = 0;
		while (count != time) {
			try {
				driver.findElement(By.xpath(xPath));
				break;
			} catch (Exception e) {
				Thread.sleep(500);
				count++;
			}
		}
	}

	/**
	 * This method is used to get the URl
	 * 
	 * @param Url
	 */
	public void launchUrl(String Url) {
		driver.get(Url);
	}

	/**
	 * This method is used to launch the browser,maximize the browser,implicty wait,
	 * get Url
	 * 
	 * @param browser
	 * @param longTimeOut
	 * @param url
	 * @return WebDriver
	 */
	public WebDriver openApplication(String browser, Long longTimeOut, String url) {
		launchEmptyBrowser(browser);
		maximizeBrowser();
		waitPageImplicitly(longTimeOut);
		launchUrl(url);
		return driver;
	}

	public WebDriver openBrowserDoSetting(String browser, Long longTimeOut) {
		launchEmptyBrowser(browser);
		maximizeBrowser();
		waitPageImplicitly(longTimeOut);
		initializeExplicityWait(longTimeOut);
		return driver;
	}

	/**
	 * This method is used to click the option in drop down based on visible text
	 * 
	 * @param
	 * @param visibleText
	 */
	public void selectOptionInDropDwon(WebElement element, String visibleText) {
		Select s = initSelectClass(element);
		s.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to click the option in drop down based on index
	 * 
	 * @param xpath
	 * @param index
	 */
	public void selectOptionInDropDwon(WebElement element, int index) {
		Select s = initSelectClass(element);
		s.selectByIndex(index);
	}

	public Select initSelectClass(WebElement element) {
		Select s = new Select(element);
		return s;
	}

	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * This method is used to initialize the JavaScriptExecutor
	 */
	public void initialzeJavaScriptExecutor() {
		jsExecutor = (JavascriptExecutor) driver;
	}

	/**
	 * This method is used to open the application using JavaScriptExecutor
	 * 
	 * @param url
	 */
	public void openApplicationUsingJSE(String url) {
		jsExecutor.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method is used to sendKeys using JavaScriptExecutor
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeysUsingJSE(WebElement element, String data) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	/**
	 * This method is used to click on element using JavaScriptExecutor
	 * 
	 * @param element
	 */
	public void clickUsingJSE(WebElement element) {
		jsExecutor.executeScript("arguments[0].click()", element);
	}

	/**
	 * This method is used to scroll to till element using JavaScriptExecutor
	 * 
	 * @param element
	 */
	public void scrollTillElementUsingJSE(WebElement element) {
		jsExecutor.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void verifyResult(String actualResult, String expectedResult) {
		Assert.assertEquals(actualResult, expectedResult);
	}

	public void verifyResult(boolean condition) {
		Assert.assertTrue(condition);
	}

	public void verifyResult(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	public void verifyResultAndlogToReport(boolean condition, String trueStatement, String falseStatement) {
		if (condition) {
			Reporter.log(trueStatement, true);
		} else {
			Reporter.log(falseStatement, true);
		}
		Assert.assertTrue(condition);
	}

	public void verifyWebPage(String expectedText) {
		String pageSource = driver.getPageSource();
		verifyResult(pageSource.contains(expectedText));
	}

	public void initializeExplicityWait(long timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	}

	public void alertAccept() {
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public String getTextFromAlert() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void getScreenShot(WebDriver driver, JavaUtility javaUtility, String methodName) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreeShots/" + methodName + "_" + javaUtility.getCurrentDateAndTime() + ".png");
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getScreenShot(WebDriver driver) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		String src = tss.getScreenshotAs(OutputType.BASE64);
		return src;

	}

	public void creatNewTabSwitchToIt() {
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> all_Ids = driver.getWindowHandles();
		for (String id : all_Ids) {
			driver.switchTo().window(id);
			if ((driver.getCurrentUrl()) == null) {
				break;
			}
		}

	}

}
