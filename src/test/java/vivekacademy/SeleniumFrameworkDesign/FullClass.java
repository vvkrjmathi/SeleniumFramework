package vivekacademy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.sound.sampled.TargetDataLine;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vivekacademy.SeleniumFrameworkDesign.TestComponents.BaseTest;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.CartPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.LandingPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.OrderPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.PlaceOrderPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class FullClass extends BaseTest {

	

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("pwd"));

		WebElement productToAdd = productCatalogue.getByName(input.get("productName"));
		productCatalogue.addToCart(productToAdd);
		CartPage cartPage = productCatalogue.goToCartPage();

		boolean match = cartPage.correctProduct(input.get("productName"));
		Assert.assertTrue(match);
		PlaceOrderPage placeorder = cartPage.checkout();

		placeorder.enterCountry(country);
		placeorder.selectCountry();
		ConfirmationPage confirmationPage = placeorder.placeOrder();

		String thank = confirmationPage.confirmOrderplaced();
		Assert.assertTrue(thank.equalsIgnoreCase(thankText));
		System.out.println("Executed succefully");

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "getData")
	public void verifyOrders(HashMap<String, String> input) throws InterruptedException {
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("pwd"));
		OrderPage orderPage = productCatalogue.clickOrders();
		Assert.assertTrue(orderPage.verifyOrderDisplayed(input.get("productName")));

	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//vivekacademy//data//PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

};
