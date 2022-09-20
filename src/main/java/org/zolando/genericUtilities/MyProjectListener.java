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
	public static ExtentTest log;
	public ExtentTest log1;

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
		log1=log;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.pass(result.getMethod().getMethodName()+" is Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.fail(result.getMethod().getMethodName()+" is Failed");
		log.fail(result.getThrowable());
		WebDriverUtility driverUtility = new WebDriverUtility();
		String path = driverUtility.getScreenShot(BaseClass.sDriver);
		log.addScreenCaptureFromBase64String(path,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.skip(result.getMethod().getMethodName()+" is Skiped");
		log.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
