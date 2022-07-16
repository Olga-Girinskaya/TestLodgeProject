package baseEntities;

import configuration.ReadProperties;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.AllTestCasePage;
import services.BrowsersService;
import steps.LoginStep;
import steps.TestCaseStep;


public class BaseTest {
    public static WebDriver driver;
    protected LoginStep loginStep;
    protected TestCaseStep testCaseStep;
    protected DashboardStep dashboardStep;
    protected AllTestCasePage allTestCasePage;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        testCaseStep = new TestCaseStep(driver);
        dashboardStep = new DashboardStep(driver);
        allTestCasePage = new AllTestCasePage(driver);

        driver.get(ReadProperties.getUrl());

    }

    @AfterMethod
    public void tearDown(ITestResult tr) {
        if (!tr.isSuccess()) {
            Allure.getLifecycle().addAttachment(
                    "screenshot", "image/png", "png"
                    , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
        driver.quit();
    }
}
