package orangetest;

import com.orangehrm.config.BrowserConfig;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * BaseTest provides common setup and teardown logic.
 * It ensures that the login is performed only once per suite.
 */
public class BaseTest {
    protected static WebDriver driver;
    protected static boolean isLoggedIn = false;
    protected static BrowserConfig browserConfig = new BrowserConfig();

    private String username = browserConfig.getUser();
    private String password = browserConfig.getPasswd();

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
        }
    }

    @BeforeClass(alwaysRun = true)
    public void login() {
        if (!isLoggedIn) {
            // Navigate to the login page using the URL from configuration.
            driver.get(browserConfig.getLoginUrl());

            // Instantiate the LoginPage and perform login.
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);

            // Mark that the login has been performed.
            isLoggedIn = true;
            // Optionally: wait for or verify that login was successful (e.g., check URL or dashboard element)
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        // Need to implement logout for preventing orphan login sessions
        if (driver != null) {
            driver.quit();
            driver = null;
            isLoggedIn = false;
        }
    }
}

