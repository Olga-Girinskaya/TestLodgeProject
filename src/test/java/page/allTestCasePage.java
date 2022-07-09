package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.UIElement;

public class allTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/suites/view";

    //для перехода на TestCasePage
    private final By projectNameButton = By.linkText("diploma");
    private final By testCasesButton = By.id("navigation-suites");

    //CRUD
    // Блок описания селекторов для элементов
    //create
    private final By addTestCaseLocator = By.id("sidebar-cases-add");
    private final By titleLocator =
            By.xpath("//*[contains(@class, 'form-control form-control-full form-fields ') and contains(@id, 'title')]");
    private final By addTestCaseButton = By.xpath("//*[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Test Case')]");

    //update
    private final By testCaseCheckBoxLocator =
            By.xpath("//tbody/child::tr[2]/child::td[2]/input");
    private final By testCaseUpdateButton = By.className("editLink");
    private final By saveTestCaseButton = By.xpath("//*[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Save')]");

//    //delete
    private final By testCaseDeleteButton =
            By.cssSelector("[id = 'deleteCases']");
    private final By testCaseDeletePermanentlyButton =
            By.cssSelector("[class = 'button button-left button-positive button-no-margin-right dialog-action-secondary button-black']");
    private final By testCaseConfirmDeleteButton =
            By.cssSelector("[class = 'button button-left button-black dialog-action-default']");

    private final By successTextLocator =  By.cssSelector("[class = 'message message-success']");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public allTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addTestCaseLocator;
    }

    // Блок атомарных методов
    public UIElement getAddTestCase() {
        return new UIElement(driver, addTestCaseLocator);
    }

    public UIElement getTitle() {
        return new UIElement(driver, titleLocator);
    }

    public Button getAddTestCaseButton() {
        return new Button(driver, addTestCaseButton);
    }

    public Button getProjectNameButton() {
        return new Button(driver, projectNameButton);
    }

    public Button getTestCasesButton(){
        return new Button(driver, testCasesButton);
    }

    public CheckBox getTestCaseCheckBox(){
        return new CheckBox(driver, testCaseCheckBoxLocator);
    }

    public Button getTestCaseUpdateButton(){
        return new Button(driver, testCaseUpdateButton);
    }

    public Button getSaveTestCaseButton(){
        return new Button(driver, saveTestCaseButton);
    }

    public Button getTestCaseDeleteButton() { return new Button(driver, testCaseDeleteButton);}

    public Button getTestCaseDeletePermanentlyButton() { return new Button(driver, testCaseDeletePermanentlyButton);}

    public Button getTestCaseConfirmDeleteButton() { return new Button(driver, testCaseConfirmDeleteButton);}

    public UIElement getSuccessText() {
        return new UIElement(driver, successTextLocator);
    }



}
