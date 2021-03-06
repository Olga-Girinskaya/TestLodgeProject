package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.DashboardPage;
import page.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Удачный логин с {email}/{psw}")
    public DashboardPage successLogin(String email, String psw){
        login(email, psw);
        return dashboardPage;
    }

    @Step("Неудачный логин с {email}/{psw}")
    public LoginPage incorrectLogin(String email, String psw)  {
        login(email, psw);

        return loginPage;
    }

    public void login(String email, String psw) {

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLoginButton().click();
    }

}

