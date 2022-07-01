package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;

public class StartPage extends BasePage {

    // Блок описания селекторов для элементов
    private final By logInButtonLocator = By.className("round_green_button");

    // Блок иницализации
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public Button getLoginButton() {
        return new Button(driver, logInButtonLocator);
    }
}
