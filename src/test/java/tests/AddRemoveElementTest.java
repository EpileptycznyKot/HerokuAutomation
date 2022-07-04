package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import links.Links;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddRemoveElements;

public class AddRemoveElementTest {
    private static WebDriver driver;

    @BeforeSuite
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void resetConditions() {
        driver.get(Links.ADD_REMOVE_ELEMENTS_PAGE);
        driver.manage().window().maximize();
    }

    @Test
    public void addAndDeleteElementOnceTest() {
        AddRemoveElements page = new AddRemoveElements(driver);
        page.clickAddElement();
        page.clickDeleteElement();
    }


    @Test
    void andAndDeleteMultipleTimes(){
        AddRemoveElements page = new AddRemoveElements(driver);
        for(int i=0; i<50;i++){
            page.clickAddElement();
        }
        for(int i=0; i<50;i++) {
            page.clickDeleteElement();
        }
        Assert.assertFalse(page.checkIfDeleteButtonIsPresent(), "Delete button should not be visble or present in DOM now!");
    }

    @AfterTest
    public void cleanAfterTest() {
        driver.quit();
    }
}
