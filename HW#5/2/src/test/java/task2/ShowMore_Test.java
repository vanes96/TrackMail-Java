package task2;

import task2.driver.DriverProvider;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task2.steps.PetsNewsPageSteps;
import task2.steps.elements.ShowMoreElementSteps;

import java.util.List;

@DisplayName("Проверяем нажатие по кнопке \"Показать еще\" на странице /news проекта \"Питомцы\"")
public class ShowMore_Test {

    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testButtonExistsAndAddsMoreNews() {

        //Открываем страницу новостей
        PetsNewsPageSteps petsNewsPageSteps = new PetsNewsPageSteps(driverProvider.getDriver());
        petsNewsPageSteps.open("Новости");

        //Получаем названия всех статей на странице
        List<String> newsTitles = petsNewsPageSteps.getAllArticlesTitles();

        //Нажимаем на кнопку "Показать еще"
        ShowMoreElementSteps clickButtonShowMoreSteps = new ShowMoreElementSteps(driverProvider.getDriver());
        clickButtonShowMoreSteps.clickButtonShowMore();

        //Проверяем, что список статей на странице увеличился
        petsNewsPageSteps.articlesTitlesShouldBeIncreased(newsTitles);
    }
}
