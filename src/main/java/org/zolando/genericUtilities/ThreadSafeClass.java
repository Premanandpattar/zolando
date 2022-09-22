package org.zolando.genericUtilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafeClass {

	
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javaUtility=new ThreadLocal<>();
	
	//getters and setters
	public static ExtentTest getTest() {
		return test.get();
	}

	public static void setTest(ExtentTest sTest) {
		test.set(sTest);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver sdriver) {
		driver.set(sdriver);
	}
	
	public static JavaUtility getJavaUtility() {
		return javaUtility.get();
	}

	public static void setJavaUtility(JavaUtility sJavaUtility) {
		javaUtility.set(sJavaUtility);
	}	
}
