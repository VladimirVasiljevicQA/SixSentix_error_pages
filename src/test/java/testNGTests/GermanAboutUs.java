package testNGTests;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.Contact;
import PageObjects.HomePage;
import resources.Base;

public class GermanAboutUs extends Base {
	
	public WebDriver driver;
	HomePage HomePage;
	Contact contact;
	Actions action;
	
	@BeforeMethod
	public void openBrowser() throws IOException {
        driver=initializeBrowser();
		
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void DeAboutUs () throws InterruptedException {
		driver.get(prop.getProperty("url"));
	       Thread.sleep(1000);
	       HomePage=new HomePage(driver);
		    HomePage.alert();
		    HomePage.accept().click();
		    
		    HomePage.DE().click();
	    	Thread.sleep(1000);	  
	    	
	    	action = new Actions(driver);
		    action.moveToElement(HomePage.LebenInSixsentix()).perform();
	        Thread.sleep(1000);	    
	    	
	    	HomePage.Kontakt().click();
	    	
	    	
            contact = new Contact(driver);
	    	
	    	WebElement ExpectedElement = contact.KontaktText();
	    	WebElement ActualElement=null;
	    	try{
	    		ActualElement = driver.findElement(By.xpath("//h1[normalize-space()='Wir freuen uns über Ihre Kontaktaufnahme']"));
	    	}catch(Exception e){
	    		System.out.println("Test fail");
	    	}
	    	Assert.assertEquals(ActualElement, ExpectedElement);
	        
	 }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}

