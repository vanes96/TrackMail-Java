package task4.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task4.data.SliderData;

/**
 * Клик на кнопку слайдера
 */
@Component(xpath = "//div[@class='EmbedSidecar']")
public class SliderButton extends ComponentObject {

    public SliderButton(WebDriver driver) {
        super(driver);
    }

    private final String locator = "//a[contains(@class,'coreSprite%sChevron')]";

    /**
     * Находит кнопку слайдера на странице
     * @param sliderData - кнопка
     * @return WebElement
     */
    public WebElement find(SliderData sliderData) {
        String locator = String.format(this.locator, sliderData.getName());
        return waitTools.waitForConditionFind(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * Кликает на кнопку слайдера на странице
     * @param sliderData - кнопка
     */
    public void click(SliderData sliderData) {
        find(sliderData).click();
    }

    /**
     * Проверяет, что кнопка слайдера отображается на странице
     * @param sliderData - кнопка
     * @return boolean
     */
    public boolean isDisplayed(SliderData sliderData) {
        return find(sliderData).isDisplayed();
    }
}
