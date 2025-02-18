package orangetest;

import com.orangehrm.config.BrowserConfig;
import com.orangehrm.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeFullNameSaveTest extends BaseTest{
    private MyInfoPage myInfoPage;
    private final String myInfoPageURL = BrowserConfig.getMyInfoUrl();


    @BeforeMethod(alwaysRun = true)
    public void navigateToDashboard() {
        // Directly navigate to the Dashboard URL (login is already handled)
        driver.get(myInfoPageURL);
        // Initialize the DashboardPage object
        this.myInfoPage = new MyInfoPage(driver);
    }
    @Test(description = "Check for Personal Details Text")
    public void testPersonalDetailsText(){
        String myInfoText = myInfoPage.getPersonalDetailsHeader();
        Assert.assertEquals(myInfoText, "Personal Details");
    }

    @Test(description = "Set and Save full name")
    public void setFullName(){
        myInfoPage.setNames("First", "Middle", "Last");
    }
}
