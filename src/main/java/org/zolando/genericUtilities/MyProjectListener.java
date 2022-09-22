package org.zolando.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyProjectListener implements ITestListener {

	private ExtentReports report;
	public ExtentTest log;

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/extentReport.html");
		spark.config().setDocumentTitle("ZolandoTestCaseReport");
		spark.config().setReportName("ZolandoProject");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Premanand");
		report.setSystemInfo("OS", "Win 7");

	}
	
	@Override
	public void onTestStart(ITestResult result) {
		log=report.createTest(result.getMethod().getMethodName());
		ThreadSafeClass.setTest(log);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ThreadSafeClass.getTest().pass(result.getMethod().getMethodName()+" is Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ThreadSafeClass.getTest().fail(result.getMethod().getMethodName()+" is Failed");
		ThreadSafeClass.getTest().fail(result.getThrowable());
		WebDriverUtility driverUtility = new WebDriverUtility();
		String path = driverUtility.getScreenShot(ThreadSafeClass.getDriver());
		ThreadSafeClass.getTest().addScreenCaptureFromBase64String(path,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ThreadSafeClass.getTest().skip(result.getMethod().getMethodName()+" is Skiped");
		ThreadSafeClass.getTest().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
