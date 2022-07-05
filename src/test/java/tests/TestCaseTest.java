package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test
    public void successLoginTest() throws InterruptedException {
        UserBuilder user = new UserBuilder.Builder()
                .withEmail(ReadProperties.username())
                .withPsw(ReadProperties.password())
                .build();

        Assert.assertTrue(loginStep.successLogin(user.getEmail(), user.getPsw()).isPageOpened());
    }

//    @Test
//    public void createTestCaseTest() throws InterruptedException{
//        UserBuilder user = new UserBuilder.Builder()
//                .
//    }
}
