package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {

    // Блок описания селекторов для элементов
    private final By emailInputLocator = By.id("username");
    private final By pswInputLocator = By.id("password");
    private final By buttonContinue = By.name("action");
    private final By checkboxCaptcha = By.id("recaptcha-anchor");
    private final By errorTextLocator = By.id("error-element-password");
    //private final By iframeLocator = By.cssSelector("#ulp-recaptcha > div > div > iframe");

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

    public Button getLoginContinue() {
        return new Button(driver, buttonContinue);
    }

    public WebElement getCheckboxCaptcha() {
        return waitsService.waitForExists(checkboxCaptcha);
    }
/*
    public Button getCheckboxCaptcha() {
        return new Button(driver, checkboxCaptcha);
    }

 */

    public UIElement getErrorTextElement() {
        return new UIElement(driver, errorTextLocator);
    }

}
