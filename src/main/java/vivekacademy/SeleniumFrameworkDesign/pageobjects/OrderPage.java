package vivekacademy.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver ;
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	By checkOutButton = By.xpath("//button[text()='Checkout']");
	@FindBy(xpath = "//div[@class='cart']")
	List<WebElement> cartProducts;
	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> productsOrdered ; 
	
	
	public boolean verifyOrderDisplayed(String productName) {
		
		return productsOrdered.stream().anyMatch(productOrder -> productOrder.getText().equalsIgnoreCase(productName)) ;
		
	}
		
	
}
