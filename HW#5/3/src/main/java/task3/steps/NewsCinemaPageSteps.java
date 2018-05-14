package task3.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import task3.pages.NewsCinemaPage;

import static org.junit.Assert.assertTrue;

/**
 * Набор шагов для взаимодействия со страницей "Новости кино"
 */
public class NewsCinemaPageSteps extends AbstractSteps {

    private NewsCinemaPage newsCinemaPage = null;

    public NewsCinemaPageSteps(WebDriver driver) {
        super(driver);
        newsCinemaPage = PageFactory.initElements(driver, NewsCinemaPage.class);
    }

    @Step("Открываем страницу новостей")
    public void open() {
        newsCinemaPage.open();
    }

    @Step("Возвращаем текущий url страницы")
    public String getUrl() {
        return newsCinemaPage.getCurrentUrl();
    }

    @Step("Проверяем, что текущий url страницы не равен данному")
    public void isUrlDifferentFrom(String url) {
        assertTrue("Url страницы должен быть отличным от данного", newsCinemaPage.isUrlDifferentFrom(url));
    }

    @Step("Проверяем, что текущий url страницы соответствует данному")
    public void isUrlSameAs(String url) {
        assertTrue("Url страницы должен быть равен данному", newsCinemaPage.isUrlSameAs(url));
    }
}
