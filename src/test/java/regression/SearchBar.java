package regression;

import base.BaseTests;
import org.junit.Test;


public class SearchBar extends BaseTests {
    @Test
    public void validateTitlesInList(){
        homePage.searchForArticle("iOS");
        homePage.checkArticlesList("iOS");
    }
}
