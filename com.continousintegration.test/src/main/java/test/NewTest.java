package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	
	static WebDriver driver;
	static String Title="Gauge | ThoughtWorks";
	static String BrowserTitle=null;
	
	
	@BeforeClass
	public static void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\com.continousintegration.test\\src\\main\\resources\\chromedriver_2.37.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public static void assertBrowserTitle() throws InterruptedException {
		
		driver.get("https://gauge.org/");
		Thread.sleep(1000);
		BrowserTitle=driver.getTitle();
		Assert.assertEquals(Title, BrowserTitle);
		System.out.println("Browser opened and Title is the same");
	}
	
	@AfterClass
	public static void closeBrowser() {
		
		driver.close();
		
	}
}

