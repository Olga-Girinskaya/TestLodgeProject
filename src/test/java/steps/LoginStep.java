package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.ProjectPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Успешный логин с {email}/{psw}")
    public ProjectPage successLogin(String email, String psw) {
        loginButton();
        login(email, psw);

        return projectPage;
    }

    private void loginButton() {
        loginPage.getLoginButton().click();
    }

    private void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLoginContinue().click();
    }

    public LoginPage logout() {
        return loginPage;
    }


}

