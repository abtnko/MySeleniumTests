package pages;

import base.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartTrialPage {

    private WebDriver driver;
    private By emailField = By.xpath("//*[@placeholder='Email address']");
    private By passwordField = By.xpath("//*[@placeholder='Enter password']");
    private By confirmPasswordField = By.xpath("//*[@placeholder='Confirm password']");
    private By invalidEmail = By.xpath("//p[contains(text(), 'The email address field must be a valid email.')]");
    private By invalidPassword = By.xpath("//p[contains(text(), 'New password needs at least 8 characters.')]");


    public StartTrialPage (WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String password){
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void checkErrorMessageForEmail(){
        Assert.assertTrue(driver.findElement(invalidEmail).isDisplayed());
    }

    public void checkErrorMessageForPassword(){
        Assert.assertTrue(driver.findElement(invalidPassword).isDisplayed());
    }

    public RequestOfferPage clickOnRequestOffer(){
        driver.get("https://beta.insightportal.io/subscribe/request-offer");
        return new RequestOfferPage(driver);
    }


}
