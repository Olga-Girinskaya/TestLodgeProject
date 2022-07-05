package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.LombokBuilder;
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
        LombokBuilder lombok = LombokBuilder.builder()
                .title("Liza")
                .build();

        Assert.assertEquals(testCaseStep.createTestCase(lombok.getTitle()).getText());
    }
}
