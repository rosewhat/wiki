package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.SearchPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.IOSSearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(AppiumDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(appiumDriver);
        } else {
            return new IOSSearchPageObject(appiumDriver);
        }
    }
}
