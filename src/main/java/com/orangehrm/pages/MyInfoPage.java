package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    Duration WAIT_TIME = Duration.ofSeconds(10);

    // Page objects
    private final String myInfomenuXpath = "//a/span[contains(., 'My Info')]";
    private final String personalDetailsHeaderXpath = "//h6[contains(., 'Personal Details')]";
    private final String firstNameXpath ="//input[@class='oxd-input oxd-input--active orangehrm-firstname']";
    private final String middleNameXpath ="//input[@class='oxd-input oxd-input--active orangehrm-middlename']";
    private final String lastNameXpath ="//input[@class='oxd-input oxd-input--active orangehrm-lastname']";
    private final String successToastXpath = "//div[@class='oxd-toast-container oxd-toast-container--bottom']";
    private final String firstSaveButtonXpath = "(//button[contains(., 'Save')])[1]";

    private By myInfoText = By.xpath(myInfomenuXpath);
    private By personalDetailsHeader = By.xpath(personalDetailsHeaderXpath);
    private By firstName = By.xpath(firstNameXpath);
    private By middleName = By.xpath(middleNameXpath);
    private By lastName = By.xpath(lastNameXpath);
    private By successToast = By.xpath(successToastXpath);
    private By firstSaveButton = By.xpath(firstSaveButtonXpath);

    //Constructor
       public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, WAIT_TIME);
        this.driverWait.until(
                   ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader)
           );
    }

    public String getPersonalDetailsHeader(){
           String personalDetailsHeaderText = driver.findElement(personalDetailsHeader).getText();
           return personalDetailsHeaderText;
    }

    public void setNames(String fName, String mName, String lName){
           driver.findElement(firstName).clear();
           driver.findElement(firstName).sendKeys(fName);

           driver.findElement(middleName).clear();
           driver.findElement(middleName).sendKeys(mName);

           driver.findElement(lastName).clear();
           driver.findElement(lastName).sendKeys(lName);

           driver.findElement(firstSaveButton).click();
        driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(successToast)
        );
    }
}