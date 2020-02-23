package regression;

import base.BaseTests;
import org.testng.annotations.Test;


public class CookiesBanner extends BaseTests {

    @Test
    public void validateBannerIsPresent(){
        homePage.checkCookiesBannerIsPresent();
    }
}
