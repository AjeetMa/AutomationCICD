package quinnox.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import quinnox.abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	 
	public LandingPage(WebDriver driver) {
		//intialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//pageFactory design
	  
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public ProductCataloge loginApp(String email,String pass) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductCataloge productcataloge= new ProductCataloge(driver);

		return productcataloge;
	}
	
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}
	public void goTO() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
		
	}
	
	
	
	
}
