package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.AllTestCasePage;
import page.TestCasePage;
import services.BrowsersService;
import steps.LoginStep;

public class BaseTest {
    public WebDriver driver;
    protected LoginStep loginStep;
    protected AllTestCasePage allTestCasePage;
    protected TestCasePage testCasePage;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        allTestCasePage = new AllTestCasePage(driver);
        testCasePage=new TestCasePage(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
