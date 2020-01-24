package pages;

import base.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MyAccountPage {

    private WebDriver driver;

    private By passwordField = By.name("password");
    private By saveButton = By.id("save-button");
    private By popUp = By.xpath("//h2[contains(text(), 'Well Done')]");
    private By okButton = By.xpath("//button[contains(text(), 'OK')]");
    private By invalidPassword = By.className("p-incorrect-password");

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterCurrentPasswordString(String password) {
        driver.findElements(passwordField).get(0).sendKeys(password);
    }
    public void enterCurrentPasswordUser(User user) {
        driver.findElements(passwordField).get(0).sendKeys(user.getPassword());
    }

    public void enterNewPasswordString(String password) {
        driver.findElements(passwordField).get(1).sendKeys(password);
    }

    public void enterNewPasswordUser(User user) {
        driver.findElements(passwordField).get(1).sendKeys(user.getPassword());
    }

    public void confirmNewPasswordString(String password){
        driver.findElements(passwordField).get(2).sendKeys(password);
    }

    public void confirmNewPasswordUser(User user){
        driver.findElements(passwordField).get(2).sendKeys(user.getPassword());
    }

    public void clickOnSaveButton(){
        driver.findElement(saveButton).click();
    }

    public void checkPresenceOfPopUp(){
        assertTrue(driver.findElement(popUp).isDisplayed());
    }

    public void closePopUp(){
        driver.findElement(okButton).click();
    }

    public void checkAlertTextForLetters(){
        assertTrue(driver.findElement(invalidPassword).getText().contains("One number required."));
    }

    public void checkAlertTextForDigits(){
        assertTrue(driver.findElement(invalidPassword).getText().contains("One lowercase letter required."));
    }


    public void checkAlertTextForCharacters(){
        assertTrue(driver.findElement(invalidPassword).getText().contains("New password needs at least 8 characters."));
    }

    public void checkAlertTextForMismatch(){
        assertTrue(driver.findElement(invalidPassword).getText().contains("New password does not match the confirm password."));
    }

    public void checkAlertTextForMoreThanFifty(){
        assertTrue(driver.findElement(invalidPassword).getText().contains("New password cannot be longer than 50 characters."));
    }


    public void checkAlertTextForSamePasswordAsOld(){
        assertTrue(driver.findElement(invalidPassword).getText().contains("New password must be different from the old one."));
    }

}
