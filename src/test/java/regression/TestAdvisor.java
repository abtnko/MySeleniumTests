package regression;

import base.BaseTests;
import base.User;
import org.junit.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TestAdvisorPage;

public class TestAdvisor extends BaseTests {

    @Test
    public void validateAll44CountriesAreVisible(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        delay(2);
        homePage.clickOnTools();
        delay(2);
        TestAdvisorPage testAdvisorPage = homePage.clickOnTestAdvisor();
        delay(2);
        testAdvisorPage.clickOnDropDownBoxWithCountries();
        delay(2);
        testAdvisorPage.countCountries();
    }

    @Test
    public void validateCombinationsForMobileDevicesAreLogical(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        delay(2);
        homePage.clickOnTools();
        delay(2);
        TestAdvisorPage testAdvisorPage = homePage.clickOnTestAdvisor();
        delay(2);
        testAdvisorPage.clickOnDropDownBoxWithCountries();
        delay(2);
        testAdvisorPage.clickOnSelectAll();
        testAdvisorPage.clickOnDropDownBoxWithCountries();
        testAdvisorPage.setStartDate();
        testAdvisorPage.clickOnCalculate();
        delay(5);
    }
}
