package scenario2Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Practice {
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

	@Test()
	public void loginTest() throws InterruptedException {

		// Find User name and enter user name
		WebElement txtUser = driver.findElement(By.name("username"));
		txtUser.sendKeys("Admin");
		// Find Password and enter password
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");
		// Login Button Click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul"));
		System.out.println(allElements);
		System.out.println("Total menu options are: " + allElements.size());

		for (WebElement element : allElements) {
			System.out.println(element.getText());
//			if(element.getText().contains("Admin")) {
//				element.click();
//				break;
//			}
		}
		////By username
//		Thread.sleep(3000);
//		
//		System.out.println("Search Employee by UserName");
//		WebElement uname = driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[2]"));
//		uname.sendKeys("Admin");
//		WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//		searchBtn.click();
//		Thread.sleep(3000);
//		
//		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]")).getText());
//		
//		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[2]")).clear();
		
//		//By UserRole
//		Thread.sleep(3000);
//		System.out.println("Search Employee by UserRole");
//		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")).click();
//		
//		List<WebElement> list=driver.findElements(By.xpath("//div[@role='listbox']//div[@role='option']"));
//		for(WebElement i:list)
//		{
//			if(i.getText().contains("Admin"))
//			{
//				i.click();
//				break;
//			}
//		}
//		
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]")).getText());
//		
//		driver.navigate().refresh();
//		
//		//By Status
//		Thread.sleep(3000);
//		System.out.println("Search Employee by Status");
//		
//		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
//		List<WebElement> list1=driver.findElements(By.xpath("//div[@role='option']//span"));
//		for(WebElement i:list1)
//		{
//			if(i.getText().contains("Enabled"))
//			{
//				i.click();
//				break;
//			}
//		}
//		
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]")).getText());
	}
}





















