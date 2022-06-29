package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    private final static String pagePath = "a/32798";

    private By headerTitleLabelLocator = By.id("page_heading_cont");

    public ProjectPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }


}
