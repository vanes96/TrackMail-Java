package task4.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import task4.elements.InstagramTextArea;
import task4.steps.AbstractSteps;

/**
 * Компонент формы поста инстаграма на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class InstagramTextAreaSteps extends AbstractSteps {

    public InstagramTextAreaSteps(WebDriver driver) {
        super(driver);
    }

    private InstagramTextArea instagramTextArea = null;

    private InstagramTextArea getInstagramTextArea() {
        if(instagramTextArea == null) {
            instagramTextArea = PageFactory.initElements(getDriver(), InstagramTextArea.class);
        }
        return instagramTextArea;
    }

    @Step("Возвращаем форму поста инстраграма на странице")
    public WebElement findInstagramTextArea() {
        return getInstagramTextArea().find();
    }
}