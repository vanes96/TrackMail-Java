package task4.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import task4.elements.InstagramSidecar;
import task4.steps.AbstractSteps;

/**
 * Компонент поста инстаграма на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class InstagramSidecarSteps extends AbstractSteps {

    public InstagramSidecarSteps(WebDriver driver) {
        super(driver);
    }

    private InstagramSidecar instagramSidecar = null;

    private InstagramSidecar getInstagramSidecar() {
        if(instagramSidecar == null) {
            instagramSidecar = PageFactory.initElements(getDriver(), InstagramSidecar.class);
        }
        return instagramSidecar;
    }

    @Step("Возращаем пост инстраграма странице")
    public WebElement findInstagramSidecar() {
        return getInstagramSidecar().find();
    }
}