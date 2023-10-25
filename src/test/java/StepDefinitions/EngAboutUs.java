package StepDefinitions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;
import PageObjects.AboutUs;
import PageObjects.HomePage;

public class EngAboutUs  extends Base {
	public  WebDriver driver;
	HomePage HomePage;
	AboutUs AboutUs;
	AfterHooks AfterHooks;
	
	
	@Before("@pass")
public void openBrowser() throws IOException {
		
		driver=initializeBrowser();

	    }  
	    @Given("^i go to homepage sixsentix$")
	    public void i_go_to_homepage_sixsentix() throws InterruptedException {
		
	    	driver.get(prop.getProperty("url"));
	      
	       
	     
	    }

	    @When("^i turn off alert$")
	    public void i_turn_off_alert() throws InterruptedException {
	    	
	    	HomePage=new HomePage(driver);
		    HomePage.alert();
		    HomePage.accept().click();
		}
	    
	    
		@And("^i move cursor on Life In Sixsentix$")
	    public void i_move_cursor_on_Life_In_Sixsentix() throws InterruptedException {
			Actions action = new Actions(driver);
			action.moveToElement(HomePage.LifeInSixsentix()).perform();
          
	    	Thread.sleep(1000);	    
	    }
		

	    @And("^i click on About Us$")
	    public void i_click_on_about_us() throws InterruptedException {
	    	
	    	HomePage.AboutUs().click();
	    	Thread.sleep(1000);
	    }
	   

	    @Then("^i see About Us page$")
	    public void i_see_about_us_page() throws InterruptedException {
	    	AboutUs=new AboutUs(driver);
	    	
	    	WebElement ExpectedElement = AboutUs.button();
	    	WebElement ActualElement=null;
	    	try{
	    		ActualElement = driver.findElement(By.xpath("//a[normalize-space()='Request a Proposal']"));
	    		
	    	}catch(Exception e){
	    		System.out.println("Test fail");
	    	}
	    	Assert.assertEquals(ActualElement, ExpectedElement);
	    
	        
	    }
	  
	    @After(order = 1, value = "@pass")
		public void afterFail(Scenario scenario) {
			
			AfterHooks = new AfterHooks(driver);
			 
			 AfterHooks.screenshot(scenario);
	   
	       
	    }
		@After(order = 0, value = "@pass")
		public void tearDown() {
			
			AfterHooks.close();
		
		}
}
