package Quinnox.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import quinnox.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	


public WebDriver intializeDriver() throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//quinnox//resources//GlobalData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox")) {
		//firefox
	}
else if(browserName.equals("edge")) {
		
		//edge
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	return driver;

}
public String getScrrenshot(String testCaseName,WebDriver driver) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
	FileUtils.copyFile(src, dest);
	return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	
}
@BeforeMethod(alwaysRun=true)
public LandingPage  launcApplication() throws IOException {
	
	driver=intializeDriver();
	landingpage = new LandingPage(driver);
	landingpage.goTO();
	return landingpage;
}
	
@AfterMethod(alwaysRun=true)
public void tearDown()
{
	driver.close();

}
	
}
