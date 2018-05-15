package task4.navigation;

import org.openqa.selenium.WebDriver;
import task4.tools.WaitTools;

/**
 * Навигация по страницам проекта
 */
public abstract class PageObject {

    private Class<?> pageClass = super.getClass();

    private WebDriver driver = null;

    protected WaitTools waitTools;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        waitTools = new WaitTools(getDriver());
    }

    /**
     * Возвращает URL страницы
     * @return URL страницы
     */
    protected String getPageUrl() {
        return System.getProperty("webdriver.base.url");
    }

    /**
     * Возвращает драйвер
     * @return драйвер
     */
    protected WebDriver getDriver() {
        return driver;
    }
}