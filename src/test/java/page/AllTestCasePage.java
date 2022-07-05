package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.UIElement;

public class AllTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/suites/view";

    //для перехода на TestCasePage
    private final By ProjectNameButton = By.linkText("Diploma");
    private final By TestCasesButton = By.id("navigation-suites");

    //CRUD

    // Блок описания селекторов для элементов
    private final By AddTestCaseLocator = By.xpath("//*[contains(@class, 'button button-left button-add') and contains(text(), 'Add Test Case')]");
    private final By TitleLocator = By.xpath("//*[contains(@class, 'form-control form-control-full form-fields ') and contains(@id, 'title')]");
    private final By AddTestCaseButton = By.xpath("//*[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Test Case')]");

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


}
