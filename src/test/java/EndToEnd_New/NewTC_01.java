package EndToEnd_New;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.zolando.adminObjectRepositore.AdminCommonPage;
import org.zolando.adminObjectRepositore.AdminLoginPage;
import org.zolando.adminObjectRepositore.AdminTabNames;
import org.zolando.adminObjectRepositore.AdminTextFieldNamesAndImageUploadNames;
import org.zolando.adminObjectRepositore.CreateCategoryPage;
import org.zolando.adminObjectRepositore.EntriesDropDownOptions;
import org.zolando.genericUtilities.DataType;
import org.zolando.genericUtilities.ExcelUtility;
import org.zolando.genericUtilities.IConstanceUtility;
import org.zolando.genericUtilities.JavaUtility;
import org.zolando.genericUtilities.PropertyFileUtility;
import org.zolando.genericUtilities.PropertyKeysNames;
import org.zolando.genericUtilities.WebDriverUtility;

public class NewTC_01 {

	public static void main(String[] args) {
		PropertyFileUtility propertyFileUtility = new PropertyFileUtility(IConstanceUtility.PROPERTIYFILEPATH);
		JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility driverUtility = new WebDriverUtility();
		ExcelUtility excelUtility = new ExcelUtility();

		String time = propertyFileUtility.getDataFromPropertyFile(PropertyKeysNames.timeOut.toString());
		String browser = propertyFileUtility.getDataFromPropertyFile(PropertyKeysNames.browser.toString());
		String url = propertyFileUtility.getDataFromPropertyFile(PropertyKeysNames.urlForAdmin.toString());
		long timeOut = (long) javaUtility.convertStringToAnyDataType(time, DataType.LONG);

		WebDriver driver = driverUtility.openApplication(browser, timeOut, url);

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		String adminUN = propertyFileUtility.getDataFromPropertyFile(PropertyKeysNames.adminUN.toString());
		String adminPass = propertyFileUtility.getDataFromPropertyFile(PropertyKeysNames.adminPass.toString());
		adminLoginPage.loginInToUserAccount(adminUN, adminPass);

		excelUtility.openExcelWorkBook(IConstanceUtility.EXCELPATH);
		List<Map<String, String>> listOfData = excelUtility.getDataFromExcelStoredInList(
				propertyFileUtility.getDataFromPropertyFile(PropertyKeysNames.sheetName.toString()));

		AdminCommonPage commonPage = new AdminCommonPage(driver);
		commonPage.clickOnRequiredTab(AdminTabNames.CREATE_CATEGORY);

		CreateCategoryPage createCategory = new CreateCategoryPage(driver,driverUtility);
		createCategory.createNewCategory(listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.CATEGORY_NAME),
				listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.DESCRIPTION));
		
		driverUtility.selectOptionInDropDwon(createCategory.entriesDropDown(), EntriesDropDownOptions.SELECT_100);
		ArrayList<String> lastRowText = createCategory.getLastRowData();
		if (lastRowText.contains(listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.CATEGORY_NAME))) {
			System.out.println("category was created");
		} else {
			System.out.println("category was not created");
			driverUtility.closeBrowser();
		}
		
		
	}
}
