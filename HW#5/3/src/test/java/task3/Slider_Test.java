package task3;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task3.data.SliderData;
import task3.driver.DriverProvider;
import task3.steps.NewsCinemaPageSteps;
import task3.steps.elements.PhotoTileSteps;
import task3.steps.elements.SlideButtonSteps;

@DisplayName("Проверяем работу кнопок слайдера фотографий на странице \"Новости кино\"")
public class Slider_Test {

    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void test() {

        //Открываем страницу новостей кино и проверяем ее адрес
        NewsCinemaPageSteps newsCinemaPageSteps = new NewsCinemaPageSteps(driverProvider.getDriver());
        newsCinemaPageSteps.open();
        newsCinemaPageSteps.isUrlSameAs(newsCinemaPageSteps.getPageUrl());

        // Выбираем 1-ую фотографию из галереи
        PhotoTileSteps photoTileSteps = new PhotoTileSteps(driverProvider.getDriver());
        photoTileSteps.clickPhotoGalleryBar();

        //Проверяем, что адрес страницы изменился
        newsCinemaPageSteps.isUrlDifferentFrom(newsCinemaPageSteps.getPageUrl());

        // Проверка для 1-ого фото
        String Photo1Url, Photo2Url, Photo3Url; // 3 разные фотографии
        Photo1Url = newsCinemaPageSteps.getUrl();
        SlideButtonSteps slideButtonSteps = new SlideButtonSteps(driverProvider.getDriver());
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Next);
        slideButtonSteps.isSliderButtonNotDisplayed(SliderData.Previous);

        // Проверка для 2-ого фото
        slideButtonSteps.click(SliderData.Next);
        Photo2Url = newsCinemaPageSteps.getUrl();
        newsCinemaPageSteps.isUrlDifferentFrom(Photo1Url);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Next);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Previous);

        // Проверка для 3-ого фото
        slideButtonSteps.click(SliderData.Next);
        Photo3Url = newsCinemaPageSteps.getUrl();
        newsCinemaPageSteps.isUrlDifferentFrom(Photo1Url);
        newsCinemaPageSteps.isUrlDifferentFrom(Photo2Url);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Next);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Previous);

        // Проверка для 2-ого фото
        slideButtonSteps.click(SliderData.Previous);
        newsCinemaPageSteps.isUrlSameAs(Photo2Url);
        newsCinemaPageSteps.isUrlDifferentFrom(Photo3Url);
        newsCinemaPageSteps.isUrlDifferentFrom(Photo1Url);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Next);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Previous);

        // Проверка для 1-ого фото
        slideButtonSteps.click(SliderData.Previous);
        newsCinemaPageSteps.isUrlSameAs(Photo1Url);
        newsCinemaPageSteps.isUrlDifferentFrom(Photo3Url);
        newsCinemaPageSteps.isUrlDifferentFrom(Photo2Url);
        slideButtonSteps.isSliderButtonDisplayed(SliderData.Next);
        slideButtonSteps.isSliderButtonNotDisplayed(SliderData.Previous);
    }
}
