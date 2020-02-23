//package regression;
//
//import base.BaseTests;
//import base.User;
//import org.junit.Test;
//import pages.DashboardPage;
//import pages.LoginPage;
//import pages.TestAdvisorPage;
//
//public class TestAdvisor extends BaseTests {
//
//    @Test
//    public void validateAll44CountriesAreVisible(){
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        homePage.clickOnTools();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = homePage.clickOnTestAdvisor();
//        delay(2);
//        testAdvisorPage.clickOnDropDownBoxWithCountries();
//        delay(2);
//        testAdvisorPage.countCountries();
//    }
//
//    @Test
//    public void validateMarketSharesForMobileDevicesWeeks() throws InterruptedException {
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = dashboardPage.goToTestAdvisor();
//        delay(2);
//        testAdvisorPage.clickOnDropDownBoxWithCountries();
//        delay(2);
//        testAdvisorPage.clickOnSelectAll();
//        delay(2);
//        testAdvisorPage.closeListOfArticles();
//        delay(3);
//        testAdvisorPage.setStartDateWithCurrentDate();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("1");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("6");
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("15");
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//
//        dashboardPage.logOut();
//    }
//
//    @Test
//    public void validateOSSearchWorksProperly() throws InterruptedException {
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = dashboardPage.goToTestAdvisor();
//        delay(2);
//        testAdvisorPage.clickOnDropDownBoxWithCountries();
//        delay(2);
//        testAdvisorPage.clickOnSelectAll();
//        delay(2);
//        testAdvisorPage.closeListOfArticles();
//        delay(3);
//        testAdvisorPage.setStartDateWithCurrentDate();
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.changeSearchToOS();
//        delay(2);
//        testAdvisorPage.searchForOS("Android");
//        delay(2);
//        testAdvisorPage.validateSearchResultForOS("iOS");
//    }
//
//    @Test
//    public void validateDeviceSearchWorksProperly() throws InterruptedException {
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = dashboardPage.goToTestAdvisor();
//        delay(2);
//        testAdvisorPage.clickOnDropDownBoxWithCountries();
//        delay(2);
//        testAdvisorPage.clickOnSelectAll();
//        delay(2);
//        testAdvisorPage.closeListOfArticles();
//        delay(3);
//        testAdvisorPage.setStartDateWithCurrentDate();
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.searchForDevice("iphone xr");
//        delay(2);
//        testAdvisorPage.validateSearchResultForDevice("iPhone XR");
//    }
//
//    @Test
//    public void validateUserCanSetCurrentDateAsStartDate() throws InterruptedException {
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = dashboardPage.goToTestAdvisor();
//        delay(2);
//        testAdvisorPage.clickOnDropDownBoxWithCountries();
//        delay(2);
//        testAdvisorPage.clickOnSelectAll();
//        delay(2);
//        testAdvisorPage.closeListOfArticles();
//        delay(3);
//        testAdvisorPage.setStartDateWithFutureDate();
//        delay(4);
//        testAdvisorPage.clickOnCalculate();
//        delay(5);
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.setStartDateWithCurrentDate();
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.validateDateBoxContainsCurrentDate();
//    }
//
//    @Test
//    public void validatePredictionsContainAllMonths(){
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = dashboardPage.goToTestAdvisor();
//        delay(2);
//        testAdvisorPage.switchToMonth();
//        delay(2);
//        testAdvisorPage.validateAllMonthsArePresent();
//    }
//
//    @Test
//    public void validateMarketSharesForBrowserAreNotZero() throws InterruptedException{
//        User user = User.Tom;
//        homePage.dismissCookiesBanner();
//        LoginPage loginPage = homePage.clickOnLoginIcon();
//        loginPage.setCorrectLogin(user);
//        delay(1);
//        loginPage.setCorrectPassword(user);
//        delay(1);
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//        delay(2);
//        TestAdvisorPage testAdvisorPage = dashboardPage.goToTestAdvisor();
//        delay(2);
//        testAdvisorPage.switchToOnlineServices();
//        delay(2);
//        testAdvisorPage.clickOnDropDownBoxWithCountries();
//        delay(2);
//        testAdvisorPage.clickOnSelectAll();
//        delay(2);
//        testAdvisorPage.closeListOfArticles();
//        delay(3);
//        testAdvisorPage.setStartDateWithCurrentDate();
//        delay(2);
//        testAdvisorPage.switchToMonth();
//        testAdvisorPage.chooseWeekOrMonth("1");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("2");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("3");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("4");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("5");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("6");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//        testAdvisorPage.changeCalculation();
//        delay(2);
//        testAdvisorPage.chooseWeekOrMonth("7");
//        delay(2);
//        testAdvisorPage.clickOnCalculate();
//        delay(8);
//        testAdvisorPage.clickOnShowMoreUntilWholeTableIsExpanded();
//        delay(3);
//        testAdvisorPage.checkIfMarketSharesAreNotZero();
//    }
//}
