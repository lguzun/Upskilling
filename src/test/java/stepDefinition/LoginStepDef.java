package stepDefinition;

import configFileReader.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;


public class LoginStepDef {
    public WebDriver driver = new ChromeDriver();
    ConfigFileReader configFileReader;
    private static final Logger logger = LogManager.getLogger(LoginStepDef.class);

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        // driver = ChromeConfig.getInstance();
        ConfigFileReader configFileReader= new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\lguzun\\JavaTools\\Drivers\\chromedriver.exe");
        //driver.get("https://parabank.parasoft.com");  // Navigate to login page
        driver.get(configFileReader.getApplicationUrl());
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\lguzun\\JavaTools\\Drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        // Navigate to login page
       // driver.get("https://parabank.parasoft.com");
        logger.info("User is on Login page: " + driver.getCurrentUrl());
    }

    @When("User Navigates to LogIn Page")
    public void userNavigatesToLogInPage() {
        //DriverConfig.DriverStart();
        // Instantiate the LoginPage object
        LoginPage loginPage = new LoginPage(driver);
    }

    @And("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        LoginPage.enterUsername(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
    }

    @Then("Then User should be logged in successfully")
    public void userLoggedInSuccessfully() {
        // Assuming you have a page object instantiated as 'registrationPage'
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isSuccessMessageDisplayed());
        logger.info("Login message: "+loginPage.getSuccessMessage());



//        String actualUrl = driver.getCurrentUrl();
//        assertTrue("User is redirected to the page", actualUrl.contains("overview"));
    }
}







