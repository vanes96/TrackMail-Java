package horo.mail.ru.steps;

import horo.mail.ru.pages.Rune15Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class Rune15PageSteps extends AbstractSteps {
    
    private Rune15Page page = null;
    
    public Rune15PageSteps(WebDriver driver) {
        super(driver);
        page = PageFactory.initElements(driver, Rune15Page.class);
    }

    public Rune15Page getPage(){
        page = PageFactory.initElements(getDriver(), Rune15Page.class);
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
