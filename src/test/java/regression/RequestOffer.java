package regression;

import base.BaseTests;
import base.User;
import org.junit.Test;
import pages.RequestOfferPage;
import pages.StartTrialPage;

import java.io.IOException;

public class RequestOffer extends BaseTests {

    @Test
    public void requestWithWrongName() throws IOException {
        User user = User.Fake;
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        RequestOfferPage requestOfferPage = startTrialPage.clickOnRequestOffer();
        delay(2);
        requestOfferPage.setFirstName(user);
        delay(2);
        requestOfferPage.checkErrorMessageForInvalidFirstName();
        validationTest.captureScreenShots();
    }

    @Test
    public void requestWithWrongSurname() throws IOException {
        User user = User.Fake;
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        RequestOfferPage requestOfferPage = startTrialPage.clickOnRequestOffer();
        delay(2);
        requestOfferPage.setLastName(user);
        delay(2);
        requestOfferPage.checkErrorMessageForInvalidLastName();
        validationTest.captureScreenShots();
    }

    @Test
    public void requestWithWrongEmail() throws IOException {
        User user = User.Fake;
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        RequestOfferPage requestOfferPage = startTrialPage.clickOnRequestOffer();
        delay(2);
        requestOfferPage.setEmail(user);
        delay(2);
        requestOfferPage.checkErrorMessageForInvalidEmail();
        validationTest.captureScreenShots();
    }

    @Test
    public void requestWithWrongPhone() throws IOException {
        User user = User.Fake;
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        RequestOfferPage requestOfferPage = startTrialPage.clickOnRequestOffer();
        delay(2);
        requestOfferPage.setPhoneNumber(user);
        delay(2);
        requestOfferPage.checkErrorMessageForInvalidPhoneNumber();
        validationTest.captureScreenShots();
    }

    @Test
    public void requestWithCorrectInputData() throws IOException {
        User user = User.Tom;
        StartTrialPage startTrialPage = homePage.clickOnStartTrial();
        RequestOfferPage requestOfferPage = startTrialPage.clickOnRequestOffer();
        delay(2);
        requestOfferPage.setFirstName(user);
        requestOfferPage.setLastName(user);
        requestOfferPage.setEmail(user);
        requestOfferPage.setPhoneNumber(user);
        requestOfferPage.clickOnRequestOfferButton();
        delay(3);
        requestOfferPage.checkPresenceOfPopUp();
        delay(2);
        validationTest.captureScreenShots();

    }
}
