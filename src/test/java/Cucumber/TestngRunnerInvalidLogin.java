package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/Cucumber/ErrorValidation.feature",
	    glue = "vivekacademy.stepDefinitions",
	    monochrome = true,
	    plugin = {"html:target/cucumbererror.html"}
)
public class TestngRunnerInvalidLogin extends AbstractTestNGCucumberTests {
}
