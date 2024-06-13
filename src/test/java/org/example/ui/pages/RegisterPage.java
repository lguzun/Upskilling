package org.example.ui.pages;

import org.example.ui.managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class RegisterPage {
    static WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = WebDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }


//    private static WebDriver driver;
//
//    public RegisterPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//       // configFileReader= new ConfigFileReader();
//    }


    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLink;
    public void clickRegisterLink() {
        registerLink.click();
    }


    public static void fillRegistrationForm(Map<String, String> userData) {
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
        }
        //Submit the form
       // driver.findElement(By.name("Register")).click();
       // driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
    }

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement submitButton;
    public void clickSubmitButton() {
        submitButton.click();
    }

    //Find Success message element
    @FindBy(xpath = "//p[text()='Your account was created successfully. You are now logged in.']")
    private WebElement successMessage;

    // Method to check if success message is displayed
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
    public String getSuccessMessage() {
        return successMessage.getText();
    }
}



