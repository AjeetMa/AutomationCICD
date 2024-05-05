package Quinnox.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmzazonCalenderHandling {

	
	@Test
	public void calenderHandling () {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		
		
		
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement needElement = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		
		wait.until(ExpectedConditions.visibilityOf(needElement));
		
		
		  JavascriptExecutor java = (JavascriptExecutor)driver;
		  
		  java.executeScript("arguments[0].click();", needElement);
		  
		  
		  java.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 
		
	}
}
