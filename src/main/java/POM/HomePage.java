package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.UtilClass;

public class HomePage extends UtilClass {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath= "//li[@data-uid='FragrancesNavNode_DE']")
	private WebElement perfumeTag;
	

 

    public void moveToPerfumeTag(){
    	WebElement element = explicitWait(driver, perfumeTag);
		element.click();

}
	public void clickOnAcceptAll() throws InterruptedException{
	 WebElement cookieButton = driver.findElement(By.xpath("//button[contains(text(), 'ALLE ERLAUBEN')]"));
		

        // Click the cookie element
        cookieButton.click();

        // Optionally, wait for a while to observe the action
        try {
            Thread.sleep(10000);  // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//element.click();
	}

}
