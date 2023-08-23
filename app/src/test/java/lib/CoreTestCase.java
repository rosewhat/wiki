package lib;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUIPageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomeObject;

public class CoreTestCase {
    protected RemoteWebDriver driver;
    protected SearchPageObject searchPageObject;
    protected ArticlePageObject articlePageObject;
    protected NavigationUIPageObject navigationUiPageObjectObject;
    protected MyListsPageObject myListPageObject;

    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = MyPlatform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.rotateScreenPortrait();
        this.openWikiPageForMobileWeb();
        this.createAllurePropertyFile();
    }

    @After
    @Step("Remove Driver and session")
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Step("Rotate screen to portrait mode")
    protected void rotateScreenPortrait() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait" + MyPlatform.getInstance().getPlatformVar());
        }
    }

    @Step("Rotate screen to landscape mode")
    protected void rotateScreenLandscape() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape");
        }
    }

    protected void backGroundApp(int seconds) {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(seconds);
        } else {
            System.out.println("Method backgroundApp() does nothing for platform" + MyPlatform.getInstance().getPlatformVar());
        }
    }

    private void skipWelcomePageForIosApp() {
        if (MyPlatform.getInstance().isIOS()) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomeObject welcomeObject = new WelcomeObject(driver);
            welcomeObject.clickSkip();
        }
    }

    protected void openWikiPageForMobileWeb() {
        if (MyPlatform.getInstance().isMW()) {
            driver.get("https://en.m.wikipedia.org/wiki/Main_Page");
        } else {
            System.out.println("Method openWikiWebPageMobileWeb() do nothing for platform" + MyPlatform.getInstance().getPlatformVar());
        }
    }

    private void createAllurePropertyFile() {
        // путь до директории allure
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            // текущее значение окружения
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", MyPlatform.getInstance().getPlatformVar());
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Enviroment");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }
}
