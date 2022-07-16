package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import models.TestCaseBuilder;
import models.UserBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseRegressionTest extends BaseTest {

    private UserBuilder user = UserBuilder.builder()

            .email(ReadProperties.username())
            .psw(ReadProperties.password())
            .build();

    @Feature("Обрезка названия test case до 250 символов при вводе 251 символа")
    @Test(testName = "Ввод названия test case > 250 символов")
    @Step("Название test case обрезано до 250 символов")
    public void failAddTestCaseNameToLongTestTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        String generatedString = RandomStringUtils.randomAlphabetic(251);
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title(generatedString)
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");

        Assert.assertEquals(testCaseStep.countCharNameTestCase(), 250, "Case Title > 250 char");
    }

    @Feature("Валидация на создание test case c пустым названием")
    @Test(testName = "Ввод пустого названия test case")
    @Step("Ошибка на создание пользователя с пустым названием")
    public void failAddTestCaseNameEmptyTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title("")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getErrorText().getText(),
                "Field Title is a required field.");
    }

    @Feature("Отображение всплывающего сообщения Guides & Help")
    @Test(testName = "тест на проверку всплывающего сообщения")
    public void popupWindowTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        Assert.assertEquals(testCaseStep.popupWindowStep().getWindowText().getText(), "Guides & Help");
    }

    @Feature("Отображение Confirmation при удалении test case")
    @Test(testName = "тест отображения диалогового окна")
    public void dialogWindowTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        Assert.assertEquals(testCaseStep.dialogWindowStep().getDialogWindowTextLocator().getText(), "Confirmation");
    }

    @Feature(" test case при вводе 1 символа")
    @Test(testName = "тест на граничные значения test case с 1 символом")
    @Step(" test case с 1 символом")
    public void oneAddTestCaseNameSymbolTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        String generatedString = RandomStringUtils.randomAlphabetic(1);
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title(generatedString)
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");

        Assert.assertEquals(testCaseStep.countCharOneNameTestCase(), 1, "Case Title not 1 char");
    }

    @Feature(" test case при вводе 250 символов")
    @Test(testName = "тест на граничные значения test case с 250 символами")
    @Step("test case с 250 символами")
    public void maxAddTestCaseNameSymbolTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        String generatedString = RandomStringUtils.randomAlphabetic(250);
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title(generatedString)
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");

        Assert.assertEquals(testCaseStep.countCharNameTestCase(), 250, "Case Title not 250 char");
    }

    @Feature(" test case при вводе 250 символов")
    @Test(testName = "тест на граничные значения test case с 250 символами")
    @Step("test case с 250 символами")
    public void maxMinusOneAddTestCaseNameSymbolTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        String generatedString = RandomStringUtils.randomAlphabetic(249);
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title(generatedString)
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");

        Assert.assertEquals(testCaseStep.countCharNameTestCase(), 249, "Case Title not 249 char");
    }
}
