package horo.mail.ru.navigation;

import horo.mail.ru.tools.WaitTools;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

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
        if(pageClass.isAnnotationPresent(Page.class))
            return System.getProperty("webdriver.base.url") + pageClass.getAnnotation(Page.class).value();

        return "";
    }

    /**
     * Проверяет URL страницы на соответствие шаблону
     */
    public void pageValidate() {
        if(pageClass.isAnnotationPresent(UrlPattern.class)) {
            String pattern = pageClass.getAnnotation(UrlPattern.class).value();
            assertTrue(String.format("URL страницы не соответствует шаблону %s", pattern),
                    driver.getCurrentUrl().matches("http[s]?.*?(?::\\d+)?/" + pattern + "/?"));
        }
    }

    /**
     * Возвращает драйвер
     * @return драйвер
     */
    protected WebDriver getDriver() {
        return driver;
    }
}
