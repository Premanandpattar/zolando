package org.zolando;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.PropertyKeysNames;
import org.zolando.userObjectRepositore.UserTextFieldNames;

public class UserNewAccountCreationTest extends BaseClass {

	private List<Map<String, String>> listOfData;

	@Test
	public void userNewAccountCreationTest() {
		driverUtility.launchUrl(urlForUser);
		driverUtility.verifyWebPage("Shopping Portal");
//		MyProjectListener.log.info("URL is launched");

		userCommanPage.clickOnLogInLink();
		driverUtility.verifyWebPage("create a new account");
//		MyProjectListener.log.info("create a new account Page is opened");

		listOfData = excelUtility.getDataFromExcelStoredInList(
				fileUtility.getDataFromPropertyFile(PropertyKeysNames.sheetName.toString()));
		String fullName = listOfData.get(1).get(UserTextFieldNames.FULL_NAME);
		String emailAddress = javaUtility.getRandomNumber(100)
				+ listOfData.get(1).get(UserTextFieldNames.EMAIL_ADDRESS);
		String contactNo = javaUtility.getRandomNumber(100) + listOfData.get(1).get(UserTextFieldNames.CONTACT_NO);
		String Password = javaUtility.getRandomNumber(100) + listOfData.get(1).get(UserTextFieldNames.USER_PASSWORD);
		userLogInAndCreateNewAccountPage.createNewUserAccount(fullName, emailAddress, contactNo, Password);
		String alertText = driverUtility.getTextFromAlert();
		driverUtility.alertAccept();
		driverUtility.verifyResult(alertText, "You are successfully register");
//		MyProjectListener.log.info("Account is created");

		userLogInAndCreateNewAccountPage.loginInToUserAccount(emailAddress, Password);
		driverUtility.verifyWebPage(fullName);
//		MyProjectListener.log.info("Logged in through new user account");

		userCommanPage.clickonUserLogOut();
		driverUtility.verifyWebPage("Login");
//		MyProjectListener.log.info("User logged out");

	}

}
