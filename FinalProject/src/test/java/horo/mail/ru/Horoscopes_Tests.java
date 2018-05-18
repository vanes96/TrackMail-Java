package horo.mail.ru;

import horo.mail.ru.driver.DriverProvider;
import horo.mail.ru.steps.DivinationPageSteps;
import horo.mail.ru.steps.Rune15PageSteps;
import horo.mail.ru.steps.Rune1PageSteps;
import horo.mail.ru.steps.elements.RuneElementSteps;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Horoscopes_Tests {
    private DriverProvider driverProvider = null;
    private Rune15PageSteps rune15PageSteps = null;

    @Before
    public void init() {
        driverProvider = new DriverProvider();
        rune15PageSteps = new Rune15PageSteps(driverProvider.getDriver());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void TestCase1() {
        //открываем страницу "Расклад "Шаг в будущее"
        DivinationPageSteps divinationPage_Steps = new DivinationPageSteps(driverProvider.getDriver());
        divinationPage_Steps.open("Расклад «Шаг в будущее»");

        //проверяем, что в списке по умолчанию выбрано 1
        divinationPage_Steps.checkScrollList();
        //Печатаем текст вопрос в поле
        divinationPage_Steps.printTextInForm();
        //Выбираем третий пункт в раскрывающемся списке
        divinationPage_Steps.setListValue(3);
        //Нажимаем на кнопку "Гадать"
        divinationPage_Steps.clickButton();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void TestCase2() {
        //открываем страницу "Расклад "Шаг в будущее"
        DivinationPageSteps divinationPage_Steps = new DivinationPageSteps(driverProvider.getDriver());
        divinationPage_Steps.open("Расклад «Шаг в будущее»");

        //Проверяем скролл списка
        divinationPage_Steps.checkScrollList();
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void TestCase3() {
        //открываем страницу руны "Альгиз"
        rune15PageSteps.openPage("Альгиз");

        //Нажимаем по первой руне и проверяем открывшуюся страницу
        RuneElementSteps runeComponent_steps = new RuneElementSteps(driverProvider.getDriver());
        runeComponent_steps.clickFirstRune();
        assertEquals("Открылась неверная руна",rune15PageSteps.getPageHeader(), runeComponent_steps.getFirstRuneName());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void TestCase4() {
        //открываем страницу руны "Альгиз"
        rune15PageSteps.openPage("Альгиз");

        //Кликаем по кнопке еще и проверяем актуальность списка
        RuneElementSteps runeComponent_steps = new RuneElementSteps(driverProvider.getDriver());
        runeComponent_steps.checkRuneList();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void TestCase5() {
        //открываем страницу руны "Альгиз"
        rune15PageSteps.openPage("Альгиз");

        //Наводим мышкой на руну и проверяем, что цвет границы изменился
        RuneElementSteps runeComponent_steps = new RuneElementSteps(driverProvider.getDriver());
        runeComponent_steps.checkBorder();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
        rune15PageSteps = null;
    }
}
