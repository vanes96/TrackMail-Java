package task2.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import task2.pages.PetsNewsPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetsNewsPageSteps extends AbstractSteps {

    private PetsNewsPage petsNewsPage = null;

    public PetsNewsPageSteps(WebDriver driver) {
        super(driver);
        petsNewsPage = PageFactory.initElements(driver, PetsNewsPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
              petsNewsPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        petsNewsPage.open();
        petsNewsPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return petsNewsPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице увеличился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeIncreased(List<String> titles) {
        assertTrue("Число статей должно увеличиться",
                petsNewsPage.isArticlesTitlesIncreased(titles));
    }

    @Step("Проверяем, что список статей на странице содержит все предыдущие статьи")
    public void articlesTitlesShouldContainPrevious(List<String> titles) {
        assertTrue("Список статей должен содержать все предыдущие",
                petsNewsPage.isArticlesTitlesContainPrevious(titles));
    }
}
