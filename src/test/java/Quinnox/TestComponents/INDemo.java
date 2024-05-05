package Quinnox.TestComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class INDemo {
	public static void main(String[] args) {
		
		
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			 driver=new ChromeDriver();
			 driver.get("https://www.google.com/");
			
			WebElement searchBoxElement = driver.findElement(By.xpath("https://www.google.com/"));
			
			if(searchBoxElement.isEnabled()) {
				
				Assert.assertTrue(true);
			}
		}
		catch(Exception e) {
			
				
				System.out.println("Element is not present on that webpage");
				
			
		}
		
	}

}
