package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.CheckBox;
import wrappers.UIElement;

public class TestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/cases/view/7";

    private final By successTextLocator =
            By.xpath("//div[contains(@id, 'content-inner')]/child::*");

    private final By TestCaseCheckBoxLocator =
            By.xpath("//*[contains(@class, 'selectionCheckbox') and contains(@name, 'selected-4')]");



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
        return new UIElement(driver, successTextLocator);
    }

    public CheckBox getTestCaseCheckBox(){
        return new CheckBox(driver, TestCaseCheckBoxLocator);
    }
}
