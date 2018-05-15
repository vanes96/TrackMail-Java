package task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Страница "Новости происшествий" с реализацией PageObject паттерна
 */
public class IncidentsNewsPage extends AbstractPage {

    public IncidentsNewsPage(WebDriver driver) {
        super(driver);
    }

    //Прокручивает страницу до нужного веб-элемента {webElement}
    public Object executeScript(WebElement webElement) {
        return getJSExecutor().executeScript("arguments[0].scrollIntoView();", webElement);
    }
}