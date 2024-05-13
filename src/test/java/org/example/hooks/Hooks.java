package org.example.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

//public class Hooks {
//    public static WebDriver driver;
//
//    @Before
//    public void launchBrowser() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
////    @Before
////    public void startBrowser() {
////        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver\\geckodriver.exe");
////        WebDriver driver = new FirefoxDriver();
////        driver.manage().window().maximize();
////        scenarioContext.setContext(Context.WEB_DRIVER, driver);
////    }
//
//
//
//
//    @After
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//    }
//}
//
//
////    @After
////    public void closeBrowser() {
////        driver = (WebDriver) scenarioContext.getContext(Context.WEB_DRIVER);
////        driver.close();
////    }
//
//
//
//
public class Hooks {
  //  private static final Logger logger = LogManager.getLogger(Hooks.class);

   // private static final Logger logger = LogManager.getLogger(RegisterStepDef.class);


//    @BeforeAll
//    public static void launchTests() {
//        ScenarioContext.getScenarioInstance().clearContext();
//        // private ScenarioContext scenarioContext = new ScenarioContext();
//        logger.info("Test/s started");
//    }

//    @Before("@API")
//    public static void setUpAPI(Scenario scenario) {
//        logger.info(System.lineSeparator() + "Starting API test: " + scenario.getName());
//        Authorization.authorization();
//    }

    @Before("@UI")
    public void launchBrowser(){
    //public static void launchBrowser(Scenario scenario) {
        //logger.info(System.lineSeparator() + "Starting UI test: " + scenario.getName());
       // WebDriverFactory.getWebDriver();
        System.out.println("I was in HOOKS @Before");
    }

//
//
//    @Before(order = 2, value = "@UI_Desktop")
//    public static void maximizeBrowser() {
//        WebDriverFactory.openNewBrowser();
//        WebDriverFactory.maximizeBrowserWindow();
//        logger.info("Browser maximized to desktop size");
//    }


//    @After("@UI")
//    public static void afterScenario() {
//        afterScenario(null);
//    }

    @AfterAll
    public static void afterScenario() {
    //public static void afterScenario(Scenario scenario) {
        System.out.println("I was in HOOKS @After");
//        WebDriverFactory.takeScreenshot(scenario);
//        WebDriverFactory.closeBrowserWindow();
//        logger.info("Scenario " + scenario.getName() + " finished");
    }

//    @AfterStep("@UI_Detailed")
//    public static void detailedTestEvidence(Scenario scenario) {
//        WebDriverFactory.takeScreenshot(scenario);
//        logger.info("Test evidence saved as screenshot");
//    }
//
//    @AfterAll(timeout = 5000)
//    public static void closeTests() {
//        WebDriverFactory.tearDown();
//        ScenarioContext.getScenarioInstance().clearContext();
//        logger.info("Test/s finished");
//    }
}
