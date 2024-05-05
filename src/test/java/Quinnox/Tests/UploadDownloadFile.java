package Quinnox.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadDownloadFile {
	
	@Test
	public void  upLoad() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
	 
	 //driver.findElement(By.id("downloadButton")).click();
	 System.out.println("pass");
	 
	 String price=driver.findElement(By.xpath("//div[@id='cell-2-undefined']")).getText();
		System.out.println(price);
	 
	 /*
		 * WebElement upload= driver.findElement(By.cssSelector("input[type='file']"));
		 * //C:\Users\ajeet\Downloads
		 * upload.sendKeys("/Users/ajeet/Downloads/download.xlsx"); By popupLocators=
		 * By.xpath("//div[@role='alert']/div[2]");
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocators));
		 * 
		 * String toatsMessage=driver.findElement(popupLocators).getText();
		 * 
		 * Assert.assertEquals(toatsMessage, "Updated Excel Data Successfully.");
		 * 
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(popupLocators));
		 */
	
	
	
	
	
	
	
	
	
	
	
	 
	}

}
