package testsApi;

import com.github.javafaker.Faker;
import configuration.Endpoints;
import helpers.UserHelper;
import models.UserApi;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    public UserHelper userHelper = new UserHelper();
    public UserApi user, newUser;
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

        user = userHelper.addUser(jsonAsMap);
    }

    @Test
    public void getUserTest() {
        //System.out.println(user.getId());

        given()
                .when()
                .pathParams("user_id", 29 )
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UserApi.class);
    }


}
