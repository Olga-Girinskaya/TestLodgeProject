package testsApi;

import com.github.javafaker.Faker;
import helpers.UserHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import models.UserApiBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Тестирование API user")
public class UserApiTest_v2 extends BaseApiTest {

    private UserApiBuilder user, userId;
    Faker faker = new Faker();
    UserHelper userHelper = new UserHelper();

    @Test(testName = "Запрос POST на создание пользователя")
    @Feature("Создание пользователя")
    @Step("Пользователь с ролью Lead создан")
    public void addUserTest() {

        user = UserApiBuilder.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .roleId(1)
                .build();
        String expected = "Lead";

        userId = userHelper.addUser(user, expected);
    }

    @Test(testName = "Запрос POST на редактирование роли пользователя", dependsOnMethods = "addUserTest")
    @Feature("Редактирование роли пользователя")
    @Step("Роль пользователя изменена на Tester")
    @Parameters
    public void successUpdateUserTest() {

        user = UserApiBuilder.builder()
                .id(userId.getId())
                .roleId(3)
                .build();
        String expected = "Tester";

        userHelper.updateUser(user, expected);
    }

    @Test(testName = "Отправка запроса GET на зачитку данных пользователя", dependsOnMethods = "successUpdateUserTest")
    @Feature("Получение данных пользователя")
    @Step("Пользователь успешно зачитан")
    public void successGetUserTest() {

        UserApiBuilder expected = UserApiBuilder.builder()
                .role("Tester")
                .name(userId.getName())
                .email(userId.getEmail())
                .id(userId.getId())
                .build();

        userHelper.getUser(userId, expected);
    }

    @Test(testName = "Отправка запроса GET на зачитку данных пользователя по email", dependsOnMethods = "successGetUserTest")
    @Feature("Получение данных пользователя по email")
    @Step("Пользователь успешно зачитан по email")
    public void successGetUserByEmailTest() {

        UserApiBuilder expected = UserApiBuilder.builder()
                .role("Tester")
                .name(userId.getName())
                .email(userId.getEmail())
                .id(userId.getId())
                .build();

        userHelper.getUserByEmail(userId, expected);
    }

    @Test(testName = "Получение ошибки на зачитку пользователя с несуществующим ID")
    @Feature("Валидация на зачитку пользователя с несуществующим ID")
    @Step("Получена ошибка при зачитке пользователя с несуществующим ID")
    public void failGetUserWithIdNotFoundTest() {

        user = UserApiBuilder.builder()
                .id(0)
                .build();

        String expected = "Field :user is not a valid user.";
        userHelper.getUserErrorInt(user, expected);
    }

    @Test(testName = "Получение ошибки на зачитку пользователя без ID")
    @Feature("Валидация на зачитку пользователя без указания ID")
    @Step("Получена ошибка при зачитке пользователя без ID")
    public void failGetUserWithoutIdTest() {
        String user = "";
        String expected = "Field :user is a required field.";

        userHelper.getUserErrorString(user, expected);
    }

    @Test(testName = "Получение ошибки на зачитку пользователя с некорректным ID")
    @Feature("Валидация на зачитку пользователя с некорректным ID")
    @Step("Получена ошибка при зачитке пользователя с некорректным ID")
    public void failGetUserWithIIncorrectIdTest() {
        String user = "incorrect";
        String expected = "Field :user is not a valid ID.";

        userHelper.getUserErrorString(user, expected);
    }

    @Test(testName = "Получение ошибки на создание пользователя с именем, превышающим допустимый размер поля")
    @Feature("Валидация на создание пользователя с именем > 250 символов")
    @Step("Получена ошибка на создание пользователя с именем > 250 символов")
    public void failAddUserNameToLongTest() {
        String generatedString = RandomStringUtils.randomAlphabetic(251);
        user = UserApiBuilder.builder()
                .name(generatedString)
                .email(faker.internet().emailAddress())
                .build();

        String expected = "Field :name is too long (250 characters at most).";
        userHelper.addUserError(user, expected);
    }

}