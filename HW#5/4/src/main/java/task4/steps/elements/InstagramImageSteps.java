package task4.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import task4.elements.InstagramImage;
import task4.steps.AbstractSteps;

import static org.junit.Assert.assertTrue;

/**
 * Компонент фотографии в посте инстаграма на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class InstagramImageSteps extends AbstractSteps {

    public InstagramImageSteps(WebDriver driver) {
        super(driver);
    }

    private InstagramImage instagramImage = null;

    private InstagramImage getInstagramImage() {
        if(instagramImage == null) {
            instagramImage = PageFactory.initElements(getDriver(), InstagramImage.class);
        }
        return instagramImage;
    }

    @Step("Возвращаем url изображения из инстраграма на странице")
    public String getInstagramImageUrl() {
        return getInstagramImage().getUrl();
    }

    @Step("Проверяем, что url изображения не равен данному")
    public void isInstagramImageNotSameAs(String url) {
        assertTrue("Изображение должно отличаться от данного", instagramImage.isUrlNotSameAs(url));
    }

    @Step("Проверяем, что url изображения соответствует данному")
    public void isInstagramImageSameAs(String url) {
        assertTrue("Изображение не должно отличаться от данного", instagramImage.isUrlSameAs(url));
    }
}