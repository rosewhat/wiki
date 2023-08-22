package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUIPageObject;
import lib.ui.WaitOnboardingPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WaitOnBoardingObjectFactory;

public class ArticleTests extends CoreTestCase {
    private WaitOnboardingPageObject waitOnboardingPageObject;
    private NavigationUIPageObject navigationUIPageObject;
    private MyListsPageObject myListsPageObject;

    @Test
    public void testCompareArticleTitle() {
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        searchPageObject = SearchPageObjectFactory.get(driver);
        articlePageObject = ArticlePageObjectFactory.get(driver);
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
