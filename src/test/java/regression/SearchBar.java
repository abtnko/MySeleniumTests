package regression;

import base.BaseTests;
import org.junit.Test;
import pages.AllNewsPage;


public class SearchBar extends BaseTests {

    @Test
    public void checkArticlesTitlesInSearchList(){
        String keyword = "chrome";
        homePage.clickOnNewsMenu();
        delay(3);
        AllNewsPage allNewsPage = homePage.openAllNewsPage();
        delay(2);
        allNewsPage.searchWithKeyword(keyword);
        allNewsPage.clickOnSearchButton();
        delay(2);
        allNewsPage.checkArticlesContainKeyword(keyword);
    }
}
