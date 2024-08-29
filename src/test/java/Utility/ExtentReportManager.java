package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	ExtentSparkReporter sparkReporter; //UI Of the report
	ExtentReports extent; //populate common info of the report
	ExtentTest test; //creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context)
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/ExtentReports/OHRMTestReport.html");//("OHRMLTestExtentReport.html");//(".\\ExtentReports\\OHRMExtentReport.html");// // Specify the path
		
		sparkReporter.config().setDocumentTitle("OHRM Login Page Test Report"); //Title of report
		sparkReporter.config().setReportName("Login Functionality Testing"); //name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "Bishal_HP");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Bishal Pradhan");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser Name", "Chrome");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.PASS, "Test Case PASSED is: "+result.getName()); //update status p/f/s
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED is:"+result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is:"+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped Is:"+result.getName());
	}
	
}














