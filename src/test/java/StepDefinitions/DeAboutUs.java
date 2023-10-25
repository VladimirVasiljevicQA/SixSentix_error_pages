package StepDefinitions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import PageObjects.AboutUs;
import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class DeAboutUs  extends Base {
	public  WebDriver driver;
	HomePage HomePage;
	AboutUs AboutUs;
	AfterHooks AfterHooks;
	
	
	@Before("@fail_1")
public void openBrowser() throws IOException {
		
driver=initializeBrowser();
		
		

	}   @Given("^i go to homepage sixsentix DE$")
	    public void i_go_to_homepage_sixsentix() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
	       Thread.sleep(1000);
	       
	     
	    }

	    @When("^i turn off alert DE$")
	    public void i__turn_off_alert_DE() throws InterruptedException {
	    	
	    	HomePage=new HomePage(driver);
		    HomePage.alert();
		    HomePage.accept().click();
		}
	    @And("^i click on DE$")
	    public void i_click_on_DE() throws InterruptedException {
			
            HomePage.DE().click();
	    	Thread.sleep(1000);	    
	    }
	    
		@And("^i move cursor on Leben In Sixsentix$")
	    public void i_move_cursor_on_Leben_in_Sixsentix() throws InterruptedException {
		     Actions action = new Actions(driver);
		     action.moveToElement(HomePage.LebenInSixsentix()).perform();
           
	    	Thread.sleep(1000);	    
	    }

	    @And("^i click on Über uns$")
	    public void i_click_on_Über_uns() throws InterruptedException {
	    	
	    	HomePage.Überuns().click();
	    	Thread.sleep(1000);
	    }

	   
	    @Then("^i see Über uns page$")
	    public void i_see_Über_uns_page() throws InterruptedException {
	    	AboutUs=new AboutUs(driver);
	    	
	    	WebElement ExpectedElement = AboutUs.DEbutton();
	    	WebElement ActualElement=null;
	    	try{
	    		ActualElement = driver.findElement(By.xpath("//a[normalize-space()='Angebot anfordern']"));
	    	}catch(Exception e){
	    		System.out.println("Test fail");
	    	}
	    	Assert.assertEquals(ActualElement, ExpectedElement);
	    	
	        
	    }
	    @After(order = 1, value = "@fail_1")
		public void afterFail(Scenario scenario) {
			
			AfterHooks = new AfterHooks(driver);
			 
			 AfterHooks.screenshot(scenario);
	   
	       
	    }
		@After(order = 0, value = "@fail_1")
		public void tearDown() {
			
			AfterHooks.close();
		
		}

}
