package horo.mail.ru.pages;

import horo.mail.ru.data.HoroscopeData;
import horo.mail.ru.navigation.Page;
import horo.mail.ru.navigation.UrlPattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Page("/runes/divination/1/")
@UrlPattern("runes/divination/1")
public class DivinationPage extends AbstractPage {

    public DivinationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class, 'button')][text()='Гадать']")
    public WebElement button;
    @FindBy(xpath = "//div[text()='Конкретный вопрос или предмет гадания']//..//input[contains(@class, 'input__field')]")
    public WebElement form;

String listLocator = "//div[contains(@class, 'dropdown_scrollable js-module%s')]";
String listValLocator = "//div[contains(@class, 'suggest__item')][text()='%s']";
    /**
     * Проверяет, открыт ли список для выбора
     */
    public boolean isListOpen(){
        String locator = String.format(listLocator, HoroscopeData.listclose.getName());
        //String locator = String.format(listLocator, "");
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "dropdown_active"));
    }
    /**
     * Создание локатора
     */
    public String setListLocator(){
        if(isListOpen()){return String.format(listLocator, HoroscopeData.listOpen.getName());}
        else
            return String.format(listLocator, HoroscopeData.listclose.getName());
            //return String.format(listLocator, "");
    }
    /**
     * Узнает текущее значение в списке
     */
    public Integer listValIs(){
        String locator = setListLocator();
        return Integer.parseInt(getDriver().findElement(By.xpath(locator)).getText());
    }
    /**
     * Устанавливает необходимое значение в список
     */
    public void setListVal(Integer number){
        String locator = String.format(listValLocator, number);
        if(isListOpen()){ getDriver().findElement(By.xpath(locator)).click();}
        else {
            getDriver().findElement(By.xpath(String.format(listLocator, HoroscopeData.listclose.getName()))).click();
            //getDriver().findElement(By.xpath(String.format(listLocator, ""))).click();
            getDriver().findElement(By.xpath(locator)).click(); }
    }
    /**
     * Прокрутка списка через Action
     */
    public boolean scrollList(){
        getDriver().findElement(By.xpath("//div[contains(@class, 'dropdown_scrollable js-module')]")).click();
        WebElement scrollBar = getDriver().findElement(By.xpath("//div[contains(@class, 'js-scrollbar__track__drag')]//div"));
        try
        {
            Actions dragger = new Actions(getDriver());
            int numberOfPixelsToDragTheScrollbarDown = 10;
            while (!waitTools.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'suggest__item')][text()='7']"))));
            {
                dragger.moveToElement(scrollBar).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release(scrollBar).build().perform();
            }
            Thread.sleep(500);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
}
