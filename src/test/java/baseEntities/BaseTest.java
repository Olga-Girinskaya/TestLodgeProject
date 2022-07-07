package baseEntities;

import configuration.ReadProperties;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.AllTestCasePage;
import page.TestCasePage;
import services.BrowsersService;
import steps.DashboardStep;
import steps.LoginStep;
import steps.TestCaseStep;

public class BaseTest {
    public static WebDriver driver;
    protected LoginStep loginStep;
    protected TestCaseStep testCaseStep;
    protected DashboardStep dashboardStep;


    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        testCaseStep = new TestCaseStep(driver);
        dashboardStep = new DashboardStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod

    public void tearDown() {
        Allure.getLifecycle().addAttachment(                        //Screenshot for all Test
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

        driver.quit();
    }
}
