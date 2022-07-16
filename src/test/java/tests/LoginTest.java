package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Тестирование логина")
public class LoginTest extends BaseTest {
    private UserBuilder user;

    @Feature("Успешный логин")
    @Test
    public void successLoginTest() {
        user = UserBuilder.builder()
                .email(ReadProperties.username())
                .psw(ReadProperties.password())
                .build();

        Assert.assertTrue(loginStep.successLogin(user.getEmail(), user.getPsw()).isPageOpened());
    }

    @Feature("Валидация на логин с некорректным username")
    @Test
    public void incorrectEmailLoginTest() {
        user = UserBuilder.builder()
                .email("testUser")
                .psw(ReadProperties.password())
                .build();

        Assert.assertEquals(
                loginStep.incorrectLogin(user.getEmail(), user.getPsw())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Feature("Валидация на логин с некорректным паролем")
    @Test
    public void incorrectPswLoginTest() {
        user = UserBuilder.builder()
                .email(ReadProperties.username())
                .psw("123456")
                .build();

        Assert.assertEquals(
                loginStep.incorrectLogin(user.getEmail(), user.getPsw()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
