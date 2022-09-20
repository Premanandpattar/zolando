//package org.zolando.practies;
//
//import org.openqa.selenium.WebDriver;
//import org.zolando.adminObjectRepositore.AdminEnumTabNames;
//import org.zolando.adminObjectRepositore.AdminLoginPage;
//import org.zolando.adminObjectRepositore.CommonPage;
//import org.zolando.adminObjectRepositore.AdminTabNames;
//import org.zolando.genericUtilities.DataType;
//import org.zolando.genericUtilities.IConstanceUtility;
//import org.zolando.genericUtilities.JavaUtility;
//import org.zolando.genericUtilities.PropertyFileUtility;
//import org.zolando.genericUtilities.WebDriverUtility;
//
//public class Test {
//
//	public static void main(String[] args) {
//		JavaUtility javaUtility=new JavaUtility();
//		long timeOut = (long) javaUtility.convertStringToAnyDataType("10", DataType.LONG);
//		PropertyFileUtility propertyFileUtility=new PropertyFileUtility();
//		WebDriverUtility driverUtility = new WebDriverUtility();
//		
//		String url = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH, "urlForAdmin");
//		WebDriver driver = driverUtility.openApplication("chrome",timeOut, url);
//		
//		AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
//		String adminUN = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH, "adminUN");
//		String adminPass = propertyFileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH, "adminPass");
//		adminLoginPage.loginInToUserAccount(adminUN,adminPass);
//		
//		CommonPage commonPage=new CommonPage(driver);
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.ORDER_MANAGEMEN.getTabName());
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.MANAGE_PRODUCTS.getTabName());
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.CREATE_CATEGORY.getTabName());
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.SUB_CATEGORY.getTabName());
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.INSERT_PRODUCT.getTabName());
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.MANAGE_PRODUCTS.getTabName());
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.USER_LOGIN_LOG.getTabName());
//		commonPage.clickOnUserDropDwon();
//		commonPage.clickOnRequiredTab(AdminEnumTabNames.CHANGE_PASSWORD.getTabName());
//		commonPage.clickOnUserDropDwon();
//		commonPage.clickOnLogOutButton();
//		
//		
//		
////		DataBaseUtility dataBaseUtility=new DataBaseUtility();
////		dataBaseUtility.openDBConnection(IConstanceUtility.DATABASEPATH, "root", "root");
////		List<String> list = dataBaseUtility.getDataFromDataBase("select * from sdet40;", "emp_name");
////		System.out.println(list);
////		dataBaseUtility.closeDataBaseConnection();
//	}
//}
