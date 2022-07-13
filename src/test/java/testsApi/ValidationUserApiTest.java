package testsApi;

import com.github.javafaker.Faker;
import configuration.Endpoints;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import models.UserApi;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("Тестирование API user")
public class ValidationUserApiTest extends BaseApiTest {

    public UserApi user;
    Faker faker = new Faker();

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
        user = UserApi.builder()
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
