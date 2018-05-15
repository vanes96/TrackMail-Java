package task4.steps;

import org.openqa.selenium.WebDriver;
import task4.navigation.PageObject;

/**
 * Абстрактные Шаги
 */
public abstract class AbstractSteps extends PageObject {

    public AbstractSteps(WebDriver driver) {
        super(driver);
    }
}
