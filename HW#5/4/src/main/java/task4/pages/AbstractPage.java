package task4.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import task4.navigation.PageObject;

/**
 * Паттерн Base Page
 */
public abstract class AbstractPage extends PageObject {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    /**
     * JavaScript Executor
     * @return executor
     */
    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    /**
     * Открывает страницу
     */
    public void open() {
        getDriver().get(getPageUrl());
    }
}
