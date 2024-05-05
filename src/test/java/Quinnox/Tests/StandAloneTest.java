package Quinnox.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import quinnox.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String productname = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
 driver.findElement(By.id("userEmail")).sendKeys("ajeetkumar.aaayg@gmail.com");
 driver.findElement(By.id("userPassword")).sendKeys("Rahulshetty@123");
 driver.findElement(By.id("login")).click();
 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 
	
	  List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
	  
	  WebElement prod = products.stream().filter(product->
	  product.findElement(By.cssSelector("b")).getText().equals(productname)).
	  findFirst().orElse(null);
	  prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	  //tg-animating
	  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	//(its taking much more time as performance is down when I am uding below code with respect to above one)  
	  //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	  driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    //driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	  
	  List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3 "));
	  boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname)); 
      Assert.assertTrue(match);
       driver.findElement(By.cssSelector(".totalRow button")).click();
 
 //.form-group input
       
       Actions a= new Actions(driver);
       a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        
       //(//button[@class='ta-item list-group-item ng-star-inserted'])[2]   
       driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
        driver.findElement(By.xpath("//a[.='Place Order ']")).click();
        
String ConfirMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(ConfirMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.close();

 
 
	}
}



