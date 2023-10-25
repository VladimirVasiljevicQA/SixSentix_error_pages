package StepDefinitions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import PageObjects.Contact;
import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;


public class DeContact extends Base {
	
	
	public WebDriver driver;
	HomePage HomePage;
	Contact contact;
	Actions action;
	AfterHooks AfterHooks;
	
	
	@Before("@fail_2")
	public void openBrowser() throws IOException {
			
		driver=initializeBrowser();
		
    } 
	@Given("^i go to homepage sixsentix DE2$")
    public void i_go_to_homepage_sixsentix() throws InterruptedException {
	
		driver.get(prop.getProperty("url"));
       Thread.sleep(1000);
       
     
    }

    @When("^i turn off alert DE2$")
    public void i__turn_off_alert_DE() throws InterruptedException {
    	
    	HomePage=new HomePage(driver);
	    HomePage.alert();
	    HomePage.accept().click();
	}
    @And("^i click on DE2$")
    public void i_click_on_DE() throws InterruptedException {
		
        HomePage.DE().click();
    	Thread.sleep(1000);	    
    }
    
	@And("^i move cursor on Leben In Sixsentix2$")
    public void i_move_cursor_on_Leben_in_Sixsentix() throws InterruptedException {
	      action = new Actions(driver);
	     action.moveToElement(HomePage.LebenInSixsentix()).perform();
       
    	Thread.sleep(1000);	    
    }

	@And("^i click on Kontakt$")
	public void i_click_on_Über_uns() throws InterruptedException {
	    	
	    	HomePage.Kontakt().click();
	    	Thread.sleep(1000);
    }

	   
	@Then("^i see Kontakt page$")
	public void i_see_Kontakt_page() throws InterruptedException {
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
	@After(order = 1, value = "@fail_2")
	public void afterFail(Scenario scenario) {
		
		AfterHooks = new AfterHooks(driver);
		 
		 AfterHooks.screenshot(scenario);
   
       
    }
	@After(order = 0, value = "@fail_2")
	public void tearDown() {
		
		AfterHooks.close();
	
	}
    
}
