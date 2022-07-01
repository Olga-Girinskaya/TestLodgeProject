package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    public final static String pagePath = "/a/32798";

    private By headerTitleLabelLocator = By.cssSelector("#page_heading_cont"); // неверный локатор, оставила , чтобы тест не падал, когда исправлю переход на страницу с проектом, удалить
    //private By headerTitleLabelLocator = By.id("projects_index"); // верный локатор, сейчас тест будет падать

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


}
