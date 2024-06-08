package Test;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Base.BaseClass;
import POM.HomePage;
import POM.SelectDropDown;
import util.Reports;

public class TestClass {

	public WebDriver driver;
	public class Testclass {
		
		
		  WebDriver driver;
		  HomePage hp;
		  SelectDropDown sd;
		  
		  
		  @BeforeClass()
		  public void beforeClass() throws InterruptedException
		  {
			 driver = BaseClass.getDriver();
			
		  }
		  
		  @BeforeMethod()
		  public void beforeMethod()
		  {
			   hp = new HomePage(driver);
			   sd = new SelectDropDown(driver);
			
			   //h = new HomePage(driver);
		  }
		  
		  @Test(priority = 0)
		  public void clickOnCoockie() throws InterruptedException
		  {
			hp.clickOnAcceptAll();
			hp.moveToPerfumeTag();
		  }
		  
		  @Test(priority = 2)
		  public void clickOnDropDown() throws InterruptedException
		  {
			 sd.handleHeadLine();
			 sd.selectDropDownOption();
		  }
	  
		  @AfterMethod()
		  public void AfterMethod()
		  {
			  
		  }
		  
		  @AfterClass()
		  
			  public void afterClass()
			  {
			  driver.quit();
		  }

		  
//		 
}
	 
	 
}



