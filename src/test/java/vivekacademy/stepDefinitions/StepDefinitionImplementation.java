package vivekacademy.stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vivekacademy.SeleniumFrameworkDesign.TestComponents.BaseTest;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.CartPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.LandingPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.PlaceOrderPage;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class StepDefinitionImplementation extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public CartPage cartPage;
    public ConfirmationPage confirmationPage;

    @Given("^Login with username (.+) and password (.+)$")
    public void logged_in_username_password(String uname, String pwd) throws IOException {
        landingPage = launchApplication();  // make sure you launch or initialize landingPage here
        productCatalogue = landingPage.loginApplication(uname, pwd);
    }

    @When("^I add product (.+) to the cart$")
    public void add_product_to_the_cart(String productName) throws InterruptedException {
        WebElement product = productCatalogue.getByName(productName);
        productCatalogue.addToCart(product);
    }

    @And("^checkout (.+) and submit$")
    public void checkout_submitOrder(String product) throws InterruptedException {
        cartPage = productCatalogue.goToCartPage();
        boolean match = cartPage.correctProduct(product);
        Assert.assertTrue(match);
        PlaceOrderPage placeOrder = cartPage.checkout();

        placeOrder.enterCountry("india");
        placeOrder.selectCountry();
        confirmationPage = placeOrder.placeOrder();
    }

    @Then("^\"(.+)\" message is displayed$")
    public void message_displayed(String msg) throws InterruptedException {
        String thank = confirmationPage.confirmOrderplaced();
        Assert.assertTrue(thank.equalsIgnoreCase(msg));
        tearDown();
    }
}
