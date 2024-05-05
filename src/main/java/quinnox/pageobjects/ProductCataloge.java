package quinnox.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import quinnox.abstractComponent.AbstractComponent;

public class ProductCataloge extends AbstractComponent {
	
	WebDriver driver;
	 
	public ProductCataloge(WebDriver driver) {
		//intialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	//products =driver.findElements(By.cssSelector(".mb-3"));
	//pageFactory design
	  
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productBy=By.cssSelector(".mb-3");
	By accToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage= By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElementtoAppear(productBy);
		return products;
	}
	public WebElement getProductbyname(String productname) {
		
		WebElement prod = getProductList().stream().filter(product->
		  product.findElement(By.cssSelector("b")).getText().equals(productname)).
		  findFirst().orElse(null);
		return prod;
	}
	public void addProductTocart(String productname) {
		
		WebElement prod=getProductbyname(productname);
		 prod.findElement(accToCart).click();
		 waitForElementtoAppear(toastMessage);
		 waitForElementtoDisAppear(spinner);
		 

	
	}
	
}
