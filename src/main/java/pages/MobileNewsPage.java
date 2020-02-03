package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MobileNewsPage {
    private WebDriver driver;

    public MobileNewsPage(WebDriver driver){
        this.driver = driver;

    }

    private By startDate = By.xpath("//input[@placeholder='Select start date']");
    private By endDate = By.xpath("//input[@placeholder='Select end date']");
    private By filter = By.id("filter-button");
    private By listOfArticles = By.xpath("//div[@id='child-of-container'][2]");
    private By dateCoverageTitle = By.className("graph-title");
    private By datesOfArticles = By.className("row articles");


    public void clickOnFilterButton(){
        driver.findElement(filter).click();
    }

    public void clickOnDateCoverageTitle(){
        driver.findElement(dateCoverageTitle).click();
    }

    public void setEndDate(String endD){
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String currentDay = dateFormat.format(date);
        driver.findElement(endDate).sendKeys(endD + "\n");
    }

    public void setStartDate(String startD){
//        Calendar c1 = Calendar.getInstance();
//        int date = c1.getFirstDayOfWeek();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String firstDayOfWeek = dateFormat.format(date);
        driver.findElement(startDate).sendKeys(startD + "\n");
    }

    public boolean checkArticlesAreWithCorrectDates(String startDate, String endDate){
        List<WebElement> allArticles = driver.findElements(datesOfArticles);
        for (WebElement article : allArticles) {
            String date = article.getText();
            System.out.println(date);
            if (date.contains(startDate)){
                System.out.println("Article has a date " + startDate + " which is within the range");
            } else if (date.contains(endDate)){
                System.out.println("Article has a date " + endDate + " which is within the range");
            } else {
                return false;
            }
        }
        return true;
    }

}
