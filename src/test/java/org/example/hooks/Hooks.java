package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.dataproviders.ConfigFileReader;
import org.example.managers.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class Hooks {
    private static ConfigFileReader configFileReader = new ConfigFileReader();;
    private final String homeUrl = configFileReader.getApplicationUrl() ;


    @Before
    public void setUp() {
        System.out.println("I was in hooks @before");
        WebDriver driver = WebDriverManager.getDriver();
        driver.navigate().to(homeUrl);
        System.out.println("I was in hooks @before");
    }

   @After
    public void tearDown() {
       WebDriverManager.closeDriver();
    }

}