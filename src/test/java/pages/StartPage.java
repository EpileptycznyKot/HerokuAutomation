package pages;

import helpers.UrlHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    @FindBy(xpath = "//ul/li/a")
    List<WebElement> allLinksToExamples;

    @FindBy(xpath = "//a")
    List<WebElement> allLinks;



    public Map<String, String> getWebsitesWithLinks(){
        Map<String, String> pairs = new HashMap<>();
        List<String> links = getURLFromAnchors();
        for(String link : links){

            pairs.put(UrlHelper.getLastPartOfUrl(link), link);

        }
        return pairs;
    }

    private List<String> getURLFromAnchors(){
        return allLinksToExamples
                .stream()
                .map(e -> e.getAttribute("href"))
                .collect(Collectors.toList());
    }


}
