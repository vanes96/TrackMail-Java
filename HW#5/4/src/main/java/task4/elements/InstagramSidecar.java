package task4.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Component(xpath = "//div[@class='EmbedSidecar']")
public class InstagramSidecar extends ComponentObject {

    public InstagramSidecar(WebDriver driver) {
        super(driver);
    }

    private final String locator = "//div[@class='EmbedSidecar']";

    /**
     * Находит фрейм поста инстраграма
     */
    public WebElement find() {
        return waitTools.waitForConditionFind(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}