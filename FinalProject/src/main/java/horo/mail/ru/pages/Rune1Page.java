package horo.mail.ru.pages;

import horo.mail.ru.navigation.Page;
import horo.mail.ru.navigation.UrlPattern;
import org.openqa.selenium.WebDriver;

@Page("/runes/tile/1/")
@UrlPattern("runes/tile/1")
public class Rune1Page extends AbstractPage {

    public Rune1Page(WebDriver driver) {
        super(driver);
    }
}

