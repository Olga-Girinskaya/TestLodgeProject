package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.ProjectsPage;

public class DashboardStep extends BaseStep {

    public DashboardStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create Project")
    public ProjectsPage createProjectStep(String project){
        dashboardPage.getProjectAddButton().click();
        dashboardPage.getProjectName().sendKeys(project);
        dashboardPage.getThisProjectAddButton().click();
        return projectsPage;
    }


}
