package task4.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import task4.data.SliderData;
import task4.elements.SliderButton;
import task4.steps.AbstractSteps;

import static org.junit.Assert.assertTrue;

/**
 * Компонент кнопки слайдера в посте инстаграма на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class SliderButtonSteps extends AbstractSteps {

    public SliderButtonSteps(WebDriver driver) {
        super(driver);
    }

    private SliderButton sliderButton = null;

    private SliderButton getSliderButton() {
        if(sliderButton == null) {
            sliderButton = PageFactory.initElements(getDriver(), SliderButton.class);
        }
        return sliderButton;
    }

    @Step("Проверяем, что кнопка {SliderData sliderData} слайдера отображается")
    public void isSliderButtonDisplayed(SliderData sliderData) {
        assertTrue("Кнопка слайдера отображается",
                getSliderButton().isDisplayed(sliderData));
    }

    @Step("Кликаем на кнопку {SliderData sliderData} слайдера")
    public void clickButton(SliderData sliderData) {
        getSliderButton().click(sliderData);
    }
}