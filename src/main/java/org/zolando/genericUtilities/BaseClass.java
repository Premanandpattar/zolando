package org.zolando.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.zolando.adminObjectRepositore.AdminCommonPage;
import org.zolando.adminObjectRepositore.AdminLoginPage;
import org.zolando.userObjectRepositore.UserCommanPage;
import org.zolando.userObjectRepositore.UserLogInAndCreateNewAccountPage;

public class BaseClass {
	protected ExcelUtility excelUtility;
	protected WebDriverUtility driverUtility;
	protected PropertyFileUtility fileUtility;
	protected JavaUtility javaUtility;
	protected WebDriver driver;
	protected AdminLoginPage adminLoginPage;
	protected String adminUserNamer;
	protected String adminPassword;
	protected AdminCommonPage adminCommonPage;
	protected String urlForAdmin;
	protected UserCommanPage userCommanPage;
	protected UserLogInAndCreateNewAccountPage userLogInAndCreateNewAccountPage;
	protected String urlForUser;
	public static WebDriver sDriver;
	public static JavaUtility SJavaUtility;

	/**
	 * Initialize the all utility class open the excel, propertyFile read the common
	 * data create the instance for browser(launch browser) maximize, implicit wait
	 * open application Initialize JSEcecutor,action, webDriverWait create the
	 * instance for common object repository
	 * 
	 */
//	@Parameters("browser")
	@BeforeClass(groups = "baseclass")
	public void beforeClassSetup() {
		// create instance for the Generic Utility
		excelUtility = new ExcelUtility();
		fileUtility = new PropertyFileUtility(IConstanceUtility.PROPERTIYFILEPATH);
		driverUtility = new WebDriverUtility();
		javaUtility = new JavaUtility();
		SJavaUtility = javaUtility;

		// Initialize the property file and excel file
		excelUtility.openExcelWorkBook(IConstanceUtility.EXCELPATH);

		// fetch the data from property file
		String browser = fileUtility.getDataFromPropertyFile(PropertyKeysNames.browser.toString());
		urlForAdmin = fileUtility.getDataFromPropertyFile(PropertyKeysNames.urlForAdmin.toString());
		urlForUser = fileUtility.getDataFromPropertyFile(PropertyKeysNames.urlForUser.toString());
		String time = fileUtility.getDataFromPropertyFile(PropertyKeysNames.timeOut.toString());
		long timeOuts = (long) javaUtility.convertStringToAnyDataType(time, DataType.LONG);
		adminUserNamer = fileUtility.getDataFromPropertyFile(PropertyKeysNames.adminUN.toString());
		adminPassword = fileUtility.getDataFromPropertyFile(PropertyKeysNames.adminPass.toString());

		// launching the browser and application. doing some setting
		driver = driverUtility.openBrowserDoSetting(browser, timeOuts);
		sDriver = driver;
		driverUtility.initialzeJavaScriptExecutor();

		// create object for common POM repository
		adminLoginPage = new AdminLoginPage(driver);
		adminCommonPage = new AdminCommonPage(driver);

		userCommanPage = new UserCommanPage(driver);
		userLogInAndCreateNewAccountPage = new UserLogInAndCreateNewAccountPage(driver);
	}

	/**
	 * when ever we create the testScript class for module and test annotation
	 * method for testCase create the instance for browser(launch browser) maximize,
	 * implicit wait open application Initialize JSEcecutor,action, webDriverWait
	 * create the instance for common object repository login to the application
	 */
//	@BeforeMethod
//	public void beforeMethodSetup() {
//		MyProjectListener listener=new MyProjectListener();
//		log=listener.log;
//	}

	/**
	 * log out the application save the excel
	 */
//	@AfterMethod(alwaysRun = true)
//	public void afterMethodSetup() {
//		adminCommonPage.clickOnLogOutButton();
//		excelUtility.saveExcelWorkBook(IConstanceUtility.EXCELPATH);
//	}

	/**
	 * close the browser close the excel
	 */
	@AfterClass(groups = "baseclass", alwaysRun = true)
	public void afterClassSetup() {
		excelUtility.saveExcelWorkBook(IConstanceUtility.EXCELPATH);
		driverUtility.closeBrowser();
		excelUtility.closeExcelWorkBook();
	}
}
