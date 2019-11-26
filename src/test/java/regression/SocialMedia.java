package regression;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.ArrayList;

public class SocialMedia extends TestBase {
    @Test
    public void checkFacebook(){
        driver.findElement(By.xpath("//img[@alt='Facebook']")).click();
        delay(5);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String fb =driver.getTitle();
        System.out.println(fb );
        Assert.assertTrue(fb.contains("InsightPortal - Home | Facebook"));
    }

    @Test
    public void checkYouTube(){
        driver.findElement(By.xpath("//img[@alt='Youtube']")).click();
        delay(5);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String fb =driver.getTitle();
        System.out.println(fb );
        Assert.assertTrue(fb.contains("InsightPortal - YouTube"));
    }

    @Test
    public void checkTwitter(){
        driver.findElement(By.xpath("//img[@alt='Twitter']")).click();
        delay(5);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String fb =driver.getTitle();
        System.out.println(fb );
        Assert.assertTrue(fb.contains("(@InsightPortal) | Twitter"));
    }

    @Test
    public void checkLinkedIn(){
        driver.findElement(By.xpath("//img[@alt='LinkedIn']")).click();
        delay(5);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String fb =driver.getTitle();
        System.out.println(fb );
        Assert.assertTrue(fb.contains("InsightPortal | LinkedIn"));
    }
}
