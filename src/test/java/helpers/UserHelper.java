package helpers;

import configuration.Endpoints;
import models.UserApi;
import org.apache.hc.core5.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserHelper {

    private int userId;

    public UserApi addUser(Map<String, Object> jsonAsMap) {
        return given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(UserApi.class);
    }

    public void getUser() {
        given()
                .when()
                .pathParams("user_id", userId)
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .statusCode(org.apache.http.HttpStatus.SC_OK);
    }


}