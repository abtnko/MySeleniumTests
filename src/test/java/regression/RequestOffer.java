//package regression;
//
//import base.BaseTests;
//import base.User;
//import org.junit.Test;
//import pages.RequestOfferPage;
//import pages.StartTrialPage;
//
//import java.io.IOException;
//
//public class RequestOffer extends BaseTests {
//
//    @Test
//    public void requestWithWrongName() throws IOException {
//        User userLetters = User.FakeWithLetters;
//        User userDigits = User.FakeWithDigits;
//        RequestOfferPage requestOfferPage = homePage.goToRequestOfferPage();
//        delay(2);
//        requestOfferPage.setFirstName(userLetters);
//        delay(2);
//        requestOfferPage.checkErrorMessageForInvalidFirstNameLetters();
//        requestOfferPage.setFirstName(userDigits);
//        delay(2);
//        requestOfferPage.checkErrorMessageForInvalidFirstNameDigits();
//        validationTest.captureScreenShots();
//    }
//
//    @Test
//    public void requestWithWrongSurname() throws IOException {
//        User userLetters = User.FakeWithLetters;
//        User userDigits = User.FakeWithDigits;
//        RequestOfferPage requestOfferPage = homePage.goToRequestOfferPage();
//        delay(2);
//        requestOfferPage.setLastName(userLetters);
//        delay(2);
//        requestOfferPage.checkErrorMessageForInvalidLastNameLetters();
//        requestOfferPage.setLastName(userDigits);
//        delay(2);
//        requestOfferPage.checkErrorMessageForInvalidLastNameDigits();
//        validationTest.captureScreenShots();
//    }
//
//    @Test
//    public void requestWithWrongEmail() throws IOException {
//        User userLetters = User.FakeWithLetters;
//        RequestOfferPage requestOfferPage = homePage.goToRequestOfferPage();
//        delay(2);
//        requestOfferPage.setEmail(userLetters);
//        delay(2);
//        requestOfferPage.checkErrorMessageForInvalidEmail();
//        validationTest.captureScreenShots();
//    }
//
//    @Test
//    public void requestWithWrongPhone() throws IOException {
//        User userLetters = User.FakeWithLetters;
//        RequestOfferPage requestOfferPage = homePage.goToRequestOfferPage();
//        delay(2);
//        requestOfferPage.setPhoneNumber(userLetters);
//        delay(2);
//        requestOfferPage.checkErrorMessageForInvalidPhoneNumber();
//        validationTest.captureScreenShots();
//    }
//
//    @Test
//    public void requestWithCorrectInputData() throws IOException {
//        User user = User.Tom;
//        RequestOfferPage requestOfferPage = homePage.goToRequestOfferPage();
//        delay(2);
//        requestOfferPage.setFirstName(user);
//        requestOfferPage.setLastName(user);
//        requestOfferPage.setEmail(user);
//        requestOfferPage.setPhoneNumber(user);
//        requestOfferPage.clickOnRequestOfferButton();
//        delay(3);
//        requestOfferPage.checkPresenceOfPopUp();
//        delay(2);
//        validationTest.captureScreenShots();
//
//    }
//
//
//}
