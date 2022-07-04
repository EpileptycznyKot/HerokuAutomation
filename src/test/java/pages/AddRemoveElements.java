package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddRemoveElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddRemoveElements(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickAddElement(){
        addButton.click();
    }

    public void clickDeleteElement(){
        deleteButton.click();
    }

    public boolean checkIfDeleteButtonIsPresent(){
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='elements']/button"));
        return !buttons.isEmpty();
    }

    @FindBy(xpath = "//div[@class='example']/button")
    WebElement addButton;

    @FindBy(xpath = "//div[@id='elements']/button")
    WebElement deleteButton;
}
