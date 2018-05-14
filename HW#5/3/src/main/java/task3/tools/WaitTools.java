package task3.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.getProperty;

/**
 * Ожидания
 */
public class WaitTools {

    private WebDriver driver = null;

    public WaitTools(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForCondition(ExpectedCondition<WebElement> condition) {
        WebDriverWait webDriverWait = new WebDriverWait(
                driver, Long.parseLong(getProperty("webdriver.timeouts.implicitlywait")) / 1000);
        try {
            return webDriverWait.until(condition);
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean waitForConditionExist(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(
                driver, Long.parseLong(getProperty("webdriver.timeouts.implicitlywait")) / 1000);
        try {
            webDriverWait.until(condition);
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}