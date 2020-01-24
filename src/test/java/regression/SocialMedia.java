package regression;

import base.BaseTests;
import org.junit.Test;
import pages.SocialMediaPages;



public class SocialMedia extends BaseTests {


    @Test
    public void checkFacebook() throws Exception{
        SocialMediaPages socialMediaPages = homePage.clickOnFacebookLink();
        delay(5);
        socialMediaPages.checkFacebookPage();
    }

//    @Test
    public void checkYouTube() {
        SocialMediaPages socialMediaPages = homePage.clickOnYoutubeLink();
        delay(5);
        socialMediaPages.checkYoutubePage();
    }

    @Test
    public void checkTwitter() throws Exception{
        SocialMediaPages socialMediaPages = homePage.clickOnTwitterLink();
        delay(5);
        socialMediaPages.checkTwitterPage();

    }

//    @Test
    public void checkLinkedIn() throws  Exception{
        SocialMediaPages socialMediaPages = homePage.clickOnLinkedInLink();
        delay(5);
        socialMediaPages.checkLinkedInPage();
    }


}
