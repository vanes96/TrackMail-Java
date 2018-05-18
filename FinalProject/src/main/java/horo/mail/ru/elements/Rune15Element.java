package horo.mail.ru.elements;

import horo.mail.ru.data.HoroscopeData;
import horo.mail.ru.navigation.Page;
import horo.mail.ru.pages.Rune1Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static horo.mail.ru.data.HoroscopeData.listRuneDynamicAfter;
import static horo.mail.ru.data.HoroscopeData.listRuneDynamicBefore;
import static horo.mail.ru.data.HoroscopeData.listRuneStatic;

@Page("/runes/tile/15/")
@Component(xpath = "//span[text()='Все руны']")
public class Rune15Element extends ComponentObject {

    public Rune15Element(WebDriver driver) {
        super(driver);
    }
    String locator = "//span[text()='Все руны']/ancestor::div[contains(@class, 'wrapper_outside')]//div[@class='p-outside-block__content%s']//span[contains(@class, 'name')]";

    @FindBy(xpath = "//div[text()='Ещё']/..")
    WebElement buttonMore;
    public String getRuneName(Integer number){
        return getDriver().findElements(byBuilder(listRuneStatic)).get(number-1).getText();
    }
    public Rune1Page getRunePage(Integer number){
        getDriver().findElements(byBuilder(listRuneStatic)).get(number-1).click();
        return PageFactory.initElements(getDriver(), Rune1Page.class);
    }
    /**
     * Метод для создания By указателя
     */
    public By byBuilder(HoroscopeData horoscopeData){
        return By.xpath((String.format(locator, horoscopeData.getName())));
    }

    public List<String> listBuilder(HoroscopeData horoscopeData){
        return getDriver().findElements(byBuilder(horoscopeData)).stream()
                .map((s) -> s.getText()).collect(Collectors.toList());
    }
    /**
     * Проверяем кнопку еще в списке рун
     */
    public boolean checkRuneList(){
        waitTools.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(byBuilder(listRuneDynamicBefore)));
        List<String> runesStatic = listBuilder(listRuneStatic);
        buttonMore.click();
        waitTools.waitForCondition(ExpectedConditions.visibilityOfElementLocated(byBuilder(listRuneDynamicAfter)));
        List<String> runesDynamic = listBuilder(listRuneDynamicAfter);
        List<String> runes = runesStatic;
        runesStatic.removeAll(runesDynamic);
        return runesStatic.equals(runes);
    }
    /**
     * Проверяем, что граница у элемента меняется при наведении на него курсора
     */
    public boolean checkColourHover(){
        Actions action = new Actions(getDriver());
        WebElement switchLabel = getDriver().findElement(By.cssSelector(".p-imaged-item__img"));
        String colorRGBBefore = getJSExecutor().executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('border-color');",switchLabel).toString();
        action.moveToElement(getDriver().findElement(By.xpath("//a[contains(@class, 'p-imaged-item_circle')]"))).build().perform();
        String colorRGBAfter = getJSExecutor().executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('border-color');",switchLabel).toString();
        return !colorRGBAfter.contains(colorRGBBefore);
    }
}
