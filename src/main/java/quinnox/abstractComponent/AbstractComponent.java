package quinnox.abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import quinnox.pageobjects.CartPage;
import quinnox.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;

	public void waitForElementtoAppear(By findBy) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	 //By.cssSelector(".mb-3")
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
		 //By.cssSelector(".mb-3")
		}
	
	public CartPage goToCartpage() {
		cartButton.click();

		CartPage cartpage=new CartPage(driver);
	return cartpage;
	}
	
	public OrderPage goToOrderspage() {
		orderHeader.click();

		OrderPage orderpage=new OrderPage(driver);
	return orderpage;
	}
	public void waitForElementtoDisAppear(WebElement ele) {
		
	 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.invisibilityOf(ele));
	
	}
	
}
