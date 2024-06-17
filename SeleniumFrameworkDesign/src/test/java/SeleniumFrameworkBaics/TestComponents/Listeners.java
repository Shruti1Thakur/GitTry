package SeleniumFrameworkBaics.TestComponents;

import org.testng.ITestListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumFrameworkBaics.resources.ExtendReporterNG;


public class Listeners extends BaseTest implements ITestListener 
{
	ExtentTest test;
	ExtentReports extent= ExtendReporterNG.getReportObject();
	@Override
	public void onTestStart(ITestResult result)
	{
		test= extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		//Attach SS to report
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

}
