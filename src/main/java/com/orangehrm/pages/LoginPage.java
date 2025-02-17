package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Page Objects
    private String loginHeadingXpath = "//h5[contains(., 'Login')]";
    private String buttonXpath = "//button";
    private String userNameFieldXpath ="(//input)[2]";
    private String passWordFieldXpath ="(//input)[3]";
    private String dashboardXpath = "//h6[contains(., 'Dashboard')]";

    // Create locators objects from string objects to be used by the driver object
    private By usernameField = By.xpath(userNameFieldXpath);
    private By passwordField = By.xpath(passWordFieldXpath);
    private By loginButton = By.xpath(buttonXpath);
    private By loginHeader = By.xpath(loginHeadingXpath);
    private By dashBoardHeader = By.xpath(dashboardXpath);

// Declare waits
    private WebDriverWait driverWait;
    Duration WAIT_TIME = Duration.ofSeconds(10);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, WAIT_TIME);
    }


    public void login(String username, String password) {
        driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(loginHeader)
        );
        // Enter username
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);

        // Enter password
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        // Click the login button
        driver.findElement(loginButton).click();
        // Add wait or validation here to ensure the login was successful
        driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(dashBoardHeader)
        );
    }
}