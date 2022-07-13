package testsApi;

import com.github.javafaker.Faker;
import configuration.Endpoints;
import helpers.UserHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Lead;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import models.UserApi;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Epic("Тестирование API user")
public class UserApiTest2 extends BaseApiTest {

    UserHelper newUser = new UserHelper();

    public UserApi userBody;
    //private JsonPath newUser;
    Faker faker = new Faker();

    @Test(testName = "Запрос POST на создание пользователя")
    @Feature("Создание пользователя")
    @Step("Пользователь с ролью Lead создан")
    public void successAddUserTest() {

        userBody = UserApi.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .roleId(1)
                .build();

        newUser.addUser(userBody);
//        newUser = given()
//                .body(user, ObjectMapperType.GSON)
//                .filter(new AllureRestAssured())
//                .when()
//                .post(Endpoints.ADD_USER)
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .log().body()
//                .body("role", equalTo("Lead"))
//                .extract().jsonPath();
        System.out.println(userBody.toString());

       // System.out.println(newUser.toString());
    }

//    @Test(testName = "Запрос POST на редактирование роли пользователя", dependsOnMethods = "successAddUserTest")
//    @Feature("Редактирование роли пользователя")
//    @Step("Роль пользователя изменена на Tester")
//    public void successUpdateUserTest() {
//
//        user = UserApi.builder()
//                .id(newUser.getInt("id"))
//                .roleId(3)
//                .build();
//
//        given()
//                .body(user, ObjectMapperType.GSON)
//                .filter(new AllureRestAssured())
//                .when()
//                .post(Endpoints.UPDATE_USER)
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .log().body()
//                .body("role", equalTo("Tester"))
//                .extract().jsonPath();
//    }
//
//    @Test(testName = "Отправка запроса GET на зачитку данных пользователя", dependsOnMethods = "successUpdateUserTest")
//    @Feature("Получение данных пользователя")
//    @Step("Пользователь успешно зачитан")
//    public void successGetUserTest() {
//
//        given()
//                .pathParams("user_id", newUser.getInt("id"))
//                .filter(new AllureRestAssured())
//                .when()
//                .get(Endpoints.GET_USER)
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .log().body()
//                .body("id", is(newUser.getInt("id")))
//                .body("name", equalTo(newUser.getString("name")))
//                .body("role", equalTo("Tester"))
//                .extract();
//    }
}
