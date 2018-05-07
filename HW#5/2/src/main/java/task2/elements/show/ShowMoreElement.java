package task2.elements.show;

import task2.elements.Component;
import task2.elements.ComponentObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Component(xpath = "//button[contains(@class,'js-pgng_more_link')]")
public class ShowMoreElement extends ComponentObject {

    public ShowMoreElement(WebDriver driver) {
        super(driver);
    }

    /**
     * Нажатие на кнопку "Показать еще"
     */

    public void clickButtonShowMore() {
        getDriver().findElement(By.xpath("//button[contains(@class,'js-pgng_more_link')]")).click();
    }
}
