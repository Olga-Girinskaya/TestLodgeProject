package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.UIElement;

public class TestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/cases/view/7";

    private final By successTextLocator =
            By.xpath("//div[contains(@id, 'content-inner')]/child::*");

    private final By TestCaseCheckBoxLocator =
            By.xpath("//*[contains(@class, 'selectionCheckbox') and contains(@name, 'selected-4')]");

    private final By idTestcase = By.cssSelector(".content-header-id");
    private final By errorTextLocator =
            By.xpath("//*[@class= 'message message-error']");
    private final By nameTestCaseLocator = By.cssSelector(".content-header-title");
    private final By editButton = By.cssSelector(".content-header-id");
    private final By stepDisplay = By.id("custom_steps_display");
    private final By saveButton = By.id("accept");
    private final By titleLocator = By.xpath("//input[@id ='title']");


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
    public UIElement getNameTestCaseLocator(){
        return  new UIElement(driver, nameTestCaseLocator);
    }

    public UIElement getStepDisplay(){
        return  new UIElement(driver, stepDisplay);
    }

    public UIElement getIdTestcase(){
        return  new UIElement(driver, idTestcase);
    }

    public Button getEditButton(){
        return  new Button(driver, editButton);
    }

    public Button getSaveButton(){
        return  new Button(driver, saveButton);
    }

    public UIElement getTitleLocator(){
        return  new UIElement(driver, titleLocator);
    }
    public UIElement getErrorText() {
        return new UIElement(driver, errorTextLocator);
    }
}
