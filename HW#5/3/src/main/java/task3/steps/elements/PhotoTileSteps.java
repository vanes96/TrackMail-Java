package task3.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import task3.elements.PhotoTile;
import task3.steps.AbstractSteps;

/**
 * Компонент плитки фотогалереи на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class PhotoTileSteps extends AbstractSteps {

    public PhotoTileSteps(WebDriver driver) {
        super(driver);
    }

    private PhotoTile photoTile = null;

    private PhotoTile getPhotoTile() {
        if(photoTile == null) {
            photoTile = PageFactory.initElements(getDriver(), PhotoTile.class);
        }
        return photoTile;
    }

    @Step("Возращаем плитку фотогалереи странице")
    public WebElement findPhotoGalleryBar() {
        return getPhotoTile().findPhotoTile();
    }

    @Step("Кликаем на плитку фотогалереи на странице")
    public void clickPhotoGalleryBar() {
        getPhotoTile().clickPhotoGalleryBar();
    }
}