package lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.MyListsPageObject;
import lib.ui.android.AndroidMyListsPageObjectPageObject;
import lib.ui.ios.IosMyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListsPageObject get(RemoteWebDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObjectPageObject(appiumDriver);
        } else {
            return new IosMyListsPageObject(appiumDriver);
        }
    }
}
