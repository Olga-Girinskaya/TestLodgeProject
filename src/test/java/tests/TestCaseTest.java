package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import models.TestCaseBuilder;
import models.UserBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI тестирование test cases")
public class TestCaseTest extends BaseTest {

    protected String ID;

    UserBuilder user = UserBuilder.builder()
            .email(ReadProperties.username())
            .psw(ReadProperties.password())
            .build();

    @Feature("Создание test case")//+
    @Test(testName = "Tест на создание сущности")
    public void createTestCaseTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title("Создание test case")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");
    }

//    @Feature("Редактирование test case")//+
//    @Test(testName = "Tест на редактирование сущности")
//    public void updateTestCaseTest() {
//        loginStep.login(user.getEmail(), user.getPsw());
//        testCaseStep.pathToTestCases();
//
//        TestCaseBuilder testCase = TestCaseBuilder.builder()
//                .preconditions("preconditions")
//                .steps("steps")
//                .build();
//
//        Assert.assertEquals(testCaseStep.updateTestCase
//                        (testCase.getPreconditions(), testCase.getSteps()).getSuccessText().getText(),
//                "Successfully updated the test case.");
//    }

    @Feature("Удаление test case") //+
    @Test(testName = "Tест на удаление сущности")
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

//    @Feature("Загрузка Upload.txt в test case")//-
//    @Test(testName = "тест на загрузку файла")
//    public void fileUploadTest() {//не находит xpath: //body[@class = 'modern']/input[4]]
//        loginStep.login(user.getEmail(), user.getPsw());
//        testCaseStep.pathToTestCases();
//        testCaseStep.fileUploadStep();
    //}

    @Feature("Отображение всплывающего сообщения Guides & Help")//+
    @Test(testName = "тест на проверку всплывающего сообщения")
    public void popupWindowTest() {
        loginStep.login(user.getEmail(), user.getPsw());

        Assert.assertEquals(testCaseStep.popupWindowStep().getWindowText().getText(), "Guides & Help");
    }

    @Feature("Отображение Confirmation при удалении test case")//+
    @Test(testName = "тест отображения диалогового окна")
    public void dialogWindowTest() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        Assert.assertEquals(testCaseStep.dialogWindowStep().getDialogWindowTextLocator().getText(), "Confirmation");
    }

    @Feature(" test case при вводе 1 символа")//+
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

    @Feature(" test case при вводе 250 символов")//+
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

    @Feature(" test case при вводе 250 символов")//+
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


    @Test
    public void createTestCaseTest1() {
        loginStep.login(user.getEmail(), user.getPsw());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .title("Создание test case")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCase.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");

        ID = testCaseStep.IDStep();

       // System.out.println(ID);
    }

    @Feature("Редактирование test case")
    @Test(dependsOnMethods = "createTestCaseTest1", testName = "Tест на редактирование сущности")
    public void updateTestCaseTest() {
        // System.out.println(ID);
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        driver.get("https://aqa666.testrail.io/index.php?/cases/view/"+ ID.substring(1));
        //  System.out.println("https://aqa666.testrail.io/index.php?/cases/view/"+ ID.substring(1));

        TestCaseBuilder testCase = TestCaseBuilder.builder()
                .preconditions("preconditions")
                .steps("steps")
                .build();

        Assert.assertEquals(testCaseStep.updateTestCase
                        (testCase.getPreconditions(), testCase.getSteps()).getSuccessText().getText(),
                "Successfully updated the test case.");
    }
}
