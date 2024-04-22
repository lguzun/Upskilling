package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue= "stepDefinition",
        tags = "@UI",
        dryRun = false,
        monochrome = false
)
public class TestRunner {

}