package regression;


import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PaidServicesTest extends BaseTests {

    @Test(priority = 1)
    public void paidServiceNotVisibleForNotLoggedUser() {
        try {
            homePage.clickOnTools();
        } catch (Exception e){
                    homePage.openMenu();
            delay(2);
            homePage.clickOnTools();
        }
        LoginPage loginPage = homePage.tryToAccessTestAdvisor();
        delay(2);
        loginPage.checkLoginWindowIsPresent();
//        delay(2);
//                homePage.openMenu();
//        homePage.tryToAccessReleaseAdvisor();
//        delay(2);
//        loginPage.checkLoginWindowIsPresent();
//        delay(2);
//                homePage.openMenu();
//        homePage.tryToAccessStatistics();
//        delay(2);
//        loginPage.checkLoginWindowIsPresent();
//        delay(2);
//                homePage.openMenu();
//        homePage.tryToAccessCloudAdvisor();
//        delay(2);
//        loginPage.checkLoginWindowIsPresent();
    }
}
