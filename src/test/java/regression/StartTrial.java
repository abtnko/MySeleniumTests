package regression;

import base.TestBase;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class StartTrial extends TestBase {

    @Test
    public void startTrialWithExistingCredentials() {
        User user = User.Tom;
        driver.findElement(By.xpath("//*[contains(text(), ' Start Trial')]")).click();
        delay(5);
        driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[1]/input")).sendKeys(user.getEmail());
        driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[2]/input")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[3]/button")).click();
        delay(5);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"swal2-content\"]")).getText().equals("User with such email already exist."));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
    }

    @Test
    public void startTrialWithWrongCredentials() {
        User user = User.Tom;
        driver.findElement(By.xpath("//*[contains(text(), ' Start Trial')]")).click();
        delay(5);
        driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[1]/input")).sendKeys("t@");
        driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[2]/input")).sendKeys("1234");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[1]/span")).getText().equals("The email address field must be a valid email."));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[2]/p")).getText().equals("New password needs at least 8 characters."));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/div[1]/form/div[3]/button")).isEnabled());
    }

    @Test
    public void startTrialWithCorrectCredentials() {
        User user = User.Tom;
//        Almost Ready screen
        driver.findElement(By.name("firstName")).sendKeys(user.getName());
        driver.findElement(By.name("lastName")).sendKeys(user.getSurname());
        driver.findElement(By.name("company")).sendKeys(user.getCompany());
        driver.findElement(By.name("phone_number")).sendKeys(user.getPhoneNumber());
        driver.findElement(By.xpath("//*[@id=\"logIn-container\"]/div/div/div/form/div[5]/button")).click();
        delay(5);
//        Add Assert.assert Account activated
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
    }
}
