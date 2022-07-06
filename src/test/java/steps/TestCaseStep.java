package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.AllTestCasePage;
import page.TestCasePage;

public class TestCaseStep extends BaseStep {

    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("from DashboardPage to AllTestCasePage")
    public AllTestCasePage pathToTestCases(){
        allTestCasePage.getProjectNameButton().click();
        allTestCasePage.getTestCasesButton().click();
        return allTestCasePage;
    }


    @Step("Create Test Case")
    public TestCasePage createTestCase(String title)  {
        allTestCasePage.getAddTestCase().click();
        allTestCasePage.getTitle().sendKeys(title);
        allTestCasePage.getAddTestCaseButton().click();
        return testCasePage;
    }

    @Step("Update Test Case")
    public TestCasePage updateTestCase(String titleUpdate){
        allTestCasePage.getTestCaseCheckBox().click();
        allTestCasePage.getTestCaseUpdateButton().click();
        allTestCasePage.getTitle().click();
        allTestCasePage.getTitle().clear();
        allTestCasePage.getTitle().sendKeys(titleUpdate);
        allTestCasePage.getSaveTestCaseButton().click();
        return testCasePage;
    }
}
