package pages;

import base.BaseTests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BaseTests {

    private WebDriver driver;
    private By userBanner = By.id("banner-name");
    private By logOut = By.xpath("//span[contains(text(), 'Log out')]");

    //    private By myAccount = By.xpath("//span[contains(text(), ' My Account')]"); -> Is not working

    public DashboardPage (WebDriver driver){
        this.driver = driver;
    }

    public String getUserBannerText(){
        return driver.findElement(userBanner).getText();
    }

    public MyAccountPage goToMyAccount() {
        driver.get("https://www.insightportal.io/account");
        delay(2);
        return new MyAccountPage(driver);
    }

    public TestAdvisorPage goToTestAdvisor(){
        driver.get("https://www.insightportal.io/testadvisor");
        return new TestAdvisorPage(driver);
    }


    public HomePage logOut() {
        try {
            driver.findElement(logOut).click();
            delay(2);
        } catch (Exception e) {
            System.out.println("User was not logged in");
        }
        return new HomePage(driver);
    }


}
