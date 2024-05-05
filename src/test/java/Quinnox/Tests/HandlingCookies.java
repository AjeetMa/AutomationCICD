package Quinnox.Tests;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HandlingCookies {

	
@Test
public void handleCokies() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	
Set<Cookie>cookies=driver.manage().getCookies();
driver.manage().window().maximize();
driver.manage().getCookies();
System.out.println(cookies.size());
//get all the cookies 
/*
 * for(Cookie cokkie:cookies) { System.out.println(cokkie.getName()+" and "+
 * cokkie.getValue());
 * 
 * }
 */

//get cookie by its name 
//System.out.println(driver.manage().getCookieNamed("ajeet ka cookie"));
driver.close();

Cookie argc= new Cookie("mycookies","125336545252");	
driver.manage().addCookie(argc);
//System.out.println(driver.manage().getCookieNamed("ajeet ka cookie"));
}
	
}
