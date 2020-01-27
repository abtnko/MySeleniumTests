package regression;


import base.BaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

public class PaidServices extends BaseTests {

    @Test
    public void paidServiceNotVisibleForNotLoggedUser() {
        try {
            homePage.clickOnTools();
        } catch (Exception e){
            //        homePage.openMenu();
            delay(2);
            homePage.clickOnTools();
        }
        LoginPage loginPage = homePage.tryToAccessTestAdvisor();
        delay(2);
        loginPage.checkLoginWindowIsPresent();
        delay(2);
        //        homePage.openMenu();
        homePage.tryToAccessReleaseAdvisor();
        delay(2);
        loginPage.checkLoginWindowIsPresent();
        delay(2);
        //        homePage.openMenu();
        homePage.tryToAccessStatistics();
        delay(2);
        loginPage.checkLoginWindowIsPresent();
        delay(2);
        //        homePage.openMenu();
        homePage.tryToAccessCloudAdvisor();
        delay(2);
        loginPage.checkLoginWindowIsPresent();
    }
}
