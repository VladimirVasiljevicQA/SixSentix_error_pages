package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
WebDriver driver;
	
	public Contact (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Wir freuen uns über Ihre Kontaktaufnahme']")
	private WebElement KontaktText;
	

	
	
	public WebElement KontaktText() {
		return KontaktText;
	}
}
