package baseEntities;

import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.ProjectPage;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProjectPage projectPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        projectPage=new ProjectPage(driver);
    }
}
