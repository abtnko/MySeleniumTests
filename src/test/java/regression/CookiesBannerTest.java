package regression;

import base.BaseTests;
import org.testng.annotations.Test;


public class CookiesBannerTest extends BaseTests {

    @Test(priority = 2)
    public void validateBannerIsPresent(){
        homePage.checkCookiesBannerIsPresent();
    }
}
