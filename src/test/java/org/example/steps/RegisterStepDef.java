package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dataproviders.ConfigFileReader;
import org.example.pages.RegisterPage;
import org.example.scenariocontext.ScenarioContext;

import java.util.Map;

import static org.junit.Assert.assertTrue;


public class RegisterStepDef {

    //    public WebDriver driver = new ChromeDriver();
    //TODO to move to Hooks
    //private ScenarioContext scenarioContext = new ScenarioContext();

    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public RegisterStepDef() {
    }

    ;
//   public RegisterStepDef(ScenarioContext scenarioContext) {
//        this.scenarioContext = scenarioContext;
//    }

    //TODO to move to Hooks
//    WebDriverManager webDriverManager = WebDriverManager.getInstance();
//    WebDriver driver = webDriverManager.getDriver();



    //TODO to move to Hooks
    private static final Logger logger = LogManager.getLogger(RegisterStepDef.class);


    @Given("User is on the registration page")
    public void userIsOnTheRegistrationPage() {
        ConfigFileReader configFileReader = new ConfigFileReader();

//        driver.get(configFileReader.getApplicationUrl());
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickRegisterLink();
//        logger.info("Register page is displayed: " + driver.getCurrentUrl());
    }

    @When("User submits the registration form with the following details")
    public void userSubmitsTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            //scenarioContext.setContext(Context.REGISTRATION_KEY, entry.getValue());
        }
//TODO creez obiect din datele din MAP si salvez tot in scenario Context

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

        RegisterPage registerPage = new RegisterPage();
        RegisterPage.fillRegistrationForm(userData);
        registerPage.clickSubmitButton();
        logger.info("Register date are submitted");
    }

    @Then("User should see a success message")
    public void userShouldSeeASuccessMessage() {
        RegisterPage registerPage = new RegisterPage();
        ;
        assertTrue(registerPage.isSuccessMessageDisplayed());
        logger.info("Login message: " + registerPage.getSuccessMessage());
//        ScreenshotUtils.captureScreenshot(driver, "User Register Success");

    }
}


