package org.example.steps;

import org.example.scenariocontext.ScenarioContext;
import org.example.dataproviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginStepDef {

    private ScenarioContext scenarioContext = new ScenarioContext();
   // public LoginStepDef(){}

    //TODO to move webdriver to ScenarioContext
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver driver = webDriverManager.getDriver();

    //ConfigFileReader configFileReader;
    private static final Logger logger = LogManager.getLogger(LoginStepDef.class);

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        ConfigFileReader configFileReader= new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver.get(configFileReader.getApplicationUrl());
        //TODO move to Hooks
        logger.info("User is on Login page: " + driver.getCurrentUrl());
    }

    @When("User Navigates to LogIn Page")
    public void userNavigatesToLogInPage() {
        // Instantiate the LoginPage object
      //TODO de scos din steps in clasa direct
        //TODO de ster System.SET.Propertu chrome.exe
        LoginPage loginPage = new LoginPage(driver);
    }

    @And("user enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        LoginPage.enterUsername(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
        scenarioContext.setContext("username", username);
        scenarioContext.setContext("password", password);
        logger.info("User logged with: " + username + password);
    }
//TODO to change assert only in Then
    @Then("user should be logged in successfully")
    public void userLoggedInSuccessfully() {
        // Assuming you have a page object instantiated as 'registrationPage'
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isSuccessMessageDisplayed());
        logger.info("Login message: "+loginPage.getSuccessMessage());
        String username = scenarioContext.getContext("username");
        String password = scenarioContext.getContext("password");
        assertEquals("user10", username);
        assertEquals("user1pass", password);


//        String actualUrl = driver.getCurrentUrl();
//        assertTrue("User is redirected to the page", actualUrl.contains("overview"));
    }
}







