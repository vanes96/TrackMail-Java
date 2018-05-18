package horo.mail.ru.steps.elements;

import horo.mail.ru.elements.Rune15Element;
import horo.mail.ru.pages.Rune1Page;
import horo.mail.ru.steps.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuneElementSteps extends AbstractSteps {
private Rune15Element runecomponent = null;
private Rune1Page rune1Page = null;
    public RuneElementSteps(WebDriver driver) {
        super(driver);
        runecomponent = PageFactory.initElements(driver, Rune15Element.class);
    }
    private Rune1Page getRune1Page(){
        rune1Page = PageFactory.initElements(getDriver(), Rune1Page.class);
        return rune1Page;
    }

    @Step("Кликаем по первой руне в списке и проверяем, что открылась нужная страница")
    public void clickFirstRune(){
        runecomponent.getRunePage(1);
        assertEquals("Заголовок не соответствует нужной руне", getRune1Page().getHeader(), runecomponent.getRuneName(1));
    }

    @Step("Получаем имя первой руны")
    public String getFirstRuneName(){
        return runecomponent.getRuneName(1);
    }

    @Step("Кликаем по кнопке еще и проверяем актуальность открывшегося списка")
    public void checkRuneList(){
        assertTrue("Список функционирует неверно" ,runecomponent.checkRuneList());
    }

    @Step("Проверяем, что после наводки мышкой цвет границы поменялся")
    public void checkBorder(){
        assertTrue("Граница у элемента не меняется", runecomponent.checkColourHover());
    }
}
