package TestScenarios;

//import java.text.SimpleDateFormat;
//import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class MyListener implements ITestListener 
{
//	utility util = new utility(); extends datDrivenTest
	public ExtentSparkReporter sparkReporter; //UI Of the report
	public ExtentReports extent; //populate common info of the report
	public ExtentTest test; //creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context)
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/OHRMAutomation.html"); //(".\\ExtentReports\\OHRMExtentReport.html"); // Specify the path
		
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
//		captureScreenshot(result.getTestClass().getRealClass().getSimpleName()+timestamp()+".png");
	}
//	private String timestamp()
//	{
//		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED is:"+result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is:"+result.getThrowable());
//		captureScreenshot(".png");
	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped Is:"+result.getName());
	}
	
	
	
	

	
//	  public void onStart(ITestContext context) {
//		  System.out.println("Test execution is started....");
//	  }
//	  
//	  public void onTestStart(ITestResult result) {
//		  System.out.println("Test started....");
//
//	  }
//	  
//	  public void onTestSuccess(ITestResult result) {
//		  System.out.println("Test passed....");
//
//	  }
//	  
//	  public void onTestFailure(ITestResult result) {
//		  System.out.println("Test failed....");
//
//	  }
//	  
//	  public void onTestSkipped(ITestResult result) {
//		  System.out.println("Test skipped....");
//
//	  }
//	  
//	  public void onFinish(ITestContext context) {
//		  System.out.println("Test execution is completed....");
//
//	  }
}
