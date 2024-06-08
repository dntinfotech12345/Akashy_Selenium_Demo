package Base;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {

	static WebDriver driver;
	public static WebDriver getDriver() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-cookies");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.douglas.de/de");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	
	
		return driver;
	}
}
