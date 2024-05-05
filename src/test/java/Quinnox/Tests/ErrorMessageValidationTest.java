package Quinnox.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Quinnox.TestComponents.BaseTest;
import quinnox.pageobjects.CartPage;
import quinnox.pageobjects.ProductCataloge;

public class ErrorMessageValidationTest extends BaseTest{
	
	@Test(groups={"errorHandling"})

	public void loginErroMessageValidations() throws IOException ,InterruptedException{
		
		landingpage.loginApp("ajeetkumar.aaayg@gmail", "Rahulshetty@123");	
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	@Test(groups={"errorHandling"})
	public void productErrorValidation() throws IOException ,InterruptedException{
		String productname = "ZARA COAT 3";
		
		ProductCataloge productcataloge=landingpage.loginApp("ajeetkumar.aaayg@gmail.com", "Rahulshetty@123");
		List<WebElement> products = productcataloge.getProductList();
		productcataloge.addProductTocart(productname);
		CartPage cartpage=productcataloge.goToCartpage();
		Boolean match=cartpage.verifyProductDisplay("ZARA COAT 33");	
        Assert.assertFalse(match);
	}
}



