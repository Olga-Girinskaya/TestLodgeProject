package testsApi;

import com.github.javafaker.Faker;
import configuration.Endpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import models.UserApi;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserApiTest extends BaseApiTest {

    public UserApi user;
    private JsonPath newUser;

    Faker faker = new Faker();

    @Test
    public void successAddUserTest() {

        user = UserApi.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .roleId(1)
                .build();

        newUser = given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("role", equalTo("Lead"))
                .extract().jsonPath();
    }

    @Test(dependsOnMethods = "successAddUserTest")
    public void successUpdateUserTest() {

        user = UserApi.builder()
                .id(newUser.getInt("id"))
                .roleId(3)
                .build();

        newUser = given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("role", equalTo("Tester"))
                .extract().jsonPath();
    }

    @Test(dependsOnMethods = "successUpdateUserTest")
    public void successGetUserTest() {

        given()
                .pathParams("user_id", newUser.getInt("id"))
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

    @Test
    public void failGetUserWithoutIdTest() {

        given()
                .pathParams("user_id", "incorrectId")
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body()
                .body("error", equalTo("Field :user is not a valid ID."))
                .extract();
    }

    @Test
    public void failAddUserNameToLongTest() {
        String generatedString = RandomStringUtils.randomAlphabetic(251);
        user = UserApi.builder()
                .name(generatedString)
                .email(faker.internet().emailAddress())
                .build();

        given()
                .body(user)
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
