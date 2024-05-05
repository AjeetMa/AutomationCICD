package Quinnox.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Quinnox.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import quinnox.pageobjects.CartPage;
import quinnox.pageobjects.CheckoutPage;
import quinnox.pageobjects.ConfirmationPage;
import quinnox.pageobjects.LandingPage;
import quinnox.pageobjects.OrderPage;
import quinnox.pageobjects.ProductCataloge;

public class SubmitOrderTest extends BaseTest{
	String productname = "ZARA COAT 3";
	@Test(dataProvider= "getData",groups= {"Purchase"})

	public void submitOrder(HashMap<String, String> input) throws IOException ,InterruptedException{
		
		
		ProductCataloge productcataloge=landingpage.loginApp(input.get("email"), input.get("password"));
		List<WebElement> products = productcataloge.getProductList();
		productcataloge.addProductTocart(input.get("product"));
		CartPage cartpage=productcataloge.goToCartpage();
		Boolean match=cartpage.verifyProductDisplay(input.get("product"));	 
        Assert.assertTrue(match);
        CheckoutPage checkout= cartpage.goToCheckout();
        checkout.selectCountry("India");
        ConfirmationPage crmPage=checkout.submitOrder();
       String confirmMessage = crmPage.getConfirmationPage();
       Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistory() {
		//verify the added item is displayed in cart page or not
		
		ProductCataloge productcataloge=landingpage.loginApp("ajeetkumar.aaayg@gmail.com", "Rahulshetty@123");

		OrderPage orderpage=productcataloge.goToOrderspage();
		
		Assert.assertTrue(orderpage.verifyOrderDisplay(productname));
	}
	
	@DataProvider
	public Object[][] getData() {
		
		
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("email", "ajeetkumar.aaayg@gmail.com");
		map.put("password", "Rahulshetty@123");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1=new HashMap<String,String>();
		map1.put("email", "ajeetkumar.grd301@gmail.com");
		map1.put("password", "Password@1");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
		
	}
	
	
}



