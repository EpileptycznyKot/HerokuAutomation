package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAuthorisation {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasicAuthorisation(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
