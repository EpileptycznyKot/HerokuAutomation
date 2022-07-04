package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import links.Links;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StartPage;

import java.util.Map;

public class Main {

    private static WebDriver driver;

    @BeforeSuite
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void resetConditions() {
        driver.get(Links.START_PAGE);
        driver.manage().window().maximize();
    }

    @Test
    public void debugTest() {

    }

    @Test
    void testAllLinks(){
        StartPage s = new StartPage(driver);
        Map<String, String> websites = s.getWebsitesWithLinks();
        for(String website : websites.keySet()){
            driver.get(websites.get(website));
            //Assert.assertEquals(website, driver.getTitle());
        }
    }

    @AfterTest
    public void cleanAfterTest() {
        driver.quit();
    }
}
