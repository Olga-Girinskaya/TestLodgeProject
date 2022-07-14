package testsApi;

import com.github.javafaker.Faker;
import configuration.Endpoints;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import models.UserApiBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Epic("Тестирование API user")
public class UserApiTest_v2 extends BaseApiTest {

    public UserApiBuilder user;
    private JsonPath newUser;
    Faker faker = new Faker();

    @Test(testName = "Запрос POST на создание пользователя")
    @Feature("Создание пользователя")
    @Step("Пользователь с ролью Lead создан")
    public void successAddUserTest() {

        user = UserApiBuilder.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .roleId(1)
                .build();

        newUser = given()
                .body(user, ObjectMapperType.GSON)
                .filter(new AllureRestAssured())
                .when()
                .post(Endpoints.ADD_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("role", equalTo("Lead"))
                .extract().jsonPath();

    }

    @Test(testName = "Запрос POST на редактирование роли пользователя", dependsOnMethods = "successAddUserTest")
    @Feature("Редактирование роли пользователя")
    @Step("Роль пользователя изменена на Tester")
    public void successUpdateUserTest() {

        user = UserApiBuilder.builder()
                .id(newUser.getInt("id"))
                .roleId(3)
                .build();

        given()
                .body(user, ObjectMapperType.GSON)
                .filter(new AllureRestAssured())
                .when()
                .post(Endpoints.UPDATE_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("role", equalTo("Tester"))
                .extract().jsonPath();
    }

    @Test(testName = "Отправка запроса GET на зачитку данных пользователя", dependsOnMethods = "successUpdateUserTest")
    @Feature("Получение данных пользователя")
    @Step("Пользователь успешно зачитан")
    public void successGetUserTest() {

        given()
                .pathParams("user_id", newUser.getInt("id"))
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("id", is(newUser.getInt("id")))
                .body("name", equalTo(newUser.getString("name")))
                .body("role", equalTo("Tester"))
                .extract();
    }

    @Test(testName = "Получение ошибки на зачитку пользователя с несуществующим ID")
    @Feature("Валидация на зачитку пользователя с несуществующим ID")
    @Step("Получена ошибка при зачитке пользователя с несуществующим ID")
    public void failGetUserWithoutIdTest2() {

        given()
                .pathParams("user_id", 0)
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo("Field :user is not a valid user."))
                .extract();
    }

    @Test(testName = "Получение ошибки на зачитку пользователя без ID")
    @Feature("Валидация на зачитку пользователя без указания ID")
    @Step("Получена ошибка при зачитке пользователя без ID")
    public void failGetUserWithoutIdTest() {

        given()
                .pathParams("user_id", "")
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo("Field :user is a required field."))
                .extract();
    }

    @Test(testName = "Получение ошибки на зачитку пользователя с некорректным ID")
    @Feature("Валидация на зачитку пользователя с некорректным ID")
    @Step("Получена ошибка при зачитке пользователя с некорректным ID")
    public void failGetUserWithIIncorrectIdTest() {

        given()
                .pathParams("user_id", "incorrect")
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo("Field :user is not a valid ID."))
                .extract();
    }

    @Test(testName = "Получение ошибки на создание пользователя с именем, превышающим допустимый размер поля")
    @Feature("Валидация на создание пользователя с именем > 250 символов")
    @Step("Подучена ошибка на создание пользователя с именем > 250 символов")
    public void failAddUserNameToLongTest() {
        String generatedString = RandomStringUtils.randomAlphabetic(251);
        user = UserApiBuilder.builder()
                .name(generatedString)
                .email(faker.internet().emailAddress())
                .build();

        given()
                .body(user)
                .filter(new AllureRestAssured())
                .when()
                .post(Endpoints.ADD_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo("Field :name is too long (250 characters at most)."))
                .extract();
    }
}
