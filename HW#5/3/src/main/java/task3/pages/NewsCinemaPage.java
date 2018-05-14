package task3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Страница "Новости кино" с реализацией PageObject паттерна
 */
public class NewsCinemaPage extends AbstractPage {

    public NewsCinemaPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверяет, что url страницы не равен указанному url
     * @param url
     * @return boolean
     */
    public boolean isUrlDifferentFrom(String url) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return !getCurrentUrl().equals(url);
            }
        };
        return waitTools.waitForConditionExist(condition);
    }

    /**
     * Проверяет, что url страницы равен указанному url
     * @param url
     * @return boolean
     */
    public boolean isUrlSameAs(String url) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getCurrentUrl().equals(url);
            }
        };
        return waitTools.waitForConditionExist(condition);
    }
}