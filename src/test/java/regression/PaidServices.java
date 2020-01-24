package regression;


import base.BaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

public class PaidServices extends BaseTests {
    @Test
    public void paidServiceNotVisibleForNotLoggedUser() {
        homePage.clickOnTools();
        LoginPage loginPage = homePage.tryToAccessPaidService();
        delay(2);
        loginPage.checkLoginWindowIsPresent();
    }
}
