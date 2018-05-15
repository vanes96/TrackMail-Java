package task4.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Component(xpath = "//iframe[contains(@class,'instagram-media-rendered')]")
public class InstagramIframe extends ComponentObject {

    public InstagramIframe(WebDriver driver) {
        super(driver);
    }

    private final String locator = "//iframe[contains(@class,'instagram-media-rendered')]";

    /**
     * Находит фрейм поста инстраграма
     */
    public WebElement find() {
        return waitTools.waitForConditionFind(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}