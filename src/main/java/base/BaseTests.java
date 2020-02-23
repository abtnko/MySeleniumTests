package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.*;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;
    protected static ValidationTest validationTest;


    @BeforeMethod
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/macbook/MySeleniumTests/binaries/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.insightportal.io/");
//        driver.manage().window().fullscreen();
        delay(4);

        homePage = new HomePage(driver);
        validationTest = new ValidationTest(driver);

    }

//    @Before
//    public void fullScreen(){
////        driver.navigate().refresh();
//        driver.manage().window().fullscreen();
//        delay(3);
//    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

//    @AfterClass
//    public static void finishTest(){
//        driver.quit();
//    }

    public void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {

        }
    }



}

