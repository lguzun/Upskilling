package org.example.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue= {"org/example/api/steps", "org/example/ui/steps", "org/example/hooks"},
        tags = "@API")
        //plugin = { "pretty", "html:target/cucumber-reports"  },)
public class TestRunner {



}