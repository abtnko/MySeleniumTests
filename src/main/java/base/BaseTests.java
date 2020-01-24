package base;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;
    protected static ValidationTest validationTest;


    @BeforeClass
    public static void startTest() {
        driver = new SafariDriver();
        driver.get("https://beta.insightportal.io/");
        delay(2);
        homePage = new HomePage(driver);
        validationTest = new ValidationTest(driver);

    }

    @Before
    public void fullScreen(){
//        driver.navigate().refresh();
        driver.manage().window().fullscreen();
        delay(3);
    }

    @AfterClass
    public static void finishTest(){
        driver.quit();
    }

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {

        }
    }



}

