package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents the Dashboard page.
 */
public class DashboardPage {
    private WebDriver driver;

    // Example locator for a dashboard header element
    private By dashboardHeader = By.tagName("h1");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Retrieves the text of the dashboard header.
     *
     * @return The dashboard header text.
     */
    public String getHeaderText() {
        WebElement header = driver.findElement(dashboardHeader);
        return header.getText();
    }

    // Add additional dashboard-specific methods as needed
}

