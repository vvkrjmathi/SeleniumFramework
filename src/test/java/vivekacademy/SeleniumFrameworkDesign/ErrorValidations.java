package vivekacademy.SeleniumFrameworkDesign;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import vivekacademy.SeleniumFrameworkDesign.TestComponents.BaseTest;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.CartPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.LandingPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.PlaceOrderPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"ErrorHandling"},retryAnalyzer = vivekacademy.SeleniumFrameworkDesign.TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";

		String country = "india";

		String thankText = "Thankyou for the order.";

		landingPage.loginApplication("vvkrj@gail.com", "Kratos@0607");

		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
@Test
	public void productErrorValidations() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";

		String country = "india";

		String thankText = "Thankyou for the order.";

		ProductCatalogue productCatalogue = landingPage.loginApplication("vvkrj@gmail.com", "Kratos@0607");

	//	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		productCatalogue.getProducts() ;
		WebElement productToAdd = productCatalogue.getByName(productName);
		productCatalogue.addToCart(productToAdd);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		 
		boolean match = cartPage.correctProduct(productName);
		Assert.assertTrue(match);
	}

}
