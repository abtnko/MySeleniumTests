package regression;

import base.TestBase;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class ChangePassword extends TestBase {

//    @Test
    public void changeInCorrectFormat(){
        User user = User.Tom;
        logIn(user);
        String newPassword = "TOMtomTOMx3";
        driver.findElement(By.xpath("//*[@id=\"account-container\"]/button[1]")).click();
        delay(5);
        driver.findElements(By.name("password")).get(0).sendKeys(user.getPassword());
        driver.findElements(By.name("password")).get(1).sendKeys(newPassword);
        driver.findElements(By.name("password")).get(2).sendKeys(newPassword);
        driver.findElement(By.id("save-button")).click();
        delay(5);
        driver.findElement(By.xpath("//span[contains(text(), 'Log out')]")).click();
        delay(3);
//        Checking if password is updated
        driver.findElement(By.id("input-logIn")).sendKeys("tom.h@yopmail.com");
        driver.findElement(By.id("input-password")).sendKeys(newPassword);
        driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
        delay(5);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"container\"]/form/div[4]/p")).getText().equals("Tom Haverford"));
    }

    @Test
    public void changeOnlyLetters(){
        User user = User.Tom;
        logIn(user);
        String newPassword = "TOMtomTOM";
        driver.findElement(By.xpath("//*[@id=\"account-container\"]/button[1]")).click();
        delay(5);
        driver.findElements(By.name("password")).get(0).sendKeys(user.getPassword());
        driver.findElements(By.name("password")).get(1).sendKeys(newPassword);
        driver.findElements(By.name("password")).get(2).sendKeys(newPassword);
        delay(5);
        Assert.assertTrue(driver.findElement(By.className("p-incorrect-password")).getText().equals("\n" +
                "        One number required.\n" +
                "      "));
    }

    @Test
    public void changeOnlyDigits(){
        User user = User.Tom;
        logIn(user);
        String newPassword = "11112222";
        driver.findElement(By.xpath("//*[@id=\"account-container\"]/button[1]")).click();
        delay(5);
        driver.findElements(By.name("password")).get(0).sendKeys(user.getPassword());
        driver.findElements(By.name("password")).get(1).sendKeys(newPassword);
        driver.findElements(By.name("password")).get(2).sendKeys(newPassword);
        delay(5);
        Assert.assertTrue(driver.findElement(By.className("p-incorrect-password")).getText().equals("\n" +
                "        One lowercase letter required.\n" +
                "      "));
    }

    @Test
    public void changeLessThan8Characters(){
        User user = User.Tom;
        logIn(user);
        String newPassword = "1111";
        driver.findElement(By.xpath("//*[@id=\"account-container\"]/button[1]")).click();
        delay(5);
        driver.findElements(By.name("password")).get(0).sendKeys(user.getPassword());
        driver.findElements(By.name("password")).get(1).sendKeys(newPassword);
        driver.findElements(By.name("password")).get(2).sendKeys(newPassword);
        delay(5);
        Assert.assertTrue(driver.findElement(By.className("p-incorrect-password")).getText().equals("\n" +
                "        New password needs at least 8 characters.\n" +
                "      "));

    }

    @Test
    public void changeWhenTwoDifferent(){
        User user = User.Tom;
        logIn(user);
        String firstNew = "1111";
        String secondNew = "2222";
        driver.findElement(By.xpath("//*[@id=\"account-container\"]/button[1]")).click();
        delay(5);
        driver.findElements(By.name("password")).get(0).sendKeys(user.getPassword());
        driver.findElements(By.name("password")).get(1).sendKeys(firstNew);
        driver.findElements(By.name("password")).get(2).sendKeys(secondNew);
        delay(5);
        assertEquals("\n" +
                "        New password does not match the confirm password.\n" +
                "      ", driver.findElement(By.className("p-incorrect-password")).getText());
//        assertTrue(driver.findElement(By.id("save-button")).isEnabled());
    }

}
