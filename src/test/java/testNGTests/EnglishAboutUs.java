package testNGTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import PageObjects.AboutUs;
import PageObjects.HomePage;
import resources.Base;

public class EnglishAboutUs extends Base {

	public  WebDriver driver;
	HomePage HomePage;
	AboutUs AboutUs;
	Logger log;
	
	@BeforeMethod
	public void open() throws IOException {
		  
		log = LogManager.getLogger(EnglishAboutUs.class.getName());
		driver= initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Go to url");
	
	}
	@Test
	public void EnAboutUs() throws InterruptedException {
		
		
		HomePage=new HomePage(driver);
	    HomePage.alert();
	    HomePage.accept().click();
	    log.debug("Accept alert");
	    
	    Actions action = new Actions(driver);
		action.moveToElement(HomePage.LifeInSixsentix()).perform();
		log.debug("move cursor on dropdown");
        Thread.sleep(1000);	  
    	
    	HomePage.AboutUs().click();
    	log.debug("Click on About Us");
    	
    	
    	AboutUs=new AboutUs(driver);
    	
    	WebElement ExpectedElement = AboutUs.button();
    	WebElement ActualElement=null;
    	try{
    		ActualElement = driver.findElement(By.xpath("//a[normalize-space()='Request a Proposal']"));
    		log.debug("i see the page with full content");
    		System.out.println("Test pass");
    	}catch(Exception e){
    		
    		log.error("Test fail");
    	}
    	Assert.assertEquals(ActualElement, ExpectedElement);
    	
    	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.debug("Browser is closed");
	}
}
