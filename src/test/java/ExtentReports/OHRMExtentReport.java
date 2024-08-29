package ExtentReports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OHRMExtentReport {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter(".\\ExtentReports\\OHRMExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "HP");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("User", "Bishal Pradhan");
		reports.setSystemInfo("Browser", "Chrome");

		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("OHRM Extent Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@Test
	public void LaunchBrowser() {
		test = reports.createTest("Launch browser and open url");
		Assert.assertTrue(true);// test passed
	}

	@Test
	public void verifyTitle() {
		test = reports.createTest("verify the title");
		Assert.assertTrue(false);// test failed
	}

	@Test
	public void verifyLogo() {
		test = reports.createTest("verify the logo");
		Assert.assertTrue(true);// test pass
	}

	@Test
	public void verifyEmail() {
		test = reports.createTest("verify the email");
		throw new SkipException("Skipping the tc with exception.....");
	}

	@Test
	public void verifyUserName() {
		test = reports.createTest("verify the email");
		Assert.assertTrue(true);// test pass
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.YELLOW));
		}
	}
	
	@AfterTest
	public void Teardown()
	{
		reports.flush();
	}
}


















