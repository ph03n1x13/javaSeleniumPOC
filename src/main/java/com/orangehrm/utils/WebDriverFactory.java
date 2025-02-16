package com.orangehrm.utils;

import com.orangehrm.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Factory class to create WebDriver instances.
 */
public class WebDriverFactory {

    public static WebDriver getDriver() {
        // Setup Chrome options based on the headless configuration.
        ChromeOptions options = new ChromeOptions();
        if (BrowserConfig.isHeadless()) {
            options.addArguments("--headless");
        }

        // Optionally, set the system property for the chromedriver executable if needed.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        return new ChromeDriver(options);
    }
}
