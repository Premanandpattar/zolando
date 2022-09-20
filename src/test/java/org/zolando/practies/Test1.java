//package org.zolando.practies;
//
//import org.zolando.genericUtilities.DataType;
//import org.zolando.genericUtilities.IConstanceUtility;
//import org.zolando.genericUtilities.JavaUtility;
//import org.zolando.genericUtilities.PropertyFileUtility;
//import org.zolando.genericUtilities.WebDriverUtility;
//
//public class Test1 {
//
//	public static void main(String[] args) {
//		WebDriverUtility driverUtility = new WebDriverUtility();
//		PropertyFileUtility fileUtility = new PropertyFileUtility();
//		JavaUtility javaUtility =new JavaUtility();
//		long timeout = (long) javaUtility.convertStringToAnyDataType("20", DataType.LONG);
//
//		driverUtility.openApplication("chrome", timeout,
//				fileUtility.getDataFromPropertyFile(IConstanceUtility.PROPERTIYFILEPATH, "urlForAdmin"));
//		driverUtility.getScreenShot("./softwares/", "1234");
//	}
//}
