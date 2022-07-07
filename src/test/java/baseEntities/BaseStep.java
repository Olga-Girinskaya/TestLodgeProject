package baseEntities;

import org.openqa.selenium.WebDriver;
import page.*;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AllTestCasePage allTestCasePage;
    protected TestCasePage testCasePage;
    protected ProjectsPage projectsPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        allTestCasePage=new AllTestCasePage(driver);
        testCasePage = new TestCasePage(driver);
        projectsPage = new ProjectsPage(driver);
    }
}
