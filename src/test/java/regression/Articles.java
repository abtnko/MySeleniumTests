//package regression;
//
//import base.BaseTests;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import pages.AllNewsPage;
//import pages.MobileNewsPage;
//
//import java.util.List;
//
//public class Articles extends BaseTests {
//
//
//    @Test
//    public void checkSubcategoryFilter() throws InterruptedException {
//        homePage.clickOnNewsMenu();
//        delay(3);
//        AllNewsPage allNewsPage = homePage.openAllNewsPage();
//        delay(2);
//        allNewsPage.uncheckAllSubcategory();
//        allNewsPage.chooseAdobeSubcategory();
//        allNewsPage.clickOnFilterButton();
//        delay(2);
//        allNewsPage.checkOnlyAdobeArticlesAreDisplayed();
//    }
//
//    @Test
//    public void checkDateCoverage(){
//        homePage.clickOnNewsMenu();
//        delay(3);
//        MobileNewsPage mobileNewsPage = homePage.openMobileNewsPage();
//        delay(2);
//        mobileNewsPage.setStartDate("01/01/2019");
//        mobileNewsPage.setEndDate("02/01/2019");
//        mobileNewsPage.clickOnDateCoverageTitle();
//        mobileNewsPage.clickOnFilterButton();
//        delay(3);
//        mobileNewsPage.checkArticlesAreWithCorrectDates("01 Jan 2019","02 Jan 2019");
//    }
//
//}
