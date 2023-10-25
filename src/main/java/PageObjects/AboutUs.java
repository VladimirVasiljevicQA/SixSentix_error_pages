package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUs {
WebDriver driver;
	
	public AboutUs (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Request a Proposal']")
	private WebElement button;
	@FindBy(xpath="//a[normalize-space()='Angebot anfordern']")
	private WebElement DEbutton;

	public WebElement button() {
		return button;
	}
	public WebElement DEbutton() {
		return DEbutton;
	}
}
