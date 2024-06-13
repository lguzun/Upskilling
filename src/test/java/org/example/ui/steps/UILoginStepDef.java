package org.example.ui.steps;

import org.example.enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.ui.managers.WebDriverManager;
import org.example.ui.pages.LoginPage;
import org.example.scenariocontext.ScenarioContext;
import org.example.ui.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UILoginStepDef {

    private WebDriver driver;
    private LoginPage loginPage;
//
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(UILoginStepDef.class);

    public UILoginStepDef() {
        this.driver = WebDriverManager.getDriver();

    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {

        LOGGER.info("User is on Login page: ");
    }

    @When("User Navigates to LogIn Page")
    public void userNavigatesToLogInPage() {
        //WebDriver driver = (WebDriver) scenarioContext.getContext(org.example.enums.Context.WEB_DRIVER);
        LOGGER.info("User navigates to Login page: ");
       // LoginPage loginPage = new LoginPage(driver);

    }

    @And("user enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver);
        LoginPage.enterUsername(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
        scenarioContext.setContext(Context.USER_NAME, username);
        scenarioContext.setContext(Context.PASSWORD, password);
        //scenarioContext.setContext(Context.PRODUCT_TITLE, productsPage.getProductTitleByIndex(0));
        LOGGER.info("User logged with: " + username + password);
    }

    //TODO to change assert only in Then
    @Then("user should be logged in successfully")
    public void userLoggedInSuccessfully() {
       // WebDriver driver = (WebDriver) scenarioContext.getContext(Context.WEB_DRIVER);
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isSuccessMessageDisplayed());
       // assertTrue(loginPage.overviewPageIsDisplayed());
        LOGGER.info("Login message: " + loginPage.getSuccessMessage());
        Object username = scenarioContext.getContext(Context.USER_NAME);
        Object password = scenarioContext.getContext(Context.PASSWORD);
        assertEquals("user1", username);
        assertEquals("user1pass", password);
        ScreenshotUtils.captureScreenshot(driver, "User LogIn Success");




    }


}







