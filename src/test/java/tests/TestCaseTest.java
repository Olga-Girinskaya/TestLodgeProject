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

    @Test
    public void createTestCaseTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        testCaseStep.pathToTestCases();

        TestCaseBuilder testCaseBuilder = TestCaseBuilder.builder()
                .title("Liza")
                .build();

        Assert.assertTrue(testCaseStep.createTestCase(testCaseBuilder.getTitle()).isPageOpened());
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
}
