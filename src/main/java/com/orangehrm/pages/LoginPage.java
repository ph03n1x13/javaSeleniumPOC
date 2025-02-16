package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


/**
 * Represents the Login page and encapsulates the login functionality.
 */
public class LoginPage {
    private WebDriver driver;
    private String buttonXpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']";
    private String userNameField ="(//input[@class='oxd-input oxd-input--active'])[1]";
    private String passWordField ="(//input[@class='oxd-input oxd-input--active'])[2]";

    // Locators for the login form elements (adjust based on actual HTML)
    private By usernameField = By.xpath(userNameField);
    private By passwordField = By.xpath(passWordField);
    private By loginButton = By.xpath(buttonXpath);

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Logs in using the provided username and password.
     *
     * @param username The username.
     * @param password The password.
     */
    public void login(String username, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        // Optionally: add wait or validation here to ensure the login was successful
    }
}
