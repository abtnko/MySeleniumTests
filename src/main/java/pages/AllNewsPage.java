package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AllNewsPage {

    private WebDriver driver;
    private By all = By.id("ch-all");
    private By adobe = By.id("adobe");
    private By filter = By.id("filter-button");
    private By listOfArticles = By.id("child-of-container");
    final String ADOBE = "Adobe";
    private By enableFilter = By.xpath("//input[@id='datepicker-control-input']");
    private By startDate = By.xpath("//input[@placeholder='Select start date']");
    private By endDate = By.xpath("//input[@placeholder='Select end date']");


    public AllNewsPage (WebDriver driver){
        this.driver = driver;
    }

//    public void checkArticlesAreInRangeOfChosenDates(){
//        Calendar c1 = Calendar.getInstance();
//        int date = c1.getFirstDayOfWeek();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String firstDayOfWeek = dateFormat.format(date);
//
//        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
//        LocalDate weekAgo = LocalDate.now().minusDays(7);
//        String weekAgoFormatted = dateFormat.format(weekAgo);
//        Assert.assertTrue(driver.findElements(listOfArticles).contains(firstDayOfWeek));
//    }

    public void setEndDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDay = dateFormat.format(date);
        driver.findElement(startDate).sendKeys(currentDay);
    }

    public void setStartDate(){
        Calendar c1 = Calendar.getInstance();
        int date = c1.getFirstDayOfWeek();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String firstDayOfWeek = dateFormat.format(date);
        driver.findElement(endDate).sendKeys(firstDayOfWeek);
    }


    public void uncheckAllSubcategory(){
        driver.findElement(all).click();
    }

    public void chooseAdobeSubcategory(){
        driver.findElement(adobe).click();
    }

    public void clickOnFilterButton(){
        driver.findElement(filter).click();
    }

    public void checkOnlyAdobeArticlesAreDisplayed(){
        List<WebElement> allArticles = driver.findElements(listOfArticles);
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(ADOBE));
        }
    }
}
