package TestScenarios;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Excel_Utility;

@Listeners(ExtentReports.ExtentTestNGListener.class)
public class datDrivenTest {

	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static WebDriver driver;


	@BeforeTest
	public void setup() {
		System.out.println("Before Test Case Execution");

		// chrome driver setup
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// opening the url
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd, String exp) {

		System.out.println("The Current Url is: " + driver.getCurrentUrl());
		// Find User name and enter user name
		WebElement txtUser = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
		txtUser.sendKeys(user);
		// Find Password and enter password
		WebElement txtPassword = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
		txtPassword.sendKeys(pwd);
		// Login Button Click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		String exp_Url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String act_Url = driver.getCurrentUrl();
		
		if (exp.equals("Valid")) {
			if (exp_Url.equals(act_Url)) {
				driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
				driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
				
				Assert.assertTrue(true);
				
			} else {
				Assert.assertTrue(false);
			}
		} else if (exp.equals("Invalid")) {
			Assert.assertTrue(false);
//			if (exp_Url.equals(act_Url)) {
//				driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
//				driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
//				Assert.assertTrue(false);
//			} else {
//				Assert.assertTrue(true);
//			}
		}
		
	}
	public void captureScreenshot(Object fileName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//ScreenShots//"+fileName);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		/*
		 * String loginData[][] = { { "Admin", "admin123", "Valid" }, { "Nihal",
		 * "Nihal123", "Invalid" }, { "Bishal", "Bishal123", "Invalid" }, { "Ashish",
		 * "Ashishl123", "Invalid" } };
		 */
		// get the data from excel
		String path = ".\\dataFiles\\loginDetails.xlsx";

		Excel_Utility xlutil = new Excel_Utility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}

		return loginData;
	}
	@AfterTest
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000); // Wait for 5 sec before quit
		driver.close();
		driver.quit();
	}
}
