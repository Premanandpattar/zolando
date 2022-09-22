package org.zolando;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.zolando.adminObjectRepositore.AdminTabNames;
import org.zolando.adminObjectRepositore.AdminTextFieldNamesAndImageUploadNames;
import org.zolando.adminObjectRepositore.CreateCategoryPage;
import org.zolando.adminObjectRepositore.CreateSubCategoryPage;
import org.zolando.adminObjectRepositore.EntriesDropDownOptions;
import org.zolando.adminObjectRepositore.InsertProductPage;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.PropertyKeysNames;
import org.zolando.genericUtilities.ThreadSafeClass;

public class CreateCategoryAndCreateSubCategoryAndInsertProductTest extends BaseClass {

	private List<Map<String, String>> listOfData;
	private String categoryName;
	private String subCategoryName;

	@Test
	public void createCategoryAndCreateSubCategoryAndInsertProductTest() {
		driverUtility.launchUrl(urlForAdmin);
		driverUtility.verifyWebPage("Sign In");
		ThreadSafeClass.getTest().info("URL launched");

		adminLoginPage.loginInToUserAccount(adminUserNamer, adminPassword);
		driverUtility.verifyWebPage("Logout");
		ThreadSafeClass.getTest().info("admin logged in");

		// createCatagoryTest
		listOfData = excelUtility.getDataFromExcelStoredInList(
				fileUtility.getDataFromPropertyFile(PropertyKeysNames.sheetName.toString()));
		adminCommonPage.clickOnRequiredTab(AdminTabNames.CREATE_CATEGORY);
		driverUtility.verifyWebPage("Manage Categories");
		ThreadSafeClass.getTest().info("Create category Page is opened");

		CreateCategoryPage createCategory = new CreateCategoryPage(driver, driverUtility);
		categoryName = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.CATEGORY_NAME)
				+ javaUtility.getRandomNumber(100);
		createCategory.createNewCategory(categoryName,
				listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.DESCRIPTION));

		driverUtility.selectOptionInDropDwon(createCategory.entriesDropDown(), EntriesDropDownOptions.SELECT_100);
		ArrayList<String> lastRowText = createCategory.getLastRowData();
		driverUtility.verifyResult(lastRowText.contains(categoryName));
		ThreadSafeClass.getTest().info("Category is created");

		// createSubCategoryTest
		adminCommonPage.clickOnRequiredTab(AdminTabNames.SUB_CATEGORY);
		driverUtility.verifyWebPage("SubCategory Name");
		ThreadSafeClass.getTest().info("Create sub category Page is opened");

		CreateSubCategoryPage subCategoryPage = new CreateSubCategoryPage(driver, driverUtility);
		subCategoryName = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.SUBCATEGORY_NAME);
		subCategoryPage.createSubCategory(driverUtility, categoryName, subCategoryName);
		driverUtility.selectOptionInDropDwon(subCategoryPage.entriesDropDown(), EntriesDropDownOptions.SELECT_100);
		ArrayList<String> lastRowText1 = subCategoryPage.getLastRowData();
		driverUtility.verifyResult(lastRowText1.contains(subCategoryName) && lastRowText1.contains(categoryName));
		ThreadSafeClass.getTest().info("Sub category is created");

		// insertProductTest
		adminCommonPage.clickOnRequiredTab(AdminTabNames.INSERT_PRODUCT);
		driverUtility.verifyWebPage("Product Name");
		ThreadSafeClass.getTest().info("Insert product Page is opened");

		InsertProductPage insertProductPage = new InsertProductPage(driver, driverUtility);
		String productName = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_NAME);
		String productCompany = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_COMPANY);
		String productPriceBD = listOfData.get(0)
				.get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_PRICE_BEFORE_DISCOUNT);
		String productPriceAD = listOfData.get(0)
				.get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_PRICE_AFTER_DISCOUNT);
		String prodictDescription = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_DESCRIPTION);
		String productShippingCharge = listOfData.get(0)
				.get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_SHIPPING_CHARGE);
		String ProductImagePath1 = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_IMAGE1);
		String ProductImagePath2 = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_IMAGE2);
		String ProductImagePath3 = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_IMAGE3);
		insertProductPage.insertProduct(categoryName, subCategoryName, productName, productCompany, productPriceBD,
				productPriceAD, prodictDescription, productShippingCharge, true, ProductImagePath1, ProductImagePath2,
				ProductImagePath3);
		adminCommonPage.clickOnRequiredTab(AdminTabNames.MANAGE_PRODUCTS);
		driverUtility.selectOptionInDropDwon(insertProductPage.entriesDropDown(), EntriesDropDownOptions.SELECT_100);
		ArrayList<String> lastRowText11 = insertProductPage.getLastRowData();
		driverUtility.verifyResult(lastRowText11.contains(subCategoryName) && lastRowText11.contains(categoryName)
				&& lastRowText11.contains(productName) && lastRowText11.contains(productCompany));
		ThreadSafeClass.getTest().info("Product is inserted");

		adminCommonPage.clickOnLogOutButton();
		driverUtility.verifyWebPage("Sign In");
		ThreadSafeClass.getTest().info("Admin logged out");
	}
}
