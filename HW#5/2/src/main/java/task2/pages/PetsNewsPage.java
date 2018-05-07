package task2.pages;

import task2.navigation.Page;
import task2.navigation.UrlPattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.stream.Collectors;

@Page("/")
@UrlPattern("news")
public class PetsNewsPage extends AbstractPage {

    public PetsNewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".pypo-item__title")
    private List<WebElement> articlesTitles;

    /**
     * Возвращает названия статей на странице
     * @return названия статей
     */
    public List<String> getAllArticlesTitles() {
        return articlesTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    //============================================================================================

    public boolean isArticlesTitlesIncreased(List<String> titles) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getAllArticlesTitles().size() > titles.size();
            }
        };
        return waitTools.waitForCondition(condition);
    }

    public boolean isArticlesTitlesContainPrevious(List<String> titles) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getAllArticlesTitles().containsAll(titles);
            }
        };
        return waitTools.waitForCondition(condition);
    }
}
