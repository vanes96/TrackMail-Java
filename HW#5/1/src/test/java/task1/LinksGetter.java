package task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LinksGetter {
    private WebDriver driver;
    private String pageURL;

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        pageURL = System.getProperty("pageURL");
    }

    @Test
    public void getLinks() throws IOException {
        driver.get(pageURL);

        // Получаем все ссылки на странице с заданным pageURL
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // Распределяем все ссылки по внутренним и внешним в два списка
        List<WebElement> internalLinks = allLinks.stream().filter(link -> link.getAttribute("href").contains(pageURL)
                                                                  || !link.getAttribute("href").contains("http")).collect(Collectors.toList());
        List<WebElement> externalLinks = allLinks.stream().filter(link -> !internalLinks.contains(link)).collect(Collectors.toList());

        // Записываем сгруппированные ссылки в файл с именем fileName
        writeLinks(System.getProperty("fileName"), internalLinks, externalLinks);
    }

    private void writeLinks(String fileName, List<WebElement> internalLinks, List<WebElement> externalLinks) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        // При записи относительной внутренней ссылки в файл добавляется домен в ее начало
        writer.write(String.format("Внутренние ссылки (найдено %d):\n", internalLinks.size()));
        String domain;
        for (WebElement internalLink : internalLinks) {
            domain = !internalLink.getAttribute("href").contains("http[s]")?pageURL:"";
            writer.write(domain + internalLink.getAttribute("href") + "\n");
        }

        writer.write(String.format("\n----------------------------\nВнешние ссылки (найдено %d):\n", externalLinks.size()));
        for (WebElement externalLink : externalLinks)
            writer.write(externalLink.getAttribute("href") + "\n");

        // Закрываем FileWriter
        writer.close();
    }

    @After
    public void close() throws NullPointerException {
        driver.quit();
        pageURL = null;
    }
}
