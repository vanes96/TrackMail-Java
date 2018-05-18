package horo.mail.ru.pages;

import horo.mail.ru.navigation.Page;
import horo.mail.ru.navigation.PageObject;
import horo.mail.ru.navigation.UrlPattern;
import horo.mail.ru.tools.WaitTools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public abstract class AbstractPage  extends PageObject{

    public AbstractPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //waitTools = new WaitTools(getDriver());
    }
    @FindBy(xpath = "//h1")
    private WebElement header;

    public void clickButton(WebElement button){
        button.click();
    }

    /**
     * Возвращает заголовок страницы
     * @return заголовок страницы
     */
    public String getHeader() {
        return header.getText();
    }

    /**
     * JavaScript Executor
     * @return executor
     */
    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    /**
     * Открывает страницу
     */
    public void open() {
        getDriver().get(getPageUrl());
    }
}

