package vivekacademy.stepDefinitions;


import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vivekacademy.SeleniumFrameworkDesign.TestComponents.BaseTest;
import vivekacademy.SeleniumFrameworkDesign.pageobjects.LandingPage;

public class StepDefinitionInvalidLogin extends BaseTest {

    public LandingPage landingPage;

    @Given("I landed on Ecommerce page")
    public void i_landed_on_ecommerce_page() throws IOException {
        landingPage = launchApplication();
    }

    @When("Login with username (.+) and password (.+)")
    public void login_with_username_and_password(String username, String password) {
        landingPage.loginApplication(username, password);
    }

    @Then("\"(.+)\" message is displayed")
    public void error_message_is_displayed(String expectedMsg) throws InterruptedException {
        String actualErrorMsg = landingPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsg.trim(), expectedMsg.trim());
        tearDown();
    }
}

