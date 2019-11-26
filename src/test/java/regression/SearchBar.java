package regression;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchBar extends TestBase {
    @Test
    public void validateTitlesInList(){
        String searchedWord = "iOS";
        driver.findElement(By.id("searchbar")).sendKeys(searchedWord);
        driver.findElement(By.xpath("//*[@id=\"search-container\"]/input")).click();
        delay(5);
        List<WebElement> allArticles = driver.findElements(By.id("child-of-container"));
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(searchedWord));
        }

    }
}
