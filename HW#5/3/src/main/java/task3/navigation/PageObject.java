package task3.navigation;

import org.openqa.selenium.WebDriver;
import task3.tools.WaitTools;

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
    public String getPageUrl() {
        return System.getProperty("webdriver.base.url");
    }

    /**
     * Возвращает URL попапа
     * @return URL попапа
     */
    public String getPopupUrl() {
        return System.getProperty("webdriver.popup.url");
    }

    /**
     * Возвращает драйвер
     * @return драйвер
     */
    protected WebDriver getDriver() {
        return driver;
    }
}