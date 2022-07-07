package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        UserBuilder user = UserBuilder.builder()
                .email(ReadProperties.username())
                .psw(ReadProperties.password())
                .build();

        Assert.assertTrue(loginStep.successLogin(user.getEmail(), user.getPsw()).isPageOpened());
    }

    @Test
    public void incorrectEmailLoginTest() {
        UserBuilder user = UserBuilder.builder()
                .email("testUser")
                .psw(ReadProperties.password())
                .build();

        Assert.assertEquals(
                loginStep.incorrectLogin(user.getEmail(), user.getPsw())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void incorrectPswLoginTest() {
        UserBuilder user = UserBuilder.builder()
                .email(ReadProperties.username())
                .psw("123456")
                .build();

        Assert.assertEquals(
                loginStep.incorrectLogin(user.getEmail(), user.getPsw()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

}
