package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.UIElement;

public class TestCasePage extends BasePage {

    private final static String pagePath = "/index.php?/cases/view";

    private final By successTextLocator =
            By.cssSelector(".message.message-success");
    //By.xpath("//*[contains(@class, 'message message-success')]");



    private final By TestCaseCheckBoxLocator =
            By.xpath("//*[contains(@class, 'selectionCheckbox') and contains(@name, 'selected-4')]");

    // private final By nameTestCaseLocator = By.cssSelector(".content-header-title");
    private final By editButton = By.cssSelector(".button-text");
    private final By stepDisplay = By.id("custom_steps_display");
    private final By saveButton = By.id("accept");
    private final By nameLocator = By.cssSelector(".link-tooltip.content-header-title-tooltip");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public UIElement getSuccessText() {
        return new UIElement(driver, successTextLocator);}

    public CheckBox getTestCaseCheckBox() {
        return new CheckBox(driver, TestCaseCheckBoxLocator);
    }

    public UIElement getStepDisplay() {
        return new UIElement(driver, stepDisplay);
    }

    public Button getEditButton() {
        return new Button(driver, editButton);
    }

    public Button getSaveButton() {
        return new Button(driver, saveButton);
    }

    public UIElement getNameLocator() {
        return new UIElement(driver, nameLocator);
    }
}
