package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import models.TestCaseBuilder;
import models.UserBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI тестирование test cases")
public class TestCaseTest extends BaseTest {

    UserBuilder user = UserBuilder.builder()
            .email(ReadProperties.username())
            .psw(ReadProperties.password())
            .build();

    @Feature("Создание test case")
    @Test
    public void createTestCaseTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title("Создание test case")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");
    }

    @Feature("Редактирование test case")
    @Test
    public void updateTestCaseTest() { //done
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .preconditions("preconditions")
                .steps("steps")
                .build();

        Assert.assertEquals(testCaseStep.updateTestCase
                        (testCase.getPreconditions(), testCase.getSteps()).getSuccessText().getText(),
                "Successfully updated the test case.");
    }

    @Feature("Удаление test case") //done
    @Test
    public void deleteTestCaseTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();
        testCaseStep.deleteTestCase();

        Assert.assertEquals(testCaseStep.checkForDeletionStep(),
                0, "'элемент отсутствует на странице");
    }

    @Feature("Обрезка названия test case при вводе > 251 символов")
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

    @Test
    public void fileUploadTest() {//не находит xpath: //body[@class = 'modern']/input[4]]
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();
        testCaseStep.fileUploadStep();
    }

//    @Test
//    public void createUpdateDeleteTest() {
//        loginStep.login(user.getEmail(), user.getPsw());
//        testCaseStep.pathToTestCases();
//
//        TestCaseBuilder testCase = TestCaseBuilder.builder()
//                .title("Создание test case")
//                .preconditions("preconditions")
//                .steps("steps")
//                .build();
//
//        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
//                "Successfully added the new test case. Add another");
//
//        Assert.assertEquals(testCaseStep.updateTestCase
//                        (testCase.getPreconditions(), testCase.getSteps()).getSuccessText().getText(),
//                "Successfully updated the test case.");
//
//        testCaseStep.deleteTestCase();
//    }

    @Feature("Тест на проверку всплывающего сообщения")//done
    @Test
    public void popupWindowTest() throws InterruptedException {

        loginStep.login(user.getEmail(), user.getPsw());
        //Thread.sleep(5000);

        Assert.assertEquals(testCaseStep.popupWindowStep().getWindowText().getText(), "Guides & Help");
    }
}
