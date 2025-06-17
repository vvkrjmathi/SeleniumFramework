package vivekacademy.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver ;
	
	public LandingPage(WebDriver driver ) {
		super(driver) ;
		this.driver = driver ; 
		PageFactory.initElements(driver , this) ;
	}
	
	By userEmailWait = By.id("userEmail") ;
	By errorMessageWait = By.cssSelector("class*='flyInOut'") ;
	
	@FindBy(id = "userEmail")
	WebElement userEmail ;
	@FindBy(id= "userPassword")
	WebElement password ;
	@FindBy(id = "login")
	WebElement login ;
	@FindBy(css = "[class*='flyInOut']")	
	WebElement errorMessage ;
	
	
	public void goToUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	public String getErrorMessage() throws InterruptedException {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public ProductCatalogue loginApplication( String email , String pwd) {
		waitForElementToAppear(userEmailWait) ;
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		login.click();
		return new ProductCatalogue(driver) ;
	}

}
