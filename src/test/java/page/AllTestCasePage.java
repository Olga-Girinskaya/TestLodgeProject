package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.CheckBox;
import wrappers.UIElement;

public class AllTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/suites/view";

    //для перехода на TestCasePage
    private final By ProjectNameButton = By.linkText("Diploma");
    private final By TestCasesButton = By.id("navigation-suites");

    //CRUD

    // Блок описания селекторов для элементов
    //create
    private final By AddTestCaseLocator = By.id("sidebar-cases-add");
    private final By TitleLocator =
            By.xpath("//*[contains(@class, 'form-control form-control-full form-fields ') and contains(@id, 'title')]");
    private final By AddTestCaseButton = By.xpath("//*[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Test Case')]");

    //update
    private final By TestCaseCheckBoxLocator =
            By.xpath("//*[contains(@class, 'selectionCheckbox') and contains(@name, 'selected-94')]");
    private final By TestCaseUpdateButton = By.className("editLink");
    private final By SaveTestCaseButton = By.xpath("//*[contains(@class, 'button button-left button-positive button-ok') and contains(@id, 'accept')]");

//    //delete
    private final By TestCaseDeleteButton =
            By.cssSelector("[id = 'deleteCases']");
    private final By TestCaseDeletePermanentlyButton =
            By.cssSelector("[class = 'button button-left button-positive button-no-margin-right dialog-action-secondary button-black']");
    private final By TestCaseConfirmDeleteButton =
            By.cssSelector("[class = 'button button-left button-black dialog-action-default']");



    private final By successTextLocator =  By.cssSelector("[class = 'message message-success']");
    private final By successUpdateTextLocator =
            By.cssSelector("[class = 'message message-success']");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public AllTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return AddTestCaseLocator;
    }

    // Блок атомарных методов
    public UIElement getAddTestCase() {
        return new UIElement(driver, AddTestCaseLocator);
    }

    public UIElement getTitle() {
        return new UIElement(driver, TitleLocator);
    }

    public Button getAddTestCaseButton() {
        return new Button(driver, AddTestCaseButton);
    }

    public Button getProjectNameButton() {
        return new Button(driver, ProjectNameButton);
    }

    public Button getTestCasesButton(){
        return new Button(driver,TestCasesButton);
    }

    public CheckBox getTestCaseCheckBox(){
        return new CheckBox(driver, TestCaseCheckBoxLocator);
    }

    public Button getTestCaseUpdateButton(){
        return new Button(driver, TestCaseUpdateButton);
    }

    public Button getSaveTestCaseButton(){
        return new Button(driver, SaveTestCaseButton);
    }

    public Button getTestCaseDeleteButton() { return new Button(driver, TestCaseDeleteButton);}

    public Button getTestCaseDeletePermanentlyButton() { return new Button(driver, TestCaseDeletePermanentlyButton);}

    public Button getTestCaseConfirmDeleteButton() { return new Button(driver, TestCaseConfirmDeleteButton);}



    public UIElement getSuccessText() {
        return new UIElement(driver, successTextLocator);
    }

    public UIElement getSuccessUpdateText() {
        return new UIElement(driver, successUpdateTextLocator);
    }

}
