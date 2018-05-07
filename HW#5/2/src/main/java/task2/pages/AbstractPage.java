package task2.pages;

import task2.navigation.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage extends PageObject {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement header;

    /**
     * Возвращает заголовок страницы
     * @return заголовок страницы
     */
    public String getPageHeader() {
        return header.getText();
    }

    /**
     * Открывает страницу
     */
    public void open() {
        getDriver().get(getPageUrl());
    }
}
