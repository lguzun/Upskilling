package org.example.ui.managers;

import org.example.scenariocontext.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverManager {
    private static WebDriver driver;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    ;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();


    public String getCurURL() {
        return driver.getCurrentUrl();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        String browserType = configFileReader.getProperty("browser");
        switch (browserType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox browser is initiated");
                break;
            case "MICROSOFTEDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge browser is initiated");
                break;
            default:
                throw new RuntimeException("The web driver type " + browserType + " is not defined");
        }

        if (configFileReader.getBrowserWindowSize()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }
//

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
