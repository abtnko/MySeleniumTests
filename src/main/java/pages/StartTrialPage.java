package pages;

import base.User;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartTrialPage {

    private WebDriver driver;
    private By emailField = By.xpath("//*[@placeholder='Email address']");
    private By passwordField = By.xpath("//*[@placeholder='Enter password']");
    private By confirmPasswordField = By.xpath("//*[@placeholder='Confirm password']");
    private By invalidEmail = By.xpath("//p[contains(text(), 'The email address field must be a valid email.')]");
    private By atLeastEightCharacters = By.xpath("//p[contains(text(), 'New password needs at least 8 characters.')]");
    private By cannotBeLongerThanFifty = By.xpath("//p[contains(text(), 'New password cannot be longer than 50 characters.')]");
    private By oneUppercaseNeeded = By.xpath("//p[contains(text(), 'One uppercase letter required.')]");
    private By oneLowercaseNeeded = By.xpath("//p[contains(text(), 'One lowercase letter required.')]");
    private By oneNumberNeeded = By.xpath("//p[contains(text(), 'One number required.')]");
    private By oneLowercaseLetterNeeded = By.xpath("//p[contains(text(), 'One lowercase letter required.')]");
    private By emailMustBeValid = By.xpath("//p[contains(text(), 'The email address field must be a valid email.')]");
    private By passwordDoesntMatch = By.xpath("//p[contains(text(), 'Password does not match the confirm password.')]");


//    private By requestOffer = By.xpath("//a[@href= '/subscribe/request-offer']"); --> Does not work


    public StartTrialPage (WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(User user){
        driver.findElement(emailField).sendKeys(user.getEmail());
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

    public void checkErrorMessageForLessEight(){
        Assert.assertTrue(driver.findElement(atLeastEightCharacters).isDisplayed());
    }

    public void checkErrorMessageForMoreFifty(){
        Assert.assertTrue(driver.findElement(cannotBeLongerThanFifty).isDisplayed());
    }

    public void checkErrorMessageForLowercaseLetters(){
        Assert.assertTrue(driver.findElement(oneUppercaseNeeded).isDisplayed());
    }

    public void checkErrorMessageForUppercaseLetters(){
        Assert.assertTrue(driver.findElement(oneLowercaseNeeded).isDisplayed());
    }


    public void checkErrorMessageForOnlyLetters(){
        Assert.assertTrue(driver.findElement(oneNumberNeeded).isDisplayed());
    }

    public void checkErrorMessageForOnlyDigits(){
        Assert.assertTrue(driver.findElement(oneLowercaseLetterNeeded).isDisplayed());
    }

    public void checkErrorMessageForInvalidEmail(){
        Assert.assertTrue(driver.findElement(emailMustBeValid).isDisplayed());
    }

    public void checkErrorMessageForNotMatchingPasswords(){
        Assert.assertTrue(driver.findElement(passwordDoesntMatch).isDisplayed());
    }
}
