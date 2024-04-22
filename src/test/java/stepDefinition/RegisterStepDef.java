package stepDefinition;

import configFileReader.ConfigFileReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;


public class RegisterStepDef {
    public WebDriver driver = new ChromeDriver();
    //    ConfigFileReader configFileReader;
    //ConfigFileReader configFileReader = new ConfigFileReader();
    //public WebDriver driver = new ChromeDriver();

    private static final Logger logger = LogManager.getLogger(RegisterStepDef.class);


    @Given("User is on the registration page")
    public void userIsOnTheRegistrationPage() {
       ConfigFileReader configFileReader= new ConfigFileReader();
       System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);


        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\lguzun\\JavaTools\\Drivers\\chromedriver.exe");

        //driver.get("https://parabank.parasoft.com");  // Navigate to login page
        driver.get(configFileReader.getApplicationUrl());
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();
        logger.info("Register page is displayed: " + driver.getCurrentUrl());
    }

    @When("User submits the registration form with the following details")
    public void userSubmitsTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap(String.class, String.class);
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterPage.fillRegistrationForm(userData);
        registerPage.clickSubmitButton();
        logger.info("Register date are submited");
    }


    @Then("User should see a success message")
    public void userShouldSeeASuccessMessage() {
        // Assuming you have a page object instantiated as 'registrationPage'
        RegisterPage registerPage = new RegisterPage(driver);;
        assertTrue(registerPage.isSuccessMessageDisplayed());
        logger.info("Login message: "+registerPage.getSuccessMessage());

    }
}


