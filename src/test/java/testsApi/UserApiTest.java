package testsApi;

import com.github.javafaker.Faker;
import configuration.Endpoints;
import helpers.UserHelper;
import io.restassured.specification.Argument;
import models.UserApi;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserApiTest extends BaseApiTest {

    public UserHelper userHelper = new UserHelper();
    public UserApi user, newUser;
    private int userId;
    Faker faker = new Faker();

    @Test
    public void addUserTest() {

        user = UserApi.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .roleId(1)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put( "name", faker.name().fullName());
        jsonAsMap.put("email", faker.internet().emailAddress());
        jsonAsMap.put("roleId", 1);

        newUser = given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_USER)
                .then()
                .statusCode(org.apache.hc.core5.http.HttpStatus.SC_OK)
                .log().body()
                .extract()
                .jsonPath().get("id");

        userId = newUser.getId();
               // .as(UserApi.class);
      //  user = userHelper.addUser(jsonAsMap);
    }

    @Test
    public void getUserTest() {
        //System.out.println(user.getId());

        given()
                .when()
                .pathParams("user_id", userId )
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(29))
                .body("name", equalTo(faker.name().fullName()))
                .extract();
                //.as(UserApi.class);
    }

}
