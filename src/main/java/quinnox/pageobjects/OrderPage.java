package quinnox.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import quinnox.abstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	 
	public OrderPage(WebDriver driver) {
		//intialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//pageFactory design
	  
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsName;
	

	
	//driver.findElements(By.cssSelector(".cartSection h3 "));
	
	
	public Boolean verifyOrderDisplay(String productname) {
		
		Boolean match = productsName.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	/*
	 * public CheckoutPage goToCheckout() {
	 * 
	 * CheckoutEle.click(); return new CheckoutPage(driver); }
	 */
	
	
	
}
