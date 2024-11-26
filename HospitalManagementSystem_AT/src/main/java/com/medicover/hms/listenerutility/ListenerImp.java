package com.medicover.hms.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.medicover.hms.basetest.BaseUtility;

public class ListenerImp implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	private static ThreadLocal<ExtentTest> extest = new ThreadLocal<ExtentTest>();

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");

		String time = new Date().toString().replace(" ", "_").replace(":", " ");
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_" + time + ".html");

		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add environment information and crate test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		System.out.println("====" + result.getMethod().getMethodName() + ">=======START========");
		test = report.createTest(result.getMethod().getMethodName());

		test.log(Status.INFO, result.getMethod().getMethodName() + "==>STARTED<==");
		extest.set(test);

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		// take screenshot
		TakesScreenshot eDriver = (TakesScreenshot) BaseUtility.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

		// WebDriverUtility w = new WebDriverUtility();
		String time = new Date().toString().replace(" ", "_").replace(":", " ");
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==>FAILED<==");
		test.log(Status.FAIL, result.getThrowable());

//		try {
//			w.takeScreenshotEntirePage(BaseClass.sdriver, testName + time);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.FAIL, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("====" + result.getMethod().getMethodName() + ">=======END========");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==>COMPLETED<==");
		extest.get();
	}

}
