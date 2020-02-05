package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestAdvisorPage {

    private WebDriver driver;


    public TestAdvisorPage(WebDriver driver){
        this.driver = driver;
    }

    final String WRONG_COMBINATION_IPHONE = "iPhone 11 Pro iOS 12";

    private By listWithCountries = By.id("over-select");
    private By checkboxNextToCountry = By.xpath("//input[@type='checkbox']");
    private By startDateField = By.xpath("//input[@placeholder='Select start date']");
    private By calculateButton = By.xpath("//input[value='Calculate']");
    private By predictionsTable = By.id("predictions-table");



    public void clickOnCalculate(){
        driver.findElement(calculateButton).click();
    }

    public void clickOnDropDownBoxWithCountries(){
        driver.findElement(listWithCountries).click();
    }

    public void countCountries(){
        List<WebElement> allCountries = driver.findElements(checkboxNextToCountry);
        int countryCount = allCountries.size() - 1;
        int exp = 44;
        System.out.println("There are " + countryCount + " countries");
        Assert.assertEquals(exp, countryCount);
    }

    public void clickOnSelectAll(){
        driver.findElements(checkboxNextToCountry).get(0).click();
    }

    public void setStartDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        driver.findElement(startDateField).sendKeys(currentDay);
    }

    public void checkIfWrongCombinationsAreAbsent(){
        List<WebElement> allPredictions = driver.findElements(predictionsTable);
        String combination =
    }
}
