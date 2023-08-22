package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUIPageObject;
import lib.ui.SearchPageObject;
import lib.ui.WaitOnboardingPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.WaitOnBoardingObjectFactory;

public class MyListsPageObjectTests extends CoreTestCase {
    private WaitOnboardingPageObject waitOnboardingPageObject;
    private SearchPageObject searchPageObject;
    private ArticlePageObject articlePageObject;
    private NavigationUIPageObject navigationUIPageObject;
    private MyListsPageObject myListsPageObject;

    @Test
    public void testSaveNewElementInList() {
        articlePageObject = ArticlePageObjectFactory.get(driver);
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
    //123    navigationUIPageObject = NavigationU;
        myListsPageObject = MyListsPageObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        articlePageObject.swipeToButtonSave();
        articlePageObject.addArticleToMyList();
        navigationUIPageObject.clickMyLists();
        // кликает по созданному списку с понрав статьями
        myListsPageObject.openFolderByName();
        // Свайп для удаления от элемента
        myListsPageObject.swipeByArticleToDelete();
        myListsPageObject.assertDeleteElementInList();
    }
}
