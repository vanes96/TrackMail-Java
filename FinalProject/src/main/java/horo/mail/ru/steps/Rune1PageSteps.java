package horo.mail.ru.steps;

import horo.mail.ru.pages.Rune1Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class Rune1PageSteps extends AbstractSteps {
    public Rune1Page page = null;

    public Rune1PageSteps(WebDriver driver) {
        super(driver);
        page = PageFactory.initElements(driver, Rune1Page.class);
    }

    public Rune1Page getPage(){
        page = PageFactory.initElements(getDriver(), Rune1Page.class);
        return page;
    }

    public String getPageHeader(){
        return getPage().getHeader();
    }

    @Step("Получаем заголовок страницы")
    private void headerShouldBeSameAs(String header){
        assertEquals("Заголовок должен быть {header}", header, page.getHeader());
    }

    @Step("Открываем страницу {header}")
    public void openPage(String header){
        page.open();
        page.pageValidate();
        headerShouldBeSameAs(header);
    }
}
