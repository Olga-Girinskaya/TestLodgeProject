package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {

    // Блок описания селекторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By buttonLogin = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

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
        return new Button(driver, buttonLogin);
    }

    public UIElement getErrorTextElement() {
        return new UIElement(driver, errorTextLocator);
    }

}
