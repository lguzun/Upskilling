package org.example.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue= {"org/example/steps", "hooks"},
        tags = "@UI")
public class TestRunner {

}