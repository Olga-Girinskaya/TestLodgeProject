package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
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
    public TestCasePage updateTestCase(String preconditions, String steps) {
        allTestCasePage.getEditTestCaseButton().click();
        allTestCasePage.getPreconditionsTestCase().click();
        allTestCasePage.getPreconditionsTestCase().sendKeys(preconditions);
        allTestCasePage.getStepsTestCase().click();
        allTestCasePage.getStepsTestCase().sendKeys(steps);

        allTestCasePage.getSaveTestCaseButton().click();
        return testCasePage;
    }

    @Step("Delete Test Case")
    public void deleteTestCase() {
        //allTestCasePage.getTestCaseCheckBox().click();
        allTestCasePage.getTestCaseDeleteButton().click();
        allTestCasePage.getTestCaseDeletePermanentlyButton().click();
        allTestCasePage.getTestCaseConfirmDeleteButton().click();
    }

    @Step
    public Integer checkForDeletionStep() {
        return allTestCasePage.getIdTestCaseButton().findElements(By.linkText("C125")).size();
    }

    public Integer countCharNameTestCase() {

        return testCasePage.getNameLocator().getText().length();
    }

    @Step
    public void fileUploadStep() {
        allTestCasePage.getIdTestCaseButton().click();
        allTestCasePage.getEditTestCaseButton().click();
        allTestCasePage.getDropFiles().click();
        allTestCasePage.getNewAddButton().click();//ошибка
        allTestCasePage.getNewAddButton()
                .sendKeys("/java/lessons/TestLodgeProject/src/test/resources/Upload.txt");
        allTestCasePage.getAttachButton().click();
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
        allTestCasePage.getTestCaseDeleteButton().click();
        allTestCasePage.getDialogWindowTextLocator();
        return allTestCasePage;
    }

    public Integer countCharOneNameTestCase() {
        return testCasePage.getNameOneLocator().getText().length();
    }

    @Step("Получили ID test case")
    public String IDStep() {
        return allTestCasePage.getIdLocator().getText();
    }

}
