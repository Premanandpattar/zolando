//package EndToEnd_New;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import org.zolando.genericUtilities.DataType;
//import org.zolando.genericUtilities.ExcelUtility;
//import org.zolando.genericUtilities.IConstanceUtility;
//import org.zolando.genericUtilities.JavaUtility;
//import org.zolando.genericUtilities.PropertyFileUtility;
//import org.zolando.genericUtilities.WebDriverUtility;
//import org.zolando.practies.FetchDataFromPropertiesFile;
//
//public class TC_01 {
//
//	public static void main(String[] args) {
//		WebDriverUtility driverUtility = new WebDriverUtility();
//		ExcelUtility excelUtility = new ExcelUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
//
//		String browser = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH, "browser");
//		String urlAdmin = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH,
//				"urlForAdmin");
//		String adminUserName = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH,
//				"adminUN");
//		String adminUserPass = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH,
//				"adminPass");
//
//		long longTimeOut = (long) javaUtility.convertStringToAnyDataType("20", DataType.LONG);
//
//		WebDriver driver = driverUtility.openApplication(browser, longTimeOut, urlAdmin);
//		driver.findElement(By.id("inputEmail")).sendKeys(adminUserName);
//		driver.findElement(By.id("inputPassword")).sendKeys(adminUserPass);
//		driver.findElement(By.xpath("//button[.='Login']")).click();
//
//		excelUtility.openExcelWorkBook(IConstanceUtility.EXCELPATH);
//		Map<String, String> testData = excelUtility.getDataStoreInMap("TestData", 1);
//
//		driver.findElement(By.xpath("//a[@href='category.php']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Enter category Name']"))
//				.sendKeys(testData.get("category Name"));
//		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(testData.get("description"));
//		driver.findElement(By.xpath("//button[@class='btn']")).click();
//
//		WebElement dd_show = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//		driverUtility.selectOptionInDropDwon(dd_show, "100");
//		driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']")).click();
//		List<WebElement> allWebElement = driver.findElements(By.xpath("//tbody//tr[last()]//td"));
//		ArrayList<String> data1 = new ArrayList<String>();
//		for (WebElement webElement : allWebElement) {
//			data1.add(webElement.getText());
//		}
//
//		if (data1.contains(testData.get("category Name")) && data1.contains(testData.get("description"))) {
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("category Name"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("description"), "Pass");
//		} else {
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("category Name"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("description"), "Fail");
//		}
//
//		driver.findElement(By.xpath("//a[@href='subcategory.php']")).click();
//		driverUtility.selectOptionInDropDwon(driver.findElement(By.xpath("//select[@name='category']")),
//				testData.get("category Name"));
//		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']"))
//				.sendKeys(testData.get("SubCategory Name"));
//		driver.findElement(By.xpath("//button[@class='btn']")).click();
//
//		WebElement dd_show1 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//		driverUtility.selectOptionInDropDwon(dd_show1, "100");
//		driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']")).click();
//		allWebElement.clear();
//		data1.clear();
//		allWebElement = driver.findElements(By.xpath("//tbody//tr[last()]//td"));
//		for (WebElement webElement : allWebElement) {
//			data1.add(webElement.getText());
//		}
//
//		if (data1.contains(testData.get("category Name")) && data1.contains(testData.get("SubCategory Name"))) {
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("SubCategory Name"), "Pass");
//		} else {
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("SubCategory Name"), "Fail");
//		}
//
//		driver.findElement(By.xpath("//a[@href='insert-product.php']")).click();
//		WebElement dd_category1 = driver.findElement(By.xpath("//select[@name='category']"));
//		driverUtility.selectOptionInDropDwon(dd_category1, testData.get("category Name"));
//
//		WebElement dd_subCategory = driver.findElement(By.xpath("//select[@id='subcategory']"));
//		driverUtility.selectOptionInDropDwon(dd_subCategory, testData.get("SubCategory Name"));
//
//		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(testData.get("productName"));
//		driver.findElement(By.xpath("//input[@name='productCompany']")).sendKeys(testData.get("productCompany"));
//		driver.findElement(By.xpath("//input[@name='productpricebd']")).sendKeys(testData.get("productpricebd"));
//		driver.findElement(By.xpath("//input[@name='productprice']")).sendKeys(testData.get("productprice"));
//		driver.findElement(By.xpath("//textarea[@name='productDescription']"))
//				.sendKeys(testData.get("productDescription"));
//		driver.findElement(By.xpath("//input[@name='productShippingcharge']"))
//				.sendKeys(testData.get("productShippingcharge"));
//
//		WebElement dd_productAvailability = driver.findElement(By.xpath("//select[@id='productAvailability']"));
//		driverUtility.selectOptionInDropDwon(dd_productAvailability, "In Stock");
//
//		driver.findElement(By.xpath("//input[@id='productimage1']")).sendKeys(testData.get("productimage1"));
//		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys(testData.get("productimage2"));
//		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys(testData.get("productimage3"));
//		driver.findElement(By.xpath("//button[.='Insert']")).click();
//
//		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
//		WebElement dd_show2 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
//		driverUtility.selectOptionInDropDwon(dd_show2, "100");
//
//		allWebElement.clear();
//		data1.clear();
//		allWebElement = driver.findElements(By.xpath("//tbody//tr[last()]//td"));
//		for (WebElement webElement : allWebElement) {
//			data1.add(webElement.getText());
//		}
//
//		if (data1.contains(testData.get("category Name")) && data1.contains(testData.get("SubCategory Name"))
//				&& data1.contains(testData.get("productName")) && data1.contains(testData.get("productCompany"))) {
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productName"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productCompany"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productpricebd"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productprice"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productDescription"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productShippingcharge"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productimage1"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productimage2"), "Pass");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productimage3"), "Pass");
//		} else {
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productName"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productCompany"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productpricebd"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productprice"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productDescription"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productShippingcharge"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productimage1"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productimage2"), "Fail");
//			excelUtility.setDataBasedOnPassAndfail("TestData", 2, testData.get("productimage3"), "Fail");
//		}
//		
//		driver.findElement(By.xpath("//img[@class='nav-avatar']")).click();
//		driver.findElement(By.xpath("//a[.='Logout']")).click();
//		
//		excelUtility.saveExcelWorkBook(IConstanceUtility.EXCELPATH);
//		excelUtility.closeExcelWorkBook();
//		System.out.println("closed workBook");
//		driverUtility.closeBrowser();
//	}
//}
