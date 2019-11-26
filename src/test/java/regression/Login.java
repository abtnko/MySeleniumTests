package regression;

import base.TestBase;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

public class Login extends TestBase {

    @Test
    public void logInWithCorrectCredentials(){
        User user = User.Tom;
        driver.findElement(By.id("logIn-button")).click();
        delay(3);
        driver.findElement(By.id("input-logIn")).sendKeys(user.getEmail());
        driver.findElement(By.id("input-password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
        delay(5);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"banner-name\"]/span")).getText().equals("Tom Haverford"));
    }

    @Test
    public void logInWithWrongUsername() {
        User user = User.Tom;
        driver.findElement(By.id("logIn-button")).click();
        delay(3);
        driver.findElement(By.id("input-logIn")).sendKeys("tom.h@yopmail.com");
        driver.findElement(By.id("input-password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
        delay(3);
        Assert.assertTrue(driver.findElement(By.className("p-incorrect-password")).getText().equals("Invalid logIn or password."));
    }

    @Test
    public void logInWithWrongPassword(){
        User user = User.Tom;
        driver.findElement(By.id("logIn-button")).click();
        delay(3);
        driver.findElement(By.id("input-logIn")).sendKeys(user.getEmail());
        driver.findElement(By.id("input-password")).sendKeys("1111AAAA");
        driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
        delay(3);
        Assert.assertTrue(driver.findElement(By.className("p-incorrect-password")).getText().equals("Invalid logIn or password."));
    }
}
