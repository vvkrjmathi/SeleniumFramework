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

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver ;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ProductCatalogue (WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	By loginSuccessfully = By.xpath("//div[@aria-label='Login Successfully']");
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.xpath("//div[@id='toast-container']");
	By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");
	By productAdded = By.xpath("//div[@aria-label = 'Product Added To Cart']");
	
	@FindBy(css = ".mb-3")
	List<WebElement> products ;
	
	
	
	public List<WebElement> getProducts() throws InterruptedException{

		//waitForElementDisappear(loginSuccessfully);
		Thread.sleep(2000);
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getByName(String productName) throws InterruptedException {
		return getProducts().stream()
	    .filter(product -> product.findElement(By.tagName("b"))
	    .getText().equalsIgnoreCase(productName))
	    .findFirst()
	    .orElse(null);
	}
	
	public void addToCart(WebElement prod) throws InterruptedException {
	
		prod.findElement(addToCart).click();
		waitForElementDisappear(toastMessage);
		goToCartPage();
	}
	
	
}
