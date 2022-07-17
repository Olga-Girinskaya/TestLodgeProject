package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.UIElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    // Блок описания селекторов для элементов
    private final By headerTitleLabelLocator =
            By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    private final By projectAddButton =
            By.xpath("//*[contains(@class, 'sidebar-button') and contains(text(), 'Add Project')]");

    private final By projectNameLocator = By.id("name");

    private final By thisProjectAddButton = By.id("accept");

    private final By windowPopupButton = By.id("pendo-image-badge-32cf3f20");

    private final By windowTextLocator = By.id("pendo-text-ba494baf");

    // Блок иницализации
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public UIElement getHeaderTitleLabel() {
        return new UIElement(driver, headerTitleLabelLocator);
    }

    public Button getProjectAddButton() {
        return new Button(driver, projectAddButton);
    }

    public UIElement getProjectName() {
        return new UIElement(driver, projectNameLocator);
    }

    public Button getThisProjectAddButton() {
        return new Button(driver, thisProjectAddButton);
    }

    public Button getWindowPopupButton() {
        return new Button(driver, windowPopupButton);}

    public UIElement getWindowText() {
        return new UIElement(driver, windowTextLocator);
    }
}