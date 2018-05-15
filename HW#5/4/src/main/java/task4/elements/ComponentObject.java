package task4.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task4.navigation.PageObject;

import static org.junit.Assert.assertTrue;

/**
 * Абстрактный класс статического компонента
 */
public abstract class ComponentObject extends PageObject {

    public ComponentObject(WebDriver driver) {
        super(driver);
    }

    {
        componentValidate();
    }

    /**
     * Валидация компонента
     */
    private void componentValidate() {
        Class<?> componentClass = super.getClass();
        if(componentClass.isAnnotationPresent(Component.class)) {

            Component component = componentClass.getAnnotation(Component.class);

            assertTrue(String.format("Компонент %s отсутствует на странице", componentClass.getName()),
                    waitTools.waitForConditionCheckExistence(
                            ExpectedConditions.presenceOfElementLocated(By.xpath(component.xpath()))));
        }
    }
}