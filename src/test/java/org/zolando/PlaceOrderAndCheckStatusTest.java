package org.zolando;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.zolando.adminObjectRepositore.AdminTabNames;
import org.zolando.adminObjectRepositore.AdminTextFieldNamesAndImageUploadNames;
import org.zolando.adminObjectRepositore.EntriesDropDownOptions;
import org.zolando.adminObjectRepositore.TodayOrderPage;
import org.zolando.adminObjectRepositore.UpdateOrderPage;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.PropertyKeysNames;
import org.zolando.genericUtilities.ThreadSafeClass;
import org.zolando.userObjectRepositore.TrackOrderPage;
import org.zolando.userObjectRepositore.UserLoggedinInterfacePage;
import org.zolando.userObjectRepositore.UserTextFieldNames;

public class PlaceOrderAndCheckStatusTest extends BaseClass {
	
	private List<Map<String, String>> listOfData;

	@Test
	public void placeOrderAndCheckStatusTest() {
		driverUtility.launchUrl(urlForUser);
		driverUtility.verifyWebPage("Shopping Portal");
		ThreadSafeClass.getTest().info("URL is launched");
		
		userCommanPage.clickOnLogInLink();
		driverUtility.verifyWebPage("sign in");
		ThreadSafeClass.getTest().info("Log in Page is opened");
		
		
		listOfData=excelUtility.getDataFromExcelStoredInList(fileUtility.getDataFromPropertyFile(PropertyKeysNames.sheetName.toString()));
		String emailAddress = listOfData.get(0).get(UserTextFieldNames.EMAIL_ADDRESS);
		String Password = listOfData.get(0).get(UserTextFieldNames.USER_PASSWORD);	
		userLogInAndCreateNewAccountPage.loginInToUserAccount(emailAddress, Password);
		driverUtility.verifyWebPage("Logout");
		ThreadSafeClass.getTest().info("User logged in");
		
		String productName = listOfData.get(0).get(AdminTextFieldNamesAndImageUploadNames.PRODUCT_NAME);
		userCommanPage.SearchTheProduct(productName);
		driverUtility.verifyWebPage(productName);
		ThreadSafeClass.getTest().info("User searched the product");
		
		UserLoggedinInterfacePage interfacePage=new UserLoggedinInterfacePage(driver,driverUtility);
		interfacePage.compliteProcedToCheckOut(productName);
		ThreadSafeClass.getTest().info("User completely check out the produt");
		
		driverUtility.creatNewTabSwitchToIt();
		driverUtility.launchUrl(urlForAdmin);
		driverUtility.verifyWebPage("Sign In");
		ThreadSafeClass.getTest().info("New Tab Created and URL launched");
		
		adminLoginPage.loginInToUserAccount(adminUserNamer, adminPassword);
		driverUtility.verifyWebPage("Logout");
		ThreadSafeClass.getTest().info("admin logged in");
		
		adminCommonPage.clickOnRequiredTab(AdminTabNames.ORDER_MANAGEMENT);
		adminCommonPage.clickOnTodayOrder();
		driverUtility.verifyWebPage("Email /Contact no");
		ThreadSafeClass.getTest().info("Today order's page is opened");
		
		TodayOrderPage orderPage =new TodayOrderPage(driver);
		driverUtility.selectOptionInDropDwon(orderPage.entriesDropDown(), EntriesDropDownOptions.SELECT_100);
		orderPage.clickOnLastUserEditLink();
		driverUtility.switchToWindow("updateorder");
		driverUtility.verifyWebPage("Update Order !");
		ThreadSafeClass.getTest().info("New update order is opened");
		
		UpdateOrderPage updateOrderPage=new UpdateOrderPage(driver, driverUtility);
		updateOrderPage.selectStatus(EntriesDropDownOptions.SELECT_DELIVERED);
		updateOrderPage.setRemark("order is Delivered");
		updateOrderPage.clickOnSubmit();
		driverUtility.alertAccept();
		driverUtility.verifyWebPage(EntriesDropDownOptions.SELECT_DELIVERED);
		ThreadSafeClass.getTest().info("order status is updated");
		
		driverUtility.switchToWindow(urlForAdmin);
		adminCommonPage.clickOnLogOutButton();
		driverUtility.verifyWebPage("Sign In");
		ThreadSafeClass.getTest().info("Admin logged out");
		
		driverUtility.switchToWindow(urlForUser);
		ThreadSafeClass.getTest().info("Control switch to user tab");
		interfacePage.clickOnLastTrackOrder();
		
		driverUtility.switchToWindow("track-order");
		ThreadSafeClass.getTest().info("Control switch to user window popUp");
		TrackOrderPage trackOrderPage =new TrackOrderPage(driver);
		String orderStatus = trackOrderPage.getStatus();
		driverUtility.verifyResult(EntriesDropDownOptions.SELECT_DELIVERED, orderStatus);
		ThreadSafeClass.getTest().info("User checked the product status");
		
		driverUtility.switchToWindow(urlForUser);
		ThreadSafeClass.getTest().info("Control switch to user tab");
		
		userCommanPage.clickonUserLogOut();
		driverUtility.verifyWebPage("Login");
		ThreadSafeClass.getTest().info("User logged out");
	}
}
