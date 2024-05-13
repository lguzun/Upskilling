package org.example.steps;

import org.example.utils.ScreenshotUtils;
import org.example.scenariocontext.ScenarioContext;
import org.example.dataproviders.ConfigFileReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.example.pages.RegisterPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;


public class RegisterStepDef {

 //    public WebDriver driver = new ChromeDriver();
    //TODO to move to Hooks
   private ScenarioContext scenarioContext = new ScenarioContext();
   public RegisterStepDef(){};
//   public RegisterStepDef(ScenarioContext scenarioContext) {
//        this.scenarioContext = scenarioContext;
//    }

    //TODO to move to Hooks
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver driver = webDriverManager.getDriver();

   //TODO to move to Hooks
   private static final Logger logger = LogManager.getLogger(RegisterStepDef.class);


    @Given("User is on the registration page")
    public void userIsOnTheRegistrationPage() {
        ConfigFileReader configFileReader= new ConfigFileReader();

        driver.get(configFileReader.getApplicationUrl());
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();
        logger.info("Register page is displayed: " + driver.getCurrentUrl());
    }

    @When("User submits the registration form with the following details")
    public void userSubmitsTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            scenarioContext.setContext(entry.getKey(), entry.getValue());
        }
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterPage.fillRegistrationForm(userData);
        registerPage.clickSubmitButton();
        logger.info("Register date are submitted");
    }

    @Then("User should see a success message")
    public void userShouldSeeASuccessMessage() {
        RegisterPage registerPage = new RegisterPage(driver);;
        assertTrue(registerPage.isSuccessMessageDisplayed());
        logger.info("Login message: "+registerPage.getSuccessMessage());
        ScreenshotUtils.captureScreenshot(driver, "User Register Success");

    }
}


