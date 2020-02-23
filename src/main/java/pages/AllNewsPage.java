package pages;

import org.testng.Assert;
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
    private By listOfArticles = By.className("row articles");
    final String ADOBE = "Adobe";
    private By searchBar = By.id("searchbar");
    private By searchButton = By.xpath("//input[@type='submit']");


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
        List<WebElement> allArticles = (List<WebElement>) driver.findElements(listOfArticles);
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(ADOBE));
        }
    }

    public void checkArticlesContainKeyword(String keyword){
        List<WebElement> allArticles = driver.findElements(listOfArticles);
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
//            boolean isContain = name.contains(keyword) || name.contains(keyword.toLowerCase());
            Assert.assertTrue(name.contains(keyword.toUpperCase()));
        }
    }

    public void searchWithKeyword(String keyword){
        driver.findElement(searchBar).sendKeys(keyword);
    }

    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }
}
