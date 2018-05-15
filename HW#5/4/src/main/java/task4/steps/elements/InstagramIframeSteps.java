package task4.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import task4.elements.InstagramIframe;
import task4.steps.AbstractSteps;

/**
 * Компонент фрейма поста инстаграма на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class InstagramIframeSteps extends AbstractSteps {

    public InstagramIframeSteps(WebDriver driver) {
        super(driver);
    }

    private InstagramIframe instagramIframe = null;

    private InstagramIframe getInstagramIframe() {
        if(instagramIframe == null) {
            instagramIframe = PageFactory.initElements(getDriver(), InstagramIframe.class);
        }
        return instagramIframe;
    }

    @Step("Возвращаем фрейм поста инстраграма на странице")
    public WebElement findInstagramIframe() {
        return getInstagramIframe().find();
    }
}