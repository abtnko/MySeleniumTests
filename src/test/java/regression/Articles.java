package regression;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Articles extends TestBase {

    @Test
    public void checkSubcategoryFilter(){
        driver.findElement(By.className("news")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'All News')]")).click();
        delay(3);
        driver.findElement(By.id("ch-all")).click();
        driver.findElement(By.id("adobe")).click();
        driver.findElement(By.id("filter-button")).click();
        delay(3);
        String searchedWord = "Adobe";
        List<WebElement> allArticles = driver.findElements(By.id("child-of-container"));
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(searchedWord));
            }
    }
}
