package testsApi;

import configuration.ReadProperties;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    @BeforeTest
    @Step("Прохождение авторизации")
    public void setupEnv() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given().urlEncodingEnabled(false)
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .filter(new AllureRestAssured()
                .setRequestTemplate("http-request.ftl")
                .setResponseTemplate("http-response.ftl"));
    }

    @AfterTest
    public void tearDown() {
    }
}
