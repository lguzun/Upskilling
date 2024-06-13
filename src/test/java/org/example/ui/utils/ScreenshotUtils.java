package org.example.ui.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        String targetDirectory = "target/screenshots"; // Path relative to the project root
        try {
            // Capture screenshot as byte array
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Define the file name with timestamp
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = now.format(formatter);
            String fileName = screenshotName + "_" + timestamp + ".png";

            // Write screenshot to file in the target directory
            File screenshotFile = new File(targetDirectory + File.separator + fileName);
            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
