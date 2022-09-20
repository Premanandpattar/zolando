package org.zolando.practies;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractiesTest {
	// if you are having more then 20 steps in tc-->storing all the testCase in
	// module wise package--> className= testCase Name, testAnotationMethodName=stepName 
	//	if you are have 5 to 10 steps in tc-->storing all the testCase in
	// single package--> className= moduleName, testAnotationMethodName=testCaseName
	

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("beforeSuite", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("beforeSuite", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("beforeSuite", true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("beforeSuite", true);
	}

	@Test(priority = 0)
	public void step1Test() {
		System.out.println("scrip1");
	}

	@Test(priority = 1)
	public void step2Test() {
		System.out.println("scrip2");
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("afterSuite", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("afterTest", true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("afterClass", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("afterMethod", true);
	}

}
