package org.zolando;

import org.testng.annotations.Test;
import org.zolando.adminObjectRepositore.AdminTabNames;
import org.zolando.adminObjectRepositore.CreateCategoryPage;
import org.zolando.adminObjectRepositore.CreateSubCategoryPage;
import org.zolando.adminObjectRepositore.ManageProductsPage;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.MyProjectListener;

public class DeleteAllProductsAndDeleteAllSubCategoryAndDeleteAllCategoryTest extends BaseClass {

	@Test
	public void deleteAllProductsAndDeleteAllSubCategoryAndDeleteAllCategoryTest() {
		driverUtility.launchUrl(urlForAdmin);
		driverUtility.verifyWebPage("Sign In");
		MyProjectListener.log.info("URL launched");
		adminLoginPage.loginInToUserAccount(adminUserNamer, adminPassword);
		driverUtility.verifyWebPage("Logout");
		MyProjectListener.log.info("admin logged in");
		
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.MANAGE_PRODUCTS);
		driverUtility.verifyWebPage("Product Creation Date");
		MyProjectListener.log.info("Manage product Page is Opened");
		ManageProductsPage manageProductsPage=new ManageProductsPage(driver, driverUtility);
		manageProductsPage.deleteAllProducts();
		driverUtility.verifyWebPage("No data available in table");
		MyProjectListener.log.info("All products are deleted");
		
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.SUB_CATEGORY);
		driverUtility.verifyWebPage("SubCategory Name");
		MyProjectListener.log.info("Sub category Page is Opened");
		CreateSubCategoryPage createSubCategoryPage =new CreateSubCategoryPage(driver, driverUtility);
		createSubCategoryPage.deleteAllSubCategory();
		driverUtility.verifyWebPage("No data available in table");
		MyProjectListener.log.info("All sub category are deleted");
		
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.CREATE_CATEGORY);
		driverUtility.verifyWebPage("Enter category Name");
		MyProjectListener.log.info("Category Page is Opened");
		CreateCategoryPage createCategoryPage = new CreateCategoryPage(driver, driverUtility);
		createCategoryPage.deleteAllCategory();	
		driverUtility.verifyWebPage("No data available in table");
		MyProjectListener.log.info("All category are deleted");
		
		adminCommonPage.clickOnLogOutButton();
		driverUtility.verifyWebPage("Sign In");
		MyProjectListener.log.info("Admin logged out");
	}

}
