package task3.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Component(xpath = "//span[contains(@class,'js-show_photo')]")
public class PhotoTile extends ComponentObject {

    public PhotoTile(WebDriver driver) {
        super(driver);
    }

    private final String photoTileLocator = "//span[contains(@class,'js-show_photo')]";

    /**
     * Находит плитку фотогалереи на странице
     */
    public WebElement findPhotoTile() {
        return waitTools.waitForCondition(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(photoTileLocator)));
    }

    /**
     * Нажимает на плитку в фотогалерее
     */
    public void clickPhotoGalleryBar() {
        findPhotoTile().click();
    }
}
