package regression;

import base.BaseTests;
import org.junit.Test;

public class CookiesBanner extends BaseTests {

    @Test
    public void validateBannerIsPresent(){
        homePage.checkCookiesBannerIsPresent();
    }
}
