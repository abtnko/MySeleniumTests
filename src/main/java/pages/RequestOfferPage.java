package pages;

import base.User;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestOfferPage {

    private WebDriver driver;

    private By popUp = By.xpath("//h2[contains(text(),'Your request has been sent successfully.')]");
    private By requestOfferButton = By.id("save-button");
    private By firstNameField = By.xpath("//*[@placeholder='Your first name']");
    private By lastNameField = By.xpath("//*[@placeholder='Your last name']");
    private By emailField = By.xpath("//*[@placeholder='Your email']");
    private By phoneNumber = By.xpath("//*[@placeholder='Enter a phone number']");
    private By invalidFirstNameLetters = By.xpath("//span[contains(text(),'The first name field must be at least 2 characters.')]");
    private By invalidLastNameLetters = By.xpath("//span[contains(text(),'The last name field must be at least 2 characters.')]");
    private By invalidFirstNameDigits = By.xpath("//span[contains(text(),'The first name field may only contain alphabetic characters as well as spaces.')]");
    private By invalidLastNameDigits = By.xpath("//span[contains(text(),'The last name field may only contain alphabetic characters as well as spaces.')]");
    private By invalidEmail = By.xpath("//span[contains(text(),'The email field must be a valid email.')]");
    private By invalidPhoneNumber = By.xpath("//span[contains(text(),'Phone number is not a valid')]");



    public RequestOfferPage (WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(User user){
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(user.getName());
    }

    public void setLastName(User user){
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(user.getSurname());
    }

    public void setEmail(User user){
        driver.findElement(emailField).sendKeys(user.getEmail());
    }
    public void setPhoneNumber(User user){
        driver.findElement(phoneNumber).sendKeys(user.getPhoneNumber());
    }

    public void checkErrorMessageForInvalidFirstNameLetters(){
        Assert.assertTrue(driver.findElement(invalidFirstNameLetters).isDisplayed());
    }

    public void checkErrorMessageForInvalidFirstNameDigits(){
        Assert.assertTrue(driver.findElement(invalidFirstNameDigits).isDisplayed());
    }

    public void checkErrorMessageForInvalidLastNameLetters(){
        Assert.assertTrue(driver.findElement(invalidLastNameLetters).isDisplayed());
    }

    public void checkErrorMessageForInvalidLastNameDigits(){
        Assert.assertTrue(driver.findElement(invalidLastNameDigits).isDisplayed());
    }

    public void checkErrorMessageForInvalidEmail(){
        Assert.assertTrue(driver.findElement(invalidEmail).isDisplayed());
    }

    public void checkErrorMessageForInvalidPhoneNumber(){
        Assert.assertTrue(driver.findElement(invalidPhoneNumber).isDisplayed());
    }

    public void clickOnRequestOfferButton(){
        driver.findElement(requestOfferButton).click();
    }

    public void checkPresenceOfPopUp(){
        Assert.assertTrue(driver.findElement(popUp).isDisplayed());
    }

}
