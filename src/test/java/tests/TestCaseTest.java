package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.TestCaseBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

//    @Test
//    public void successLoginTest() {
//        UserBuilder user = new UserBuilder.Builder()
//                .withEmail(ReadProperties.username())
//                .withPsw(ReadProperties.password())
//                .build();
//
//        Assert.assertTrue(loginStep.successLogin(user.getEmail(), user.getPsw()).isPageOpened());
//    }
//            Assert.assertEquals(
//                    loginStep.incorrectLogin(user.getEmail(), user.getPsw()).getErrorTextElement().getText(),
//                "Email/Login or Password is incorrect. Please try again.",
//                        "Неверное сообщение об ошибке");

    @Test
    public void createTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCaseBuilder = TestCaseBuilder.builder()
                .title("diploma")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(testCaseBuilder.getTitle()).getSuccessText().getText(),
                "Successfully added the new test case. Add another");
    }

    @Test
    public void updateTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCaseBuilder = TestCaseBuilder.builder()
                .titleUpdate("упрврвнаер")
                .build();

        Assert.assertTrue(testCaseStep.updateTestCase(testCaseBuilder.getTitleUpdate()).isPageOpened());
    }

    @Test
    public void deleteTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();


        //Assert.assertEquals(testCaseStep.deleteTestCase().get);
    }
}
