package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import links.Links;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class BasicAuthoristaionTest {
    private static WebDriver driver;

    @BeforeSuite
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void resetConditions() {
        driver.get(Links.BASIC_AUTHORISATION);
        driver.manage().window().maximize();
    }

    @Test
    public void addAndDeleteElementOnceTest() {
        String mainWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        driver.switchTo().window(it.next());

    }

    @AfterTest
    public void cleanAfterTest() {
        driver.quit();
    }
}
