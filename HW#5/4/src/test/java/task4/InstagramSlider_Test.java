package task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task4.action.AbstractAction;
import task4.data.SliderData;
import task4.driver.DriverProvider;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import task4.steps.IncidentsNewsPageSteps;
import task4.steps.elements.*;

public class InstagramSlider_Test {
    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testStart() {

        //Открываем страницу новостей инцидентов
        IncidentsNewsPageSteps incidentsNewsPageSteps = new IncidentsNewsPageSteps(driverProvider.getDriver());
        incidentsNewsPageSteps.open();
        //Находим текстовое поле
        InstagramTextAreaSteps instagramTextAreaSteps = new InstagramTextAreaSteps(driverProvider.getDriver());
        incidentsNewsPageSteps.switchToWebElement(instagramTextAreaSteps.findInstagramTextArea());
        //Переключаемся к фрейму instagram
        InstagramIframeSteps instagramIframeSteps = new InstagramIframeSteps(driverProvider.getDriver());
        driverProvider.switchToFrame(instagramIframeSteps.findInstagramIframe());

        //Получаем url 1-ой instagram фотографии
        InstagramImageSteps instagramImageSteps = new InstagramImageSteps(driverProvider.getDriver());
        String Image1 = instagramImageSteps.getInstagramImageUrl();
        //Спускаемся к 1-ой фотографии, чтобы проверить работу слайдера
        InstagramSidecarSteps instagramSidecarSteps = new InstagramSidecarSteps(driverProvider.getDriver());
        AbstractAction action = new AbstractAction(driverProvider.getDriver());
        action.performWebElement(instagramSidecarSteps.findInstagramSidecar());

        //Проверяем наличие кнопки "Вправо" и нажимаем на нее
        SliderButtonSteps sliderButtonSteps1 = new SliderButtonSteps(driverProvider.getDriver());
        sliderButtonSteps1.isSliderButtonDisplayed(SliderData.Right);
        sliderButtonSteps1.clickButton(SliderData.Right);
        String Image2 = instagramImageSteps.getInstagramImageUrl();
        //Проверяем, что фотография поменялась
        instagramImageSteps.isInstagramImageNotSameAs(Image1);

        //Проверяем наличие кнопки "Влево" и нажимаем на нее, а также сравниваем url изображения с 1-ым и 2-ым
        SliderButtonSteps sliderButtonSteps2 = new SliderButtonSteps(driverProvider.getDriver());
        sliderButtonSteps2.isSliderButtonDisplayed(SliderData.Left);
        sliderButtonSteps2.clickButton(SliderData.Left);
        instagramImageSteps.isInstagramImageSameAs(Image1);
        instagramImageSteps.isInstagramImageNotSameAs(Image2);
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }
}
