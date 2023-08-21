package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyLists;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.WaitOnboardingPageObject;

public class MyListsTests extends CoreTestCase {
    private WaitOnboardingPageObject waitOnboardingPageObject;
    private SearchPageObject searchPageObject;
    private ArticlePageObject articlePageObject;
    private NavigationUI navigationUI;
    private MyLists myLists;

    @Test
    public void testSaveNewElementInList() {
        articlePageObject = new ArticlePageObject(driver);
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        navigationUI = new NavigationUI(driver);
        myLists = new MyLists(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
        articlePageObject.swipeToButtonSave();
        articlePageObject.addArticleToMyList();
        navigationUI.clickMyLists();
        // кликает по созданному списку с понрав статьями
        myLists.openFolderByName();
        // Свайп для удаления от элемента
        myLists.swipeByArticleToDelete();
        myLists.assertDeleteElementInList();
    }
}
