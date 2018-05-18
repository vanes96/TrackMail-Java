package horo.mail.ru.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Ожидания
 */
public class WaitTools {

    private WebDriver driver = null;

    public WaitTools(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 1);
        try {
            webDriverWait.until(condition);
            return true;
        } catch(Exception ex) {
            return false;
        }

    }
}