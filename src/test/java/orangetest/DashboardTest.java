package orangetest;

import com.orangehrm.config.BrowserConfig;
import com.orangehrm.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests related to the Dashboard page.
 */
public class DashboardTest extends BaseTest {
    private DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void navigateToDashboard() {
        // Directly navigate to the Dashboard URL (login is already handled)
        driver.get(BrowserConfig.getDashboardUrl());

        // Initialize the DashboardPage object
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void verifyDashboardHeader() {
        // Verify that the Dashboard header text is correct.
        String headerText = dashboardPage.getHeaderText();
        Assert.assertEquals(headerText, "Dashboard", "Dashboard header text mismatch!");
    }

    // Additional Dashboard test cases can be added here.
}

