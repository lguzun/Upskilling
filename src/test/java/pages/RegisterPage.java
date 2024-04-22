package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;




public class RegisterPage {

    private static WebDriver driver;
   //ConfigFileReader configFileReader;

    //public WebDriver driver = WebDriver.getInstance();

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       // configFileReader= new ConfigFileReader();
    }


    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLink;
    public void clickRegisterLink() {
        registerLink.click();
    }


    //@And("User submits the registration form with the following details")
//    public void fillRegistrationForm(List<Map<String, String>> userDetails) {
//        for (Map<String, String> user : userDetails) {
//            // Fill the registration form with the provided details
//            driver.findElement(By.id("firstName")).sendKeys(user.get("firstName"));
//            driver.findElement(By.id("lastName")).sendKeys(user.get("lastName"));
//            driver.findElement(By.id("address")).sendKeys(user.get("address"));
//            driver.findElement(By.id("city")).sendKeys(user.get("city"));
//            driver.findElement(By.id("state")).sendKeys(user.get("state"));
//            driver.findElement(By.id("zipcode")).sendKeys(user.get("zipcode"));
//            driver.findElement(By.id("phone")).sendKeys(user.get("phone"));
//            driver.findElement(By.id("SSN")).sendKeys(user.get("SSN"));
//            driver.findElement(By.id("username")).sendKeys(user.get("username"));
//            driver.findElement(By.id("password")).sendKeys(user.get("password"));
//            driver.findElement(By.id("confirm")).sendKeys(user.get("confirm"));
//
//            // Submit the form
//            driver.findElement(By.id("submit")).click();
//        }
//    }



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
        // Assuming the success message is identified by its ID or any other unique locator
        //return driver.findElement(By.xpath("contains(text(),'Welcome')")).isDisplayed();
        // return driver.findElement(By.xpath("//h1[@class='title' and contains(text(),'Welcome')]")).isDisplayed();
        return successMessage.isDisplayed();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }



}



