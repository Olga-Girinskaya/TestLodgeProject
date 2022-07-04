package baseEntities;

import org.openqa.selenium.WebDriver;
import page.DashboardPage;
import page.LoginPage;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
    }
}
