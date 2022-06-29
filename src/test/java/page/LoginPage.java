package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {
    private final static String pagePath = "/login/";

    // Блок описания селекторов для элементов
    private By logInButtonLocator = By.className("round_green_button");
    private By emailInputLocator = By.id("username");
    private By pswInputLocator = By.id("password");
    private By buttonContinue = By.cssSelector(".cbcff1f92");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    // Блок атомарных методов
    public UIElement getEmailInput() {
        return new UIElement(driver, emailInputLocator);
    }

    public UIElement getPswInput() {
        {
            return new UIElement(driver, pswInputLocator);
        }
    }

    public Button getLoginButton() {
        return new Button(driver, logInButtonLocator);
    }

    public Button getLoginContinue() {
        return new Button(driver, buttonContinue);
    }
}
