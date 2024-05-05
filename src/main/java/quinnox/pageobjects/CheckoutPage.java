package quinnox.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import quinnox.abstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	
	WebDriver driver;
	 
	public CheckoutPage(WebDriver driver) {
		//intialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//a[.='Place Order ']")
	WebElement submit;
	
	@FindBy(xpath="(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement selectCountry;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	By results= By.cssSelector(".ta-results");
	public void selectCountry(String countryName) {
		
		 Actions a= new Actions(driver);
	       a.sendKeys(country,countryName).build().perform();
	       waitForElementtoAppear(results);
	       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	        
	       //(//button[@class='ta-item list-group-item ng-star-inserted'])[2] 
	       selectCountry.click();
	    	
	}
	public ConfirmationPage submitOrder() {
	       submit.click();		
return new ConfirmationPage(driver);
	}
	
	
	
	
	
	
}
