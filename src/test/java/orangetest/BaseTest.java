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

    // Credentials can be loaded from config; hardcoded here for simplicity.
    private String username = "testuser";
    private String password = "testpass";

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
            driver.get(BrowserConfig.getLoginUrl());

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
        if (driver != null) {
            driver.quit();
            driver = null;
            isLoggedIn = false;
        }
    }
}

