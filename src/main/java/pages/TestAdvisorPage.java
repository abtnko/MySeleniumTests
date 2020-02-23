package pages;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestAdvisorPage {

    private WebDriver driver;


    public TestAdvisorPage(WebDriver driver){
        this.driver = driver;
    }


    private By listWithCountries = By.id("over-select");
    private By checkboxNextToCountry = By.xpath("//input[@type='checkbox']");
    private By startDateField = By.xpath("//input[@placeholder='Select start date']");
    private By calculateButton = By.xpath("//input[@value='Calculate']");
    private By predictionsTable = By.id("predictions-table");
    private By showMore = By.id("show-more");
    private By timeSelect = By.id("time-select");
    private By changeButton = By.xpath("//div[contains(text(), 'Change')]");
    private By searchForDevice = By.xpath("//input[@placeholder='Search for a device']");
    private By searchForOS = By.xpath("//input[@placeholder='Search for an os']");
    private By chooseOSToSearch = By.xpath("//option[@value='os']");
    private By dateBox = By.className("box");
    private By month = By.xpath("//label[@for='Month']");
    private By onlineServices = By.xpath("//label[@for='desktop']");
    private By all100Positions = By.className("check-select");

    public void changeCalculation(){
        driver.findElement(changeButton).click();
    }

    public void switchToOnlineServices(){
        driver.findElement(onlineServices).click();
    }

    public void switchToMonth(){
        driver.findElement(month).click();
    }

    public void validateAllMonthsArePresent(){
        String actual = driver.findElement(timeSelect).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("1234567"));
    }

    public void validateDateBoxContainsCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        String actual = driver.findElements(dateBox).get(2).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains(currentDay));
    }

    public void searchForDevice(String deviceName){
        driver.findElement(searchForDevice).sendKeys(deviceName);
    }

    public void changeSearchToOS(){
        driver.findElement(chooseOSToSearch).click();
    }

    public void searchForOS(String os){
        driver.findElement(searchForOS).sendKeys(os);
    }

    public void validateSearchResultForOS(String osNotIncluded){
        List<WebElement> allPredictions = driver.findElements(predictionsTable);
        for (WebElement prediction : allPredictions) {
            String combination = prediction.getText();
            System.out.println(combination);
            Assert.assertFalse(combination.contains(osNotIncluded));
        }
    }

    public void validateSearchResultForDevice(String expDevice){
        List<WebElement> allPredictions = driver.findElements(predictionsTable);
        for (WebElement prediction : allPredictions) {
            String combination = prediction.getText();
            System.out.println(combination);
            Assert.assertTrue(combination.contains(expDevice));
        }
    }

    public void chooseWeekOrMonth(String weekOrMonth){
        driver.findElement(timeSelect).sendKeys(weekOrMonth);
    }

    public void clickOnCalculate(){
        driver.findElement(calculateButton).click();
    }

    public void clickOnShowMoreUntilWholeTableIsExpanded(){
        try {
            while (true)
            {
                driver.findElements(all100Positions).get(100).isDisplayed();
            }
        } catch (IndexOutOfBoundsException ex) {
            driver.findElement(showMore).click();
        }
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

    public void closeListOfArticles(){
        WebElement element = driver.findElement(listWithCountries);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickOnSelectAll(){
        driver.findElements(checkboxNextToCountry).get(0).click();
    }


    public void setStartDateWithCurrentDate() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
//        driver.findElement(startDateField).sendKeys(Keys.chord(Keys.COMMAND, "A") + Keys.SPACE);
//        Thread.sleep(2000);
        driver.findElement(startDateField).sendKeys(Keys.DELETE + currentDay);
    }

    public void setStartDateWithFutureDate() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        driver.findElement(startDateField).sendKeys(Keys.DELETE);
        Thread.sleep(2000);
//        WebElement el = driver.findElement(startDateField);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].value='27/" + currentDay + "'", el);
        driver.findElement(startDateField).sendKeys(currentDay + "/03/2020");
    }

    public void checkIfMarketSharesAreNotZero(){
        List<WebElement> allPredictions = driver.findElements(predictionsTable);
        for (WebElement prediction : allPredictions) {
            String combination = prediction.getText();
            System.out.println(combination);
            Assert.assertFalse(combination.contains("0.00%"));
        }
    }
}
