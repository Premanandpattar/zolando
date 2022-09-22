package org.zolando;

import org.testng.annotations.Test;
import org.zolando.adminObjectRepositore.AdminTabNames;
import org.zolando.adminObjectRepositore.CreateCategoryPage;
import org.zolando.adminObjectRepositore.CreateSubCategoryPage;
import org.zolando.adminObjectRepositore.ManageProductsPage;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.MyProjectListener;
import org.zolando.genericUtilities.ThreadSafeClass;

public class DeleteAllProductsAndDeleteAllSubCategoryAndDeleteAllCategoryTest extends BaseClass {

	@Test
	public void deleteAllProductsAndDeleteAllSubCategoryAndDeleteAllCategoryTest() {
		driverUtility.launchUrl(urlForAdmin);
		driverUtility.verifyWebPage("Sign In");
		ThreadSafeClass.getTest().info("URL launched");
		adminLoginPage.loginInToUserAccount(adminUserNamer, adminPassword);
		driverUtility.verifyWebPage("Logout");
		ThreadSafeClass.getTest().info("admin logged in");
		
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.MANAGE_PRODUCTS);
		driverUtility.verifyWebPage("Product Creation Date");
		ThreadSafeClass.getTest().info("Manage product Page is Opened");
		ManageProductsPage manageProductsPage=new ManageProductsPage(driver, driverUtility);
		manageProductsPage.deleteAllProducts();
		driverUtility.verifyWebPage("No data available in table");
		ThreadSafeClass.getTest().info("All products are deleted");
		
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.SUB_CATEGORY);
		driverUtility.verifyWebPage("SubCategory Name");
		ThreadSafeClass.getTest().info("Sub category Page is Opened");
		CreateSubCategoryPage createSubCategoryPage =new CreateSubCategoryPage(driver, driverUtility);
		createSubCategoryPage.deleteAllSubCategory();
		driverUtility.verifyWebPage("No data available in table");
		ThreadSafeClass.getTest().info("All sub category are deleted");
		
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.CREATE_CATEGORY);
		driverUtility.verifyWebPage("Enter category Name");
		ThreadSafeClass.getTest().info("Category Page is Opened");
		CreateCategoryPage createCategoryPage = new CreateCategoryPage(driver, driverUtility);
		createCategoryPage.deleteAllCategory();	
		driverUtility.verifyWebPage("No data available in table");
		ThreadSafeClass.getTest().info("All category are deleted");
		
		adminCommonPage.clickOnLogOutButton();
		driverUtility.verifyWebPage("Sign In");
		ThreadSafeClass.getTest().info("Admin logged out");
	}

}
