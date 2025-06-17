package vivekacademy.SeleniumFrameworkDesign.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart']")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutButton;

	public boolean correctProduct(String productName) {
		return cartProducts.stream()
				.anyMatch(product -> product.findElement(By.xpath(".//h3")).getText().equalsIgnoreCase(productName));
	}

	public PlaceOrderPage checkout() {
	    
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", checkOutButton);

	   waitForElementToClickable(checkOutButton);
	    checkOutButton.click();

	   


	    return new PlaceOrderPage(driver);
	}

}
