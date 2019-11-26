package regression;

import base.TestBase;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class RequestOffer extends TestBase {

    @Test
    public void requestWithWrongName() {
//        driver.findElement(By.xpath("//*[contains(text(), ' Start Trial')]")).click();
//        delay(3);
//        driver.findElement(By.xpath("//*[contains(text(), 'Request an offer.')]")).click();
        driver.get("https://www.insightportal.io/subscribe/request-offer");
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/input")).sendKeys("A");
        delay(3);
        Assert.assertTrue(driver.findElements(By.className("help-block")).get(0).getText().equals("The first name field must be at least 2 characters."));
        Assert.assertFalse(driver.findElement(By.id("save-button")).isEnabled());
    }

    @Test
    public void requestWithWrongSurname() {
//        driver.findElement(By.xpath("//*[contains(text(), ' Start Trial')]")).click();
//        delay(3);
//        driver.findElement(By.xpath("//*[contains(text(), 'Request an offer.')]")).click();
        driver.get("https://www.insightportal.io/subscribe/request-offer");
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/input")).sendKeys("A");
        delay(3);
        Assert.assertTrue(driver.findElements(By.className("help-block")).get(1).getText().equals("The last name field must be at least 2 characters."));
        Assert.assertFalse(driver.findElement(By.id("save-button")).isEnabled());
    }

    @Test
    public void requestWithWrongEmail() {
        driver.get("https://www.insightportal.io/subscribe/request-offer");
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/input")).sendKeys("a@y.");
        Assert.assertTrue(driver.findElements(By.className("help-block")).get(2).getText().equals("The email field must be a valid email."));

    }

    @Test
    public void requestWithWrongPhone() {
        driver.get("https://www.insightportal.io/subscribe/request-offer");
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/input")).sendKeys("+48 531 055 94");
        Assert.assertTrue(driver.findElements(By.className("help-block")).get(3).getText().equals("Phone number is not a valid"));

    }

    @Test
    public void requestWithCorrectInputData() {
        User user = User.Tom;
        driver.get("https://www.insightportal.io/subscribe/request-offer");
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/input")).sendKeys(user.getName());
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/input")).sendKeys(user.getSurname());
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/input")).sendKeys(user.getEmail());
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/input")).sendKeys(user.getPhoneNumber());
        driver.findElement(By.id("save-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText().equals("Your request has been sent successfully."));

    }
}
