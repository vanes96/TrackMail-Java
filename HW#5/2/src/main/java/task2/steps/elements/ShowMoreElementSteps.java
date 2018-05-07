package task2.steps.elements;

import task2.elements.show.ShowMoreElement;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import task2.steps.AbstractSteps;

@DisplayName("Test steps")
public class ShowMoreElementSteps extends AbstractSteps {

    public ShowMoreElementSteps(WebDriver driver) {
        super(driver);
    }

    private ShowMoreElement showMoreElement = null;

    private ShowMoreElement getButtonShowMore() {
        if(showMoreElement == null) {
            showMoreElement = PageFactory.initElements(getDriver(), ShowMoreElement.class);
        }
        return showMoreElement;
    }

    @Step("Нажимаем на кнопку \"Показать еще\"!")
    public void clickButtonShowMore() {
        getButtonShowMore().clickButtonShowMore();
    }
}
