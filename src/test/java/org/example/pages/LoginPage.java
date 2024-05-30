package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;


    // Constructor OK!!!!
    public LoginPage(WebDriver driver) {
       // this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Web Elements using @FindBy annotation
    @FindBy(xpath = "//input[@name='username']")
    private static WebElement usernameInput;


    @FindBy(xpath = "//input[@name='password']")
    private static WebElement passwordInput;

    @FindBy(className=("login"))
    private static WebElement loginButton;

//     globalDriver.findElement(By.className("login")).click();
//        globalDriver.findElement(By.className("login")).submit();

    // Actions performed on the page
    public static void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public static void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

//    public static void fillRegistrationForm(io.cucumber.datatable.DataTable dataTable) {
//        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
//        for (Map<String, String> row : rows) {
//            String field = row.get("Field");
//            String value = row.get("Value");
//            WebElement fieldElement = driver.findElement(By.id(field)); // Assuming IDs are used for form fields
//            fieldElement.sendKeys(value);
//        }
//    }


    public static void clickLoginButton() {
        loginButton.click();
        loginButton.submit();
    }

    //Find Success Login message element
    @FindBy(xpath = "//h1[text()='Accounts Overview']")
    private WebElement successMessage;

    // Method to check if success message is displayed
    public boolean isSuccessMessageDisplayed() {
        // Assuming the success message is identified by its ID or any other unique locator
        //return driver.findElement(By.xpath("contains(text(),'Welcome')")).isDisplayed();
        // return driver.findElement(By.xpath("//h1[@class='title' and contains(text(),'Welcome')]")).isDisplayed();
        return successMessage.isDisplayed();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}



