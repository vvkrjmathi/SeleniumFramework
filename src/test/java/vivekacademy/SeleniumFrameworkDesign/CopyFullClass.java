package vivekacademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CopyFullClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userEmail"))));
		driver.findElement(By.id("userEmail")).sendKeys("vvkrj@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Kratos@0607");
		driver.findElement(By.id("login")).click();
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")))) ;
		

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream()
			    .filter(product -> product.findElement(By.tagName("b"))
			    .getText().equalsIgnoreCase("ZARA COAT 3"))
			    .findFirst()
			    .orElse(null);
		
		prod.findElement(By.xpath("//div/button[@class='btn w-10 rounded'][1]")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='toast-container']")))) ;
		
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart']"));
		
	
		
		boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.findElement(By.xpath(".//h3")).getText().equalsIgnoreCase("ZARA COAT 3")) ;
		
		
		

		
		Assert.assertTrue(match);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)"); 
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Checkout']"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		Actions a = new Actions(driver) ;
		
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform() ;
		js.executeScript("window.scrollBy(0, 1000)");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button.ta-item"))));
		
		List<WebElement> country = driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']")) ;
		
		System.out.println(country.size());
		
		 
		
		WebElement con = country.stream().filter(s -> s.getText().trim().equalsIgnoreCase("india")).findFirst().orElse(null);
		
		con.click();
		
		
		
		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		
		
		String ThankText = driver.findElement(By.xpath("//tr/td/h1")).getText();
		System.out.println(ThankText);
		Assert.assertTrue(ThankText.equalsIgnoreCase("Thankyou for the order.") ) ;
		
		
		
	}

}
