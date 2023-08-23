package lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.SearchPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.IOSSearchPageObject;
import lib.ui.mobile_web.MySearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(appiumDriver);
        } else if (MyPlatform.getInstance().isMW()) {
            return new MySearchPageObject(appiumDriver);
        } else {
            return new IOSSearchPageObject(appiumDriver);
        }
    }
}
