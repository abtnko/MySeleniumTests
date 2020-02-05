package pages;

import base.BaseTests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.SocketImpl;
import java.util.List;


public class HomePage extends BaseTests {

    private WebDriver driver;

    private By startTrial = By.className("start-trial-text");
    private By loginIcon = By.xpath("//span[contains(text(), 'Login')]");
    private By tools = By.xpath("//div[contains(text(), 'Tools')]");
    private By news = By.xpath("//div[@class='news']");
    private By testAdvisor = By.xpath("//div[contains(text(), 'TestAdvisor')]");
    private By releaseAdvisor = By.xpath("//div[contains(text(), 'ReleaseAdvisor')]");
    private By statistics = By.xpath("//div[contains(text(), 'Statistics')]");
    private By cloudAdvisor = By.xpath("//div[contains(text(), 'CloudAdvisor')]");
    private By allNews = By.xpath("//div[contains(text(), 'All News')]");
    private By mobileNews = By.xpath("//div[contains(text(), 'Mobile News')]");
    private By facebook = By.xpath("//img[@alt='Facebook']");
    private By twitter = By.xpath("//img[@alt='Twitter']");
    private By linkedIn = By.xpath("//img[@alt='LinkedIn']");
    private By youtube = By.xpath("//img[@alt='Youtube']");
    private By searchBar = By.id("searchbar");
    private By search = By.xpath("//input[@type='submit']");
    private By searchResults = By.id("child-of-container");
    private By closeButton = By.xpath("//span[@class='close']");
    private By cookiesBanner = By.xpath("//div[@class='banner-child']");
    private By mainMenu = By.xpath("//img[@alt='Menu']");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void openMenu(){
        driver.findElement(mainMenu).click();
    }


    public void checkCookiesBannerIsPresent(){
        Assert.assertTrue(driver.findElement(cookiesBanner).isDisplayed());
    }

    public CloudAdvisorPage clickOnCloudAdvisor(){
        try {
            driver.findElement(cloudAdvisor).click();

        } catch(Exception e) {
            clickOnTools();
            delay(2);
            driver.findElement(cloudAdvisor).click();
        }
        return new CloudAdvisorPage(driver);
    }

    public TestAdvisorPage clickOnTestAdvisor(){
        driver.findElement(testAdvisor).click();
        return new TestAdvisorPage(driver);
    }

    public LoginPage clickOnLoginIcon () {
        driver.findElement(loginIcon).click();
        delay(5);
        return new LoginPage(driver);
    }

    public void dismissCookiesBanner(){
        try {
            driver.findElement(closeButton).click();
        } catch (Exception e){
            System.out.println("Cookies banner is not present");
        }
    }

    public StartTrialPage clickOnStartTrial(){
        try {
            driver.findElement(startTrial).click();
        } catch (Exception e) {
            System.out.println("Is already on start trial page");
        }
        return new StartTrialPage(driver);
    }

    public void clickOnTools(){
        driver.findElement(tools).click();
    }

    public LoginPage tryToAccessTestAdvisor(){
        driver.findElement(testAdvisor).click();
        return new LoginPage(driver);
    }

    public LoginPage tryToAccessReleaseAdvisor(){
        driver.findElement(releaseAdvisor).click();
        return new LoginPage(driver);
    }

    public LoginPage tryToAccessStatistics(){
        driver.findElement(statistics).click();
        return new LoginPage(driver);
    }

    public LoginPage tryToAccessCloudAdvisor(){
        driver.findElement(cloudAdvisor).click();
        return new LoginPage(driver);
    }

    public void clickOnNewsMenu(){
        driver.findElement(news).click();
    }

    public AllNewsPage openAllNewsPage(){
        driver.findElement(allNews).click();
        return new AllNewsPage(driver);
    }

    public SocialMediaPages clickOnFacebookLink(){
        driver.findElement(facebook).click();
        return new SocialMediaPages(driver);
    }

    public SocialMediaPages clickOnTwitterLink(){
        driver.findElement(twitter).click();
        return new SocialMediaPages(driver);
    }

    public SocialMediaPages clickOnYoutubeLink(){
        driver.findElement(youtube).click();
        return new SocialMediaPages(driver);
    }

    public SocialMediaPages clickOnLinkedInLink(){
        driver.findElement(linkedIn).click();
        return new SocialMediaPages(driver);
    }

    public void searchForArticle(String title){
        driver.findElement(searchBar).sendKeys(title);
        driver.findElement(search).click();
    }

    public void checkArticlesList(String searchedWord){
        List<WebElement> allArticles = driver.findElements(searchResults);
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(searchedWord));
        }
    }



    public RequestOfferPage goToRequestOfferPage(){
        driver.get("https://www.insightportal.io/subscribe/request-offer");
        return new RequestOfferPage(driver);
    }

    public MobileNewsPage openMobileNewsPage(){
        driver.findElement(mobileNews).click();
        return new MobileNewsPage(driver);
    }
}
