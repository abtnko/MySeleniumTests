package regression;

import base.BaseTests;
import org.junit.Test;
import pages.StartTrialPage;
import java.io.IOException;

public class StartTrial extends BaseTests {

//    @Test
//    Unable to run because of reCaptcha
    public void startTrialWithExistingCredentials() throws IOException {
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setEmail("tom@");
        startTrialPage.checkErrorMessageForEmail();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void startTrialWithWrongCredentials() throws IOException {
        String wrongPassword = "aaaa";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForPassword();
        delay(3);
        validationTest.captureScreenShots();
    }

}
