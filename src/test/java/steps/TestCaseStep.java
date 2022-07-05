package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.TestCasePage;

public class TestCaseStep extends BaseStep {
    String Title = "diploma";

    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create Test Case")
    public TestCasePage createTestCase() throws InterruptedException {
        allTestCasePage.getAddTestCase().click();
        allTestCasePage.getAddTestCase().sendKeys(Title);
        allTestCasePage.getAddTestCaseButton().click();
        return testCasePage;
    }
}
