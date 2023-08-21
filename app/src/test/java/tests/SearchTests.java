package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyLists;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.WaitOnboardingPageObject;

public class SearchTests extends CoreTestCase {
    private static final String SEARCH_LINE = "Java";
    private WaitOnboardingPageObject waitOnboardingPageObject;
    private SearchPageObject searchPageObject;
    private ArticlePageObject articlePageObject;
    private NavigationUI navigationUI;
    private MyLists myLists;

    @Test
    public void testAmountOfEmptySearch() {
        searchPageObject = new SearchPageObject(driver);
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        // Вписываем в editText всякую фигню
        String search_line = "fdsfsdfdsdsgdfg";
        searchPageObject.typeSearchLine(search_line);
    }

    @Test
    public void testChangeScreenOrientationOnSearchResult() {
        searchPageObject = new SearchPageObject(driver);
        articlePageObject = new ArticlePageObject(driver);
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
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
        searchPageObject = new SearchPageObject(driver);
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
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
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        searchPageObject = new SearchPageObject(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(SEARCH_LINE);
        searchPageObject.waitForSearchResult("Wikimedia list article");
    }

    @Test
    public void testCanselSearch() {
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        searchPageObject = new SearchPageObject(driver);
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
        articlePageObject = new ArticlePageObject(driver);
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        articlePageObject.swipeDownToFindElement();
    }


    @Test
    public void testAmountOfNotEmptySearch() {
        searchPageObject = new SearchPageObject(driver);
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
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
}
