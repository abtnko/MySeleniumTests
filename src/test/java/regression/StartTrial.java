package regression;

import base.BaseTests;
import base.User;
import org.junit.Test;
import pages.StartTrialPage;
import java.io.IOException;

public class StartTrial extends BaseTests {

    @Test
    public void setPasswordLessEightCharacters() throws IOException {
        String wrongPassword = "aaaa";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForLessEight();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setPasswordMoreFiftyCharacters() throws IOException {
        String wrongPassword = "aaa333AAAaaaa333AAAaaaa333AAAaaaa333AAAaaaa333AAAaa";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForMoreFifty();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setPasswordLowercaseLetters() throws IOException {
        String wrongPassword = "aaaaaaaa";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForLowercaseLetters();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setPasswordUppercaseLetters() throws IOException {
        String wrongPassword = "AAAAAAAA";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForUppercaseLetters();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setPasswordOnlyLetters() throws IOException {
        String wrongPassword = "aaaaAAAA";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForOnlyLetters();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setPasswordOnlyDigits() throws IOException {
        String wrongPassword = "11122233";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(wrongPassword);
        startTrialPage.confirmPassword(wrongPassword);
        startTrialPage.checkErrorMessageForOnlyDigits();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setInvalidEmail() throws IOException {
        User user = User.FakeWithLetters;
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setEmail(user);
        startTrialPage.checkErrorMessageForInvalidEmail();
        delay(3);
        validationTest.captureScreenShots();
    }

    @Test
    public void setNotMatchingPasswords() throws IOException {
        String pass1 = "1122ffFF";
        String pass2 = "1133ffFF";
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        delay(3);
        startTrialPage.setPassword(pass1);
        startTrialPage.confirmPassword(pass2);
        startTrialPage.checkErrorMessageForNotMatchingPasswords();
        delay(3);
        validationTest.captureScreenShots();
    }

}
