package task3.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task3.data.SliderData;

/**
 * Клик на кнопку Слайдера
 */
@Component(xpath = "//div[contains(@class,'viewbox__container')]")
public class SlideButton extends ComponentObject {

    public SlideButton(WebDriver driver) {
        super(driver);
    }

    private final String slideButtonLocator = "//span[contains(@class,'icon_control_%s')]";

    /**
     * Находит кнопку слайдера на странице
     * @param sliderData - кнопка
     * @return WebElement
     */
    public WebElement findSliderButton(SliderData sliderData) {
        String locator = String.format(slideButtonLocator, sliderData.getName());
        return waitTools.waitForCondition(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * Кликает на кнопку слайдера на странице
     * @param sliderData - кнопка
     */
    public void clickSliderButton(SliderData sliderData) {
        findSliderButton(sliderData).click();
    }

    /**
     * Проверяет, что кнопка слайдера отображается на странице
     * @param sliderData - кнопка
     * @return boolean
     */
    public boolean isSliderButtonDisplayed(SliderData sliderData) {
        return findSliderButton(sliderData).isDisplayed();
    }

    /**
     * Проверяет, что кнопка слайдера не отображается на странице
     * @param sliderData - кнопка
     * @return boolean
     */
    public boolean isSliderButtonNotDisplayed(SliderData sliderData) {
        if (findSliderButton(sliderData) == null) {
            return true;
        }
        return !findSliderButton(sliderData).isDisplayed();
    }
}