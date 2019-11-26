package regression;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class PaidServices extends TestBase {
    @Test
    public void paidServiceNotVisibleForNotLoggedUser() {
        driver.findElement(By.className("tools")).click();
        delay(3);
        driver.findElement(By.xpath("//div[contains(text(), 'TestAdvisor')]")).click();
        delay(3);
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(), 'logIn')]")).isDisplayed());
    }
}
