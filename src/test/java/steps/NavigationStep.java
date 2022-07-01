package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import page.ProjectPage;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectPage navigateToProjectsPage() {
        projectPage.openPageByUrl();
        return projectPage;
    }
}
