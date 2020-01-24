package regression;

import base.BaseTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllNewsPage;

import java.util.List;

public class Articles extends BaseTests {


//    @Test
//    Anton is fixing a bug
    public void checkSubcategoryFilter() throws InterruptedException {
        homePage.clickOnNewsMenu();
        delay(3);
        AllNewsPage allNewsPage = homePage.openAllNewsPage();
        delay(2);
        allNewsPage.uncheckAllSubcategory();
        allNewsPage.chooseAdobeSubcategory();
        allNewsPage.clickOnFilterButton();
        delay(2);
        allNewsPage.checkOnlyAdobeArticlesAreDisplayed();
    }

    @Test
    public void checkDateCoverageWorksProperly(){
        homePage.clickOnNewsMenu();
        delay(3);
        AllNewsPage allNewsPage = homePage.openAllNewsPage();
        delay(2);
        allNewsPage.setStartDate();
        allNewsPage.setEndDate();
        allNewsPage.clickOnFilterButton();
        delay(2);
//        allNewsPage.checkArticlesAreInRangeOfChosenDates();
    }

}
