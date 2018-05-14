package task3.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import task3.navigation.PageObject;

/**
 * Паттерн Base Page
 */
public abstract class AbstractPage extends PageObject {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Открывает страницу
     */
    public void open() {
        getDriver().get(getPageUrl());
    }

    /**
     * Возвращает текущий url страницы
     */
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
