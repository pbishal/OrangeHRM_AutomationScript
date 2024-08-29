package TestScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRM {
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	
	
	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test Case Execution");
		
		// chrome driver setup
		driver = new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// opening the url
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
	}
	@Test(priority = 0)
	public void loginTest() throws InterruptedException
	{
		System.out.println("The Current Url is: " + driver.getCurrentUrl());
		
		//Find User name and enter user name
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		
		//Find Password and enter password
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		
		//Login Button Click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
		
		//verify if the login was successful by checking the page title or a specific element
//		String currentURL = driver.getCurrentUrl();
		/*if(currentURL.contains("dashboard"))
		{
			System.out.println("Login Successful!");
		}
		else
		{
			System.out.println("Login failed!");
		}*/
//		Assert.assertEquals("dashboard", currentURL);
	}
//	public void logOutTest()
//	{
//		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
//		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
//	}
//	@Test(priority = 1)
//	public void AdminTest()
//	{
//		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
//		WebElement dropList = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]"));
//		Select roles = new Select(dropList);
//		System.out.println("By Default the selected country is: " + roles.getFirstSelectedOption().getText());
//		List<WebElement>rolesList = roles.getOptions();
//		System.out.println("All the countries are: " + rolesList.size());
//		
//
//	}
	
	@AfterTest
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(5000); //Wait for 5 sec before quit
		driver.close();
		driver.quit();
	}

}














