package base;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import pages.HomePage;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;
    protected static ValidationTest validationTest;


    @Before
    public void startTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("maxInstances", "1");

        driver = new SafariDriver(SafariOptions.fromCapabilities(caps));
        driver.get("https://www.insightportal.io/");
        driver.manage().window().fullscreen();
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

    @After
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

