package vivekacademy.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver ;
	
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	By thanktext = By.xpath("//tr/td/h1");
	
	public String confirmOrderplaced() {
		String thank = driver.findElement(thanktext).getText();
		return thank ;
		
	}
}
