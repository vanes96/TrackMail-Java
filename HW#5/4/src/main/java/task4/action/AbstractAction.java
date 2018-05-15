package task4.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import task4.navigation.PageObject;

public class AbstractAction extends PageObject {

    private Actions action;

    public AbstractAction(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public void performWebElement(WebElement webElement) {
        action.moveToElement(webElement).perform();
    }
}