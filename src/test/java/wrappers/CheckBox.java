package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void click() { //поставить флажок
        uiElement.click();
    }

//    public void doubleClick(){ //убрать флажок
//        uiElement.
//    }
}
