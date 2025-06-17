package Cucumber ;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Cucumber/PurchaseOrder.feature",
    glue = "vivekacademy.stepDefinitions",
    monochrome = true,
    plugin = {"html:target/cucumber.html"}
)
public class TestngTestRunner extends AbstractTestNGCucumberTests {
}
