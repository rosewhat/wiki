package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.MyPlatform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUIPageObject;
import lib.ui.WaitOnboardingPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WaitOnBoardingObjectFactory;

public class SearchTests extends CoreTestCase {
    private static final String SEARCH_LINE = "Java";
    private WaitOnboardingPageObject waitOnboardingPageObject;
    private ArticlePageObject articlePageObject;
    private NavigationUIPageObject navigationUIPageObject;
    private MyListsPageObject myListsPageObject;

    @Test
    public void testAmountOfEmptySearch() {

        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        // Вписываем в editText всякую фигню
        String search_line = "fdsfsdfdsdsgdfg";
        searchPageObject.typeSearchLine(search_line);
    }

    @Test
    public void testChangeScreenOrientationOnSearchResult() {
        searchPageObject = SearchPageObjectFactory.get(driver);
        articlePageObject = ArticlePageObjectFactory.get(driver);
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        // Находим статью из главного экрана
        String title_before_rotation = articlePageObject.getArticleTitle();
        rotateScreenLandscape();
        searchPageObject.simpleSwipeUp();
        // Находим статью из главного экрана
        String title_after_rotation = articlePageObject.getArticleTitle();
        assertEquals(
                "Заголовки до переворота и после не совпадают",
                title_before_rotation,
                title_after_rotation);
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        searchPageObject = SearchPageObjectFactory.get(driver);
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(SEARCH_LINE);
        //Находим xpath то что он вообще создался
        searchPageObject.getAmountGetArticles();
        backGroundApp(2);
        //Находим xpath то что он вообще создался
        searchPageObject.getAmountGetArticles();
    }

    @Test
    public void testSearch() {
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        searchPageObject = SearchPageObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(SEARCH_LINE);
        searchPageObject.waitForSearchResult("Wikimedia list article");
    }

    @Test
    public void testCanselSearch() {
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        searchPageObject = SearchPageObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        String search_line = "Java";
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.waitForCanselButtonToAppear();
        searchPageObject.waitForCanselButtonToAppear();
        searchPageObject.waitForCanselButtonToDisappear();
    }

    @Test
    public void testSwipeArticle() {
        articlePageObject = ArticlePageObjectFactory.get(driver);
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        articlePageObject.swipeDownToFindElement();
    }


    @Test
    public void testAmountOfNotEmptySearch() {
        searchPageObject = SearchPageObjectFactory.get(driver);
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(SEARCH_LINE);
        searchPageObject.getAmountGetArticles();
        // проверить кол-во элементов, если больше 1 то ок
        int amount_of_search_results = searchPageObject.getAmountGetArticles();
        assertTrue(
                "Элементов вообще нет",
                amount_of_search_results > 0
        );
    }

    public void swipeToFooter() {
        if (MyPlatform.getInstance().isIOS()) {
            swipeToFooter();
        }
    }
}
