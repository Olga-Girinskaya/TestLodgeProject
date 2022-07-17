package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.TestCaseBuilder;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Тестирвоание UI test case")
public class TestCaseSmokeTest extends BaseTest {

    protected String ID;

    private UserBuilder user = UserBuilder.builder()

            .email(ReadProperties.username())
            .psw(ReadProperties.password())
            .build();

    @Feature("Create test case")
    @Test(testName = "Tест на создание сущности")
    public void createTestCaseTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title("Создание test case")
                .steps("Отправить API запрос  {base_url}/index.php?/api/v2/add_user")
                .expectedResult("Response code = 200\n" +
                        "Пользователь создан")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");

        ID = testCaseStep.IDStep();

    }

    @Feature("Update test case")
    @Test(dependsOnMethods = "createTestCaseTest", testName = "Tест на редактирование сущности")
    public void updateTestCaseTest() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        driver.get("https://aqa666.testrail.io/index.php?/cases/view/"+ ID.substring(1));

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .steps("Отправить API запрос  {base_url}/index.php?/api/v2/add_user")
                .expectedResult("Response code = 200\n" +
                        "Пользователь создан")
                .build();

        Assert.assertEquals(testCaseStep.updateTestCase
                        (testCase.getExpectedResult(), testCase.getSteps()).getSuccessText().getText(),
                "Successfully updated the test case.");
    }

    @Feature("Delete test case")
    @Test(dependsOnMethods = "updateTestCaseTest", testName = "Tест на удаление сущности")
    public void deleteTestCaseTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        driver.get("https://aqa666.testrail.io/index.php?/cases/view/"+ ID.substring(1));
        testCaseStep.deleteTestCase();

        Assert.assertEquals(testCaseStep.checkForDeletionStep().getSuccessDeleteTextLocator().getText(), "Successfully flagged the test case as deleted.");
    }
}
