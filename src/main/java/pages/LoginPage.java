package pages;

import base.BaseTests;
import base.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BaseTests {

    private WebDriver driver;
    private By loginField = By.xpath("//*[@type='email']");
    private By passwordField = By.id("input-password");
    private By loginButton = By.xpath("//button[contains(text(), 'LOG IN')]");
    private By errorAlert = By.className("p-incorrect-password");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCorrectLogin(User user) {
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(user.getEmail());
    }

    public void setWrongLogin(String login) {
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(login);
    }

    public void setCorrectPassword (User user) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(user.getPassword());
    }

    public void setChangedPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setWrongPassword (String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public String getErrorAlert() {
        return driver.findElement(errorAlert).getText();
    }

    public DashboardPage clickLoginButton () {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public void checkLoginWindowIsPresent(){
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());
    }


}
