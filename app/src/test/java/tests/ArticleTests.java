package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyLists;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.WaitOnboardingPageObject;

public class ArticleTests extends CoreTestCase {
    private WaitOnboardingPageObject waitOnboardingPageObject;
    private SearchPageObject searchPageObject;
    private ArticlePageObject articlePageObject;
    private NavigationUI navigationUI;
    private MyLists myLists;
    @Test
    public void testCompareArticleTitle() {
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        searchPageObject = new SearchPageObject(driver);
        articlePageObject = new ArticlePageObject(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        // Находим статью из главного экрана
        articlePageObject.waitForTitleElement();
        String article_title = articlePageObject.getArticleTitle();
        assertEquals("Не получилось сравнить",
                "Xá Lợi Pagoda raids",
                article_title
        );
    }
}
