package helpers;

import com.google.gson.Gson;
import configuration.Endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.mapper.ObjectMapperType;
import models.UserApi;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserHelper {

    public void addUser(UserApi user) {

        given()
                .body(user)
                .filter(new AllureRestAssured())
                .when()
                .post(Endpoints.ADD_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath();
    }
}