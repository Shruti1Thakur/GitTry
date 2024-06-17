package SeleniumFrameworkBaics.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationResult");
		reporter.config().setDocumentTitle("TestResult");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shruti Thakur");
		return extent;
	}
	
}
