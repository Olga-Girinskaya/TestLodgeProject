package helpers;

import configuration.Endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.mapper.ObjectMapperType;
import models.UserApiBuilder;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserHelper extends UserApiBuilder {

    public UserApiBuilder addUser(UserApiBuilder user, String expected) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .filter(new AllureRestAssured())
                .when()
                .log().body()
                .post(Endpoints.ADD_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("role", equalTo(expected))
                .extract().as(UserApiBuilder.class, ObjectMapperType.GSON);

    }

    public UserApiBuilder addUserError(UserApiBuilder user, String expected) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .filter(new AllureRestAssured())
                .when()
                .log().body()
                .post(Endpoints.ADD_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo(expected))
                .extract().as(UserApiBuilder.class, ObjectMapperType.GSON);

    }


    public UserApiBuilder updateUser(UserApiBuilder user, String expected) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .filter(new AllureRestAssured())
                .when()
                .post(Endpoints.UPDATE_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("role", equalTo(expected))
                .extract().as(UserApiBuilder.class, ObjectMapperType.GSON);
    }

    public UserApiBuilder getUser(UserApiBuilder userId, UserApiBuilder expected) {

        return given()
                .pathParams("user_id", userId.getId())
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("id", is(expected.getId()))
                .body("name", equalTo(expected.getName()))
                .body("email", equalTo(expected.getEmail()))
                .body("role", equalTo(expected.getRole()))
                .extract().as(UserApiBuilder.class, ObjectMapperType.GSON);
    }

    public UserApiBuilder getUserErrorInt(UserApiBuilder userId, String expected) {

        return given()
                .pathParams("user_id", userId.getId())
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo(expected))
                .extract().as(UserApiBuilder.class, ObjectMapperType.GSON);
    }

    public UserApiBuilder getUserErrorString(String userId, String expected) {

        return given()
                .pathParams("user_id", userId)
                .filter(new AllureRestAssured())
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo(expected))
                .extract().as(UserApiBuilder.class, ObjectMapperType.GSON);
    }
}