package baseEntities;

import org.openqa.selenium.WebDriver;
import page.AllTestCasePage;
import page.DashboardPage;
import page.LoginPage;
import page.TestCasePage;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AllTestCasePage allTestCasePage;
    protected TestCasePage testCasePage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        allTestCasePage=new AllTestCasePage(driver);
        testCasePage = new TestCasePage(driver);
    }
}
