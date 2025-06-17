package vivekacademy.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class PlaceOrderPage extends AbstractComponent{
	WebDriver driver ;
	
	
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	By countryEnter = By.xpath("//input[@placeholder='Select Country']");
	By listvisible = By.cssSelector("button.ta-item");
	By placeOrderButton = By.xpath("//a[@class='btnn action__submit ng-star-inserted']");
	
	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted']")
	List<WebElement> countryList ;
	
	public void enterCountry(String country) {
		Actions a = new Actions(driver) ;
		a.sendKeys(driver.findElement(countryEnter),country).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0, 1000)");
		
	}
	
	public void selectCountry() {
		WebElement con =  countryList.stream().filter(s -> s.getText().trim().equalsIgnoreCase("india")).findFirst().orElse(null);
		con.click();
	}
	public ConfirmationPage placeOrder() {
		driver.findElement(placeOrderButton).click();
		return new ConfirmationPage(driver);
		
	}
	
}
