package regression;

import base.BaseTests;
import base.User;
import org.testng.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

public class Login extends BaseTests {

    @Test
    public void logInWithCorrectCredentials() throws Exception {
        User user = User.Tom;
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        loginPage.setCorrectPassword(user);
        delay(3);
        validationTest.captureScreenShots();
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        delay(3);
        Assert.assertTrue(dashboardPage.getUserBannerText().contains("Tom Haverford"), "User banner text is incorrect");
        delay(3);
        dashboardPage.logOut();
    }

    @Test
    public void logInWithWrongUsername() throws Exception {
        User user = User.Tom;
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setWrongLogin("tom76@yopmail.com");
        loginPage.setCorrectPassword(user);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        delay(3);
        validationTest.captureScreenShots();
        delay(3);
        Assert.assertTrue(loginPage.getErrorAlert().contains("Invalid login or password."), "Error alert text is incorrect");
        delay(3);
        dashboardPage.logOut();
    }

    @Test
    public void logInWithWrongPassword() throws Exception{
        User user = User.Tom;
        LoginPage loginPage = homePage.clickOnLoginIcon();
        delay(3);
        loginPage.setCorrectLogin(user);
        loginPage.setWrongPassword("3tomtomtom");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        delay(3);
        validationTest.captureScreenShots();
        delay(3);
        Assert.assertTrue(loginPage.getErrorAlert().contains("Invalid login or password."), "Error alert text is incorrect");
        delay(3);
        dashboardPage.logOut();
    }
}
