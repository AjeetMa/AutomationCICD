package quinnox.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import quinnox.abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	 
	public CartPage(WebDriver driver) {
		//intialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//pageFactory design
	  
	@FindBy(css=".cartSection h3 ")
	private List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement CheckoutEle;
	
	//driver.findElements(By.cssSelector(".cartSection h3 "));
	
	
	public Boolean verifyProductDisplay(String productname) {
		
		Boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	public CheckoutPage goToCheckout() {
		
		CheckoutEle.click();
		return new CheckoutPage(driver);
	}
	
	
	
	
}
