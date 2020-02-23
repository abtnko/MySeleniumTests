//package regression;
//
//import base.BaseTests;
//import base.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import pages.DashboardPage;
//import pages.LoginPage;
//import pages.MyAccountPage;
//
//import java.io.IOException;
//
//import static org.junit.Assert.*;
//
//public class ChangePassword extends BaseTests {
//
//    @Test
//    public void changeInCorrectFormat() throws IOException {
//        User user = User.Tom;
//        String newPassword = "3xtomTOMtom";
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordString(newPassword);
//        myAccountPage.confirmNewPasswordString(newPassword);
//        myAccountPage.clickOnSaveButton();
//        delay(2);
//        myAccountPage.checkPresenceOfPopUp();
//        validationTest.captureScreenShots();
//        myAccountPage.closePopUp();
//        delay(2);
//        dashboardPage.logOut();
////        Checking if new password has been recorded in database
//        homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setChangedPassword(newPassword);
//        delay(2);
//        loginPage.clickLoginButton();
//        delay(2);
////        Changing password back to permanent one
//        dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordString(newPassword);
//        myAccountPage.enterNewPasswordUser(user);
//        myAccountPage.confirmNewPasswordUser(user);
//        myAccountPage.clickOnSaveButton();
//        delay(2);
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void changeOnlyLetters() throws IOException {
//        User user = User.Tom;
//        String newPassword = "bbbbbbbB";
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordString(newPassword);
//        myAccountPage.confirmNewPasswordString(newPassword);
//        delay(2);
//        myAccountPage.checkAlertTextForLetters();
//        validationTest.captureScreenShots();
//        delay(2);
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void changeOnlyDigits() throws IOException {
//        User user = User.Tom;
//        String newPassword = "11111111";
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordString(newPassword);
//        myAccountPage.confirmNewPasswordString(newPassword);
//        myAccountPage.checkAlertTextForDigits();
//        delay(3);
//        validationTest.captureScreenShots();
//        delay(2);
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void changeLessThan8Characters() throws IOException {
//        User user = User.Tom;
//        String newPassword = "bbb111";
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordString(newPassword);
//        myAccountPage.confirmNewPasswordString(newPassword);
//        myAccountPage.checkAlertTextForCharacters();
//        validationTest.captureScreenShots();
//        delay(2);
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void changeWhenTwoDifferent() throws IOException {
//        User user = User.Tom;
//        String newPassword = "bbb111BBB";
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordString(newPassword);
//        myAccountPage.confirmNewPasswordUser(user);
//        myAccountPage.checkAlertTextForMismatch();
//        validationTest.captureScreenShots();
//        delay(2);
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void changeWhenMoreThanFifty() throws Exception {
//        User user = User.Tom;
//        String newPassword = "aaa333AAAaaaa333AAAaaaa333AAAaaaa333AAAaaaa333AAAaa";
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordString(newPassword);
//        myAccountPage.confirmNewPasswordString(newPassword);
//        myAccountPage.checkAlertTextForMoreThanFifty();
//        validationTest.captureScreenShots();
//        delay(2);
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void changeToSameAsOldOne() throws Exception {
//        User user = User.Tom;
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        loginPage.setCorrectPassword(user);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(3);
//        MyAccountPage myAccountPage = dashboardPage.goToMyAccount();
//        myAccountPage.enterCurrentPasswordUser(user);
//        myAccountPage.enterNewPasswordUser(user);
//        myAccountPage.confirmNewPasswordUser(user);
//        myAccountPage.checkAlertTextForSamePasswordAsOld();
//        validationTest.captureScreenShots();
//        delay(2);
//        dashboardPage.logOut();
//    }
//}
