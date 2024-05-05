package Quinnox.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import quinnox.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentReports extent=ExtentReportNG.getReportobject();
	
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult results) {
		extent.createTest(results.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSuccess(ITestResult results) {
		test.log(Status.PASS, "Test passed");
		
		
	}
	@Override
	public void onTestFailure(ITestResult results) {
		test.fail(results.getThrowable());
		
		try {
			driver=(WebDriver) results.getTestClass().getRealClass().getField("driver").get(results.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String filePath=null;
		try {
			 filePath = getScrrenshot(results.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, results.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSkipped(ITestResult results) {
		
		
		
	}
	
	public void onTestFinish(ITestResult results) {
		extent.flush();
		
	}
	
	

}
