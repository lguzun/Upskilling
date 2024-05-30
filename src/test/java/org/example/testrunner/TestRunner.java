package org.example.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue= {"org/example/steps", "org/example/hooks"},
        //glue= {"org/example/steps"},
        tags = "@UI1")
public class TestRunner {



}