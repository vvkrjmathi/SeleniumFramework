package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import vivekacademy.SeleniumFrameworkDesign.pageobjects.CartPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.OrderPage;

public class AbstractComponent {
    WebDriver driver ;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	public AbstractComponent(WebDriver driver) {
	this.driver = driver ;
	 
	}
	
By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");
By productAdded = By.xpath("//div[@aria-label='Product Added To Cart']");
By orderButton = By.xpath("//button[@routerlink='/dashboard/myorders']");

	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(findBy)));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		wait.until(ExpectedConditions.visibilityOf( findBy));
		
	}
	
	public void waitForElementDisappear(By findby) {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findby)));
	}
	
	public void waitForElementToClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public CartPage goToCartPage() throws InterruptedException {
		//waitForElementDisappear(productAdded);s
		Thread.sleep(3000);
		driver.findElement(cartButton).click();
		return new CartPage(driver);
		
	}

	
	public OrderPage clickOrders() {
		driver.findElement(orderButton).click();
		return new OrderPage(driver);
		
	}

		
		
	
	
}

