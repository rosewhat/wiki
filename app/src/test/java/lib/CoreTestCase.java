package lib;

import junit.framework.TestCase;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUIPageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomeObject;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    protected SearchPageObject searchPageObject;
        protected ArticlePageObject articlePageObject;
    protected NavigationUIPageObject navigationUiPageObjectObject;
    protected MyListsPageObject myListPageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver = MyPlatform.getInstance().getDriver();
        this.rotateScreenPortrait();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backGroundApp(int seconds) {
        driver.runAppInBackground(seconds);
    }

    private void skipWelcomePageForIosApp() {
        if (MyPlatform.getInstance().isIOS()) {
            WelcomeObject welcomeObject = new WelcomeObject(driver);
            welcomeObject.clickSkip();
        }
    }


}
