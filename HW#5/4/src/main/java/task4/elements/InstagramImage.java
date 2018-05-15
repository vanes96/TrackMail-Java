package task4.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Component(xpath = "//div[@class='EmbedSidecar']//img")
public class InstagramImage extends ComponentObject {

    public InstagramImage(WebDriver driver) {
        super(driver);
    }

    private final String locator = "//div[@class='EmbedSidecar']//img";

    /**
     * Находит ссылку фотографии в посте инстраграма
     */
    public WebElement find() {
        return waitTools.waitForConditionFind(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public String getUrl() {
        return find().getAttribute("src");
    }

    /**
     * Проверяет, что url фотографии поста инстраграма не равен указанному
     * @param url
     * @return boolean
     */
    public boolean isUrlNotSameAs(String url) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return !getUrl().equals(url);
            }
        };
        return waitTools.waitForConditionCheckExistence(condition);
    }

    /**
     * Проверяет, что url фотографии поста инстраграма равен указанному
     * @param url
     * @return boolean
     */
    public boolean isUrlSameAs(String url) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getUrl().equals(url);
            }
        };
        return waitTools.waitForConditionCheckExistence(condition);
    }
}
