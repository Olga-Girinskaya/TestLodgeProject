package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.AllTestCasePage;
import page.DashboardPage;
import page.TestCasePage;

public class TestCaseStep extends BaseStep {

    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("from DashboardPage to AllTestCasePage")
    public void pathToTestCases() {
        allTestCasePage.getProjectNameButton().click();
        allTestCasePage.getTestCasesButton().click();
    }

    @Step("Create Test Case")
    public AllTestCasePage createTestCase(String title) {
        allTestCasePage.getAddTestCase().click();
        allTestCasePage.getTitle().sendKeys(title);
        allTestCasePage.getAddTestCaseButton().click();

        return allTestCasePage;
    }

    @Step("Update Test Case")
    public TestCasePage updateTestCase(String expectedResult, String steps) {
        allTestCasePage.getEditTestCaseButton().click();

        allTestCasePage.getStepsTestCase().click();
        allTestCasePage.getStepsTestCase().sendKeys(steps);
        allTestCasePage.getExpectedResult().click();
        allTestCasePage.getExpectedResult().sendKeys(expectedResult);

        allTestCasePage.getSaveTestCaseButton().click();
        return testCasePage;
    }

    @Step("Delete Test Case")
    public void deleteTestCase() {
        allTestCasePage.getEditTestCaseButton().click();
        allTestCasePage.getThisTestCaseDeleteButton().click();
        allTestCasePage.getTestCaseConfirmDeleteButton().click();
    }

    @Step
    public AllTestCasePage checkForDeletionStep() {
        allTestCasePage.getSuccessDeleteTextLocator().getText();
        return allTestCasePage;
    }

    public Integer countCharNameTestCase() {

        return testCasePage.getNameLocator().getText().length();
    }

    @Step
    public DashboardPage popupWindowStep() {
        dashboardPage.getWindowPopupButton().click();
        dashboardPage.getWindowText();
        return dashboardPage;
    }

    @Step
    public AllTestCasePage dialogWindowStep() {
        allTestCasePage.getTestCaseCheckBox().click();
        allTestCasePage.getDeleteButton().click();
        allTestCasePage.getDialogWindowTextLocator();
        return allTestCasePage;
    }

    public Integer countCharOneNameTestCase() {
        return testCasePage.getNameOneLocator().getText().length();
    }

    @Step("???????????????? ID test case")
    public String IDStep() {
        return allTestCasePage.getIdLocator().getText();
    }

}
