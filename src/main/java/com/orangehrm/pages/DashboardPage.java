package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;

    // Page Objects
    private final String dashboardXpath = "//h6[contains(., 'Dashboard')]";
    private final String menuDashboardXpath = "//a/span[contains(., 'Dashboard')]";

    // Expose By objects from xpaths
    private final By dashboardHeader = By.xpath(dashboardXpath);
    private final By menuDashboard = By.xpath(menuDashboardXpath);


    // Declare wait times
    private WebDriverWait driverWait;
    Duration WAIT_TIME = Duration.ofSeconds(10);

    //Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, WAIT_TIME);
        this.driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardHeader)
        );
    }

    public String getHeaderText() {
        WebElement header = driver.findElement(dashboardHeader);
        return header.getText();
    }
}

