//package cucumberTest;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class ChromeConfig {
//    private static WebDriver instance;
//
//    // Private constructor to prevent instantiation from outside
//    private ChromeConfig() {
//    }
//
//    // Static method to get the singleton instance of WebDriver
//    public static synchronized WebDriver getInstance() {
//        if (instance == null) {
//            ChromeOptions options = new ChromeOptions();
//            // Add any desired options here
//
//            // Set path to chromedriver executable
//           System.setProperty("webdriver.chrome.driver", "C:\\Users\\lguzun\\JavaTools\\Drivers\\chromedriver.exe");
//
//            // Create WebDriver instance
//            instance = new ChromeDriver(options);
//        }
//        return instance;
//    }
//
//    // Method to close and quit WebDriver instance
//    public static void closeWebDriver() {
//        if (instance != null) {
//            instance.quit();
//            instance = null;
//        }
//    }
//}
