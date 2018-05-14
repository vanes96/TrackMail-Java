package task3.steps;

import org.openqa.selenium.WebDriver;
import task3.navigation.PageObject;

/**
 * Абстрактные Шаги
 */
public abstract class AbstractSteps extends PageObject {

    public AbstractSteps(WebDriver driver) {
        super(driver);
    }
}
