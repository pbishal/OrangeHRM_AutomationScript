package Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {
	public WebDriver driver;
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
			System.out.println("ScreenShot captured!");
		}
//	  public static void captureScreenshot()
//		{
//			TakesScreenshot ts=(TakesScreenshot)driver;
//			File src=ts.getScreenshotAs(OutputType.FILE);
//			File dest=new File(System.getProperty("user.dir")+"//ScreenShots//OHRM"+System.currentTimeMillis()+".png");
//			try {
//				FileHandler.copy(src, dest);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("ScreenShot captured!");
//		}
	
	
	
//	public void getScreenshot()
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File(System.getProperty("user.dir")+"//ScreenShots//OHRM"+System.currentTimeMillis()+".png");
//		try {
//			FileHandler.copy(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
