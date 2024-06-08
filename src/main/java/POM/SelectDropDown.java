package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dnt.douglas.util.WebActionUtil;

import util.UtilClass;

public class SelectDropDown extends  UtilClass {


	 WebDriver driver;
	 WebDriverWait wait;
	 JavascriptExecutor js;
	 
	  public SelectDropDown(WebDriver driver)
		{
		  this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
			
	  
	


public void handleHeadLine() throws InterruptedException
{
	   wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement headline = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='headline-bold product-overview__headline']")));
	    WebElement Element =  explicitWait(driver, headline);
	        System.out.println("headline = " + headline.isDisplayed());
	        js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1200)");
	        js.executeScript("arguments[0].scrollIntoView(true);", headline);      
	        Thread.sleep (9000);
	       
}

public void selectDropDownOption() throws InterruptedException
{
	
	 //click on dropdown
    WebElement dropdownButton = driver.findElement(By.cssSelector("div[data-testid='flags']"));
    dropdownButton.click();
    
    
    Thread.sleep(5000);
    // Locate all checkbox elements within the dropdown
    List<WebElement> checkboxes = driver.findElements(By.cssSelector(".facet__menu-content .facet-option__checkbox"));
    
 
   
    // Iterate over the checkboxes and click each one
    for (WebElement checkbox : checkboxes)
    	{
        if (!checkbox.isSelected()) {
        	 Thread.sleep(2000);
        	checkbox.click();
        	 Thread.sleep(3000);
        	 WebElement ele = driver.findElement(By.xpath("//button[normalize-space()='1314 Produkte anzeigen']"));
        	ele.click();
        }
    }

    // Optional: Add a pause to see the result before closing the browser
    try {
        Thread.sleep(3000); // Pause for 2 seconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	
}





       
       
      
       
}



