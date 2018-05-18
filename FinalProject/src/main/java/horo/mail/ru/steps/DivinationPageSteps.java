package horo.mail.ru.steps;

import horo.mail.ru.pages.DivinationPage;
import horo.mail.ru.pages.Rune1Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DivinationPageSteps extends AbstractSteps {
    private DivinationPage divinationPage = null;
    private Rune1Page rune1Page = null;

    public DivinationPageSteps(WebDriver driver) {
        super(driver);
        divinationPage = PageFactory.initElements(driver, DivinationPage.class);
    }
    private Rune1Page getRune1Page(){
        rune1Page = PageFactory.initElements(getDriver(), Rune1Page.class);
        return rune1Page;
    }

    @Step("Получаем заголовок веб страницы")
    private void pageHeaderShouldBeSameAs(String header){
        assertEquals("Неверный заголовок", header, divinationPage.getHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header){
        divinationPage.open();
        divinationPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Проверяем, что в списке по умолчанию выбрано 1")
    public void listStateDefault(){
        assertEquals("Неверное стандартное значение листа", divinationPage.listValIs(), (Integer) 1);
    }

    @Step("Печатаем текст \"Вопрос\" в поле вопроса")
    public void printTextInForm(){
        divinationPage.form.sendKeys("Вопрос");
    }
    @Step("Выбираем третий пункт в списке")
    public void setListValue(Integer number){
        divinationPage.isListOpen();
        divinationPage.setListVal(number);
        assertEquals("Пункт установлен неверно", divinationPage.listValIs(), number);
    }
    @Step("Нажимаем на кнопку \"Гадать\"")
    public void clickButton(){
        getRune1Page().clickButton(divinationPage.button);
    }

    @Step("Проверяем скролл списка")
    public void checkScrollList(){
        assertTrue("Список функционирует неверно", divinationPage.scrollList());
    }


}
