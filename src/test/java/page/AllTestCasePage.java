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
    private final By projectNameButton = By.linkText("diploma");
    private final By testCasesButton = By.id("navigation-suites");

    //CRUD
    // Блок описания селекторов для элементов
    //CREATE
    private final By addTestCaseLocator = By.id("sidebar-cases-add");
    private final By titleLocator = By.xpath("//input[@id ='title']");
    private final By addTestCaseButton = By.xpath("//*[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Test Case')]");
    private By IdLocator = By.cssSelector(".content-header-id");

    //UPDATE
    private final By idTestCaseButton = By.linkText("C138");
    private final By testCaseCheckBoxLocator =
            By.xpath("//tbody/child::tr[2]/child::td[2]/input");
    private final By testCaseUpdateButton = By.className("editLink");
    private final By saveTestCaseButton = By.id("accept");
    private final By editTestCaseButton =
            By.xpath("//*[contains(@class, 'toolbar-button toolbar-button-last')]");
    private final By preconditionsTestCaseLocator = By.id("custom_preconds_display");
    private final By stepsTestCaseLocator = By.id("custom_steps_display");
    private final By expectedResultLocator = By.id("custom_expected_display");

   //DELETE
   private final By testCaseEditButton =
           By.cssSelector(".button-text");
    private final By thisTestCaseDeleteButton =
            By.xpath("//*[contains(@class, 'button button-negative button-delete') and contains(text(), 'Delete this test case')]");
    private final By testCaseConfirmDeleteButton =
            By.xpath("//body/div[35]/div[2]/div[3]/div/a[1]");
    private final By successDeleteTextLocator =  By.cssSelector("[class = 'message message-success']");


    private final By successTextLocator =  By.cssSelector("[class = 'message message-success']");

    private final By errorTextLocator =
            By.xpath("//*[@class= 'message message-error']");

    //добавление файла
    private final By dropFilesLocator =
            By.xpath("//*[@class= 'attachment-list-empty-add']");
    private final By newAddButton =
            By.xpath("//body/input[2]");
    //By.xpath("//*[@class = 'modern']/input[2]");

    private  final By attachButton
            = By.id("attachmentNewSubmit");

    private final By dialogWindowTextLocator = By.xpath("//*[contains(@class, 'ui-dialog-title') and contains(text(), 'Confirmation')]");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public AllTestCasePage(WebDriver driver) {
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

//    //public Button getTestCaseUpdateButton(){
//        return new Button(driver, testCaseUpdateButton);
//    }

    public Button getSaveTestCaseButton(){
        return new Button(driver, saveTestCaseButton);
    }



    public Button getThisTestCaseDeleteButton() { return new Button(driver, thisTestCaseDeleteButton);}

    public Button getTestCaseEditButton() { return new Button(driver, testCaseEditButton);}

    public Button getTestCaseConfirmDeleteButton() { return new Button(driver, testCaseConfirmDeleteButton);}

    public UIElement getSuccessText() {
        return new UIElement(driver, successTextLocator);
    }

    public UIElement getErrorText() {
        return new UIElement(driver, errorTextLocator);
    }

    public UIElement   getIdTestCaseButton() { return new UIElement(driver, idTestCaseButton);}

    public Button getEditTestCaseButton() { return new Button(driver, editTestCaseButton);}

    public UIElement getPreconditionsTestCase() {
        return new UIElement(driver, preconditionsTestCaseLocator);}

    public UIElement getStepsTestCase() {
        return new UIElement(driver, stepsTestCaseLocator);}

    public UIElement getDropFiles() {
        return new UIElement(driver, dropFilesLocator);}

    public UIElement getNewAddButton() {
        return new UIElement(driver, newAddButton);}

    public UIElement getAttachButton() {
        return new UIElement(driver, attachButton);}

    public UIElement getDialogWindowTextLocator() {
        return new UIElement(driver, dialogWindowTextLocator);}

    public UIElement getIdLocator() {
        return new UIElement(driver, IdLocator);}

    public UIElement getExpectedResult() {
        return new UIElement(driver, expectedResultLocator);}

    public UIElement getSuccessDeleteTextLocator() {
        return new UIElement(driver, successDeleteTextLocator);}

}
