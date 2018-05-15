package task4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import task4.pages.IncidentsNewsPage;

/**
 * Набор шагов для взаимодействия со страницей "Новости инцидентов"
 */
public class IncidentsNewsPageSteps extends AbstractSteps {

    private IncidentsNewsPage incidentsNewsPage = null;

    public IncidentsNewsPageSteps(WebDriver driver) {
        super(driver);
        incidentsNewsPage = PageFactory.initElements(driver, IncidentsNewsPage.class);
    }

    @Step("Открываем страницу новостей инцидентов")
    public void open() {
        incidentsNewsPage.open();
    }

    @Step("Прокручиваем страницу до определенного веб-элемента")
    public Object switchToWebElement(WebElement webElement) {
        return incidentsNewsPage.executeScript(webElement);
    }
}
