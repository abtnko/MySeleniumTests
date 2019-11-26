package base;

import model.User;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver = new SafariDriver();


    @BeforeClass
    public static void openSafari() {
        driver.get("https://www.insightportal.io");
        driver.manage().window().fullscreen();
        delay(3);

    }


    @After
    public void logOut() {
        driver.findElement(By.xpath("//span[contains(text(), 'Log out')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(), 'Login')]")).isDisplayed());

    }

    @AfterClass
    public static void closeSafari () {
        driver.quit();
    }

    public static void delay (int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch(InterruptedException ex) {

        }
    }

    public void logIn(User user) {
        driver.findElement(By.xpath("//span[contains(text(), 'Login')]")).click();
        delay(3);
        driver.findElement(By.id("input-login")).clear();
        driver.findElement(By.id("input-login")).sendKeys(user.getEmail());
        driver.findElement(By.id("input-password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
        delay(5);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"banner-name\"]/span")).getText().equals(user.getFullName()));

    }

}
