package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.ProjectPage;
import page.StartPage;

public class LoginStep extends BaseStep {
    public StartPage startPage;

    public LoginStep(WebDriver driver) {
        super(driver);
        startPage = new StartPage(driver);
    }

    @Step("Удачный логин с {email}/{psw}")
    public ProjectPage successLogin(String email, String psw) throws InterruptedException {
        loginButton();
        login(email, psw);

        return projectPage;
    }

    @Step("Неудачный логин с {email}/{psw}")
    public LoginPage incorrectLogin(String email, String psw) throws InterruptedException {
        loginButton();
        login(email, psw);

        return loginPage;
    }

    private void loginButton() {
        startPage.getLoginButton().click();
    }

    private void login(String email, String psw) throws InterruptedException {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);

        // если появится капча, то нужно раскоментить
    /*    driver.switchTo().frame(0);
        Thread.sleep(2000);
        //driver.switchTo().frame(driver.findElement();
        Assert.assertTrue(loginPage.getCheckboxCaptcha().isDisplayed());
        loginPage.getCheckboxCaptcha().click();
        driver.switchTo().parentFrame();

     */

        loginPage.getLoginContinue().click();
    }

    public StartPage logout() {
        return startPage;
    }
}

