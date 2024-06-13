package org.example.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.ui.managers.ConfigFileReader;
import org.example.ui.managers.WebDriverManager;
import org.example.ui.pages.RegisterPage;
import org.example.scenariocontext.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.example.ui.utils.ScreenshotUtils;
import java.util.Map;

import static org.junit.Assert.assertTrue;


public class UIRegisterStepDef {

    private WebDriver driver;
    private RegisterPage registerPage;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(UILoginStepDef.class);


    public UIRegisterStepDef() {
        this.driver = WebDriverManager.getDriver();
    }
    ;
//   public RegisterStepDef(ScenarioContext scenarioContext) {
//        this.scenarioContext = scenarioContext;
//    }


    @Given("User is on the registration page")
    public void userIsOnTheRegistrationPage() {
        ConfigFileReader configFileReader = new ConfigFileReader();

//        driver.get(configFileReader.getApplicationUrl());
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();
//        logger.info("Register page is displayed: " + driver.getCurrentUrl());
    }

    @When("User submits the registration form with the following details")
    public void userSubmitsTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : userData.entrySet()) {
        }

//        @When("User submits the registration form with the following details")
//        public void userSubmitsTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
//            Map<String, String> userData = dataTable.asMap(String.class, String.class);
//            for (Map.Entry<String, String> entry : userData.entrySet()) {
//                scenarioContext.setContext(Context.REGISTRATION_KEY, entry.getValue());
//            }


//        @When("User submits the registration form with the following details")
//        public void user_submits_the_registration_form_with_the_following_details(DataTable dataTable) {
//            Map<String, Object> formData = dataTable.asMap(String.class, Object.class);
//            scenarioContext.setScenarioContext(formData);
//        }
//

        RegisterPage registerPage = new RegisterPage(driver);
        RegisterPage.fillRegistrationForm(userData);
        registerPage.clickSubmitButton();
        LOGGER.info("Register date are submitted");
    }

    @Then("User should see a success message")
    public void userShouldSeeASuccessMessage() {
        RegisterPage registerPage = new RegisterPage(driver);
        ;
        assertTrue(registerPage.isSuccessMessageDisplayed());
        LOGGER.info("Login message: " + registerPage.getSuccessMessage());
        ScreenshotUtils.captureScreenshot(driver, "User Register Success");

    }
}


