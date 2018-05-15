package task4.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Component(xpath = "//textarea[contains(@class,'lazyembed-textarea')]")
public class InstagramTextArea extends ComponentObject {

    public InstagramTextArea(WebDriver driver) {
        super(driver);
    }

    private final String locator = "//textarea[contains(@class,'lazyembed-textarea')]";

    /**
     * Находит форму на месте фрейма поста инстраграма
     */
    public WebElement find() {
        return getDriver().findElement(By.xpath(locator));
    }
}