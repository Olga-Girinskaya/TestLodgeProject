package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                loginStep.successLogin(
                                ReadProperties.username(),
                                ReadProperties.password()
                        )
                        .isPageOpened()
        );
    }

}
