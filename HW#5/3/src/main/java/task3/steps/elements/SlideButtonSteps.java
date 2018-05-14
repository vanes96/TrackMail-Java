package task3.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import task3.data.SliderData;
import task3.elements.SlideButton;
import task3.steps.AbstractSteps;

import static org.junit.Assert.assertTrue;

/**
 * Компонент кнопки слайдера на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class SlideButtonSteps extends AbstractSteps {

    public SlideButtonSteps(WebDriver driver) {
        super(driver);
    }

    private SlideButton slideButton = null;

    private SlideButton getSlideButton() {
        if(slideButton == null) {
            slideButton = PageFactory.initElements(getDriver(), SlideButton.class);
        }
        return slideButton;
    }

    @Step("Проверяем, что кнопка {SliderData sliderData} отображена")
    public void isSliderButtonDisplayed(SliderData sliderData) {
        assertTrue("Кнопка {SliderData sliderData} отображена",
                getSlideButton().isSliderButtonDisplayed(sliderData));
    }

    @Step("Проверяем, что кнопка {SliderData sliderData} не отображена")
    public void isSliderButtonNotDisplayed(SliderData sliderData) {
        assertTrue("Кнопка {SliderData sliderData} не отображена",
                getSlideButton().isSliderButtonNotDisplayed(sliderData));
    }

    @Step("Нажимаем на кнопку {SliderData sliderData}")
    public void click(SliderData sliderData) {
        getSlideButton().clickSliderButton(sliderData);
    }
}