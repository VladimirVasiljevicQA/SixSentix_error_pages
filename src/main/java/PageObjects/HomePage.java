package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	public HomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	 @FindBy(xpath="//li[@class='menu-item-has-children']//a[@href='#'][normalize-space()='Life at Sixsentix']")
	 private WebElement LifeInSixsentix;
	 @FindBy(xpath="//a[@href='https://www.sixsentix.com/life-at-sixsentix/about-us']//span[@class='menu-item-title']")
	 private WebElement AboutUs;
	 @FindBy(xpath="findElement(By.xpath(\"//*[@role='dialog'][@class='lcc-modal lcc-modal--alert js-lcc-modal js-lcc-modal-alert']\"));")
	 private WebElement alert;
	 @FindBy(xpath=("//button[@class='button button-primary js-lcc-accept']"))
	 private WebElement Accept;
	 
	 
	 @FindBy(xpath="//div[@class='language-menu']//a[normalize-space()='DE']")
	 private WebElement DE;
	 @FindBy(xpath="//li[@class='menu-item-has-children']//a[normalize-space()='Leben in Sixsentix']")
	 private WebElement LebenInSixsentix;
	 @FindBy(xpath="//span[@class='menu-item-description'][text()='Erfahre mehr über das Unternehmen, den Erfolgsweg und die Grundwerte']")
	 private WebElement Überuns;
	 @FindBy(xpath="//span[normalize-space()='Kontakt']")
	 private WebElement Kontakt;
	 
	 
	 public WebElement LifeInSixsentix() {
		 return LifeInSixsentix;
	 }
	 public WebElement AboutUs() {
		 return AboutUs;
	 }
	 public WebElement alert() {
		 return alert;
	 }
	 public WebElement accept() {
		 return Accept;
	 }
	 
	 
	 public WebElement DE() {
		 return DE;
	 }
	 public WebElement LebenInSixsentix() {
		 return LebenInSixsentix;
	 }
	 public WebElement Überuns() {
		 return Überuns;
	 }
     public WebElement Kontakt() {
	     return Kontakt;
}
	 
}
